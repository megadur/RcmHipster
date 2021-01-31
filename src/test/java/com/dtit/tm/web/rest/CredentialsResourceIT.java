package com.dtit.tm.web.rest;

import com.dtit.tm.RcmDemoMsApp;
import com.dtit.tm.domain.Credentials;
import com.dtit.tm.repository.CredentialsRepository;
import com.dtit.tm.service.CredentialsService;
import com.dtit.tm.service.dto.CredentialsDTO;
import com.dtit.tm.service.mapper.CredentialsMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link CredentialsResource} REST controller.
 */
@SpringBootTest(classes = RcmDemoMsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class CredentialsResourceIT {

    private static final String DEFAULT_TONR = "AAAAAAAAAA";
    private static final String UPDATED_TONR = "BBBBBBBBBB";

    private static final String DEFAULT_ASK = "AAAAAAAAAA";
    private static final String UPDATED_ASK = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORD = "BBBBBBBBBB";

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private CredentialsMapper credentialsMapper;

    @Autowired
    private CredentialsService credentialsService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCredentialsMockMvc;

    private Credentials credentials;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Credentials createEntity(EntityManager em) {
        Credentials credentials = new Credentials()
            .tonr(DEFAULT_TONR)
            .ask(DEFAULT_ASK)
            .password(DEFAULT_PASSWORD);
        return credentials;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Credentials createUpdatedEntity(EntityManager em) {
        Credentials credentials = new Credentials()
            .tonr(UPDATED_TONR)
            .ask(UPDATED_ASK)
            .password(UPDATED_PASSWORD);
        return credentials;
    }

    @BeforeEach
    public void initTest() {
        credentials = createEntity(em);
    }

    @Test
    @Transactional
    public void createCredentials() throws Exception {
        int databaseSizeBeforeCreate = credentialsRepository.findAll().size();
        // Create the Credentials
        CredentialsDTO credentialsDTO = credentialsMapper.toDto(credentials);
        restCredentialsMockMvc.perform(post("/api/credentials")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(credentialsDTO)))
            .andExpect(status().isCreated());

        // Validate the Credentials in the database
        List<Credentials> credentialsList = credentialsRepository.findAll();
        assertThat(credentialsList).hasSize(databaseSizeBeforeCreate + 1);
        Credentials testCredentials = credentialsList.get(credentialsList.size() - 1);
        assertThat(testCredentials.getTonr()).isEqualTo(DEFAULT_TONR);
        assertThat(testCredentials.getAsk()).isEqualTo(DEFAULT_ASK);
        assertThat(testCredentials.getPassword()).isEqualTo(DEFAULT_PASSWORD);
    }

    @Test
    @Transactional
    public void createCredentialsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = credentialsRepository.findAll().size();

        // Create the Credentials with an existing ID
        credentials.setId(1L);
        CredentialsDTO credentialsDTO = credentialsMapper.toDto(credentials);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCredentialsMockMvc.perform(post("/api/credentials")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(credentialsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Credentials in the database
        List<Credentials> credentialsList = credentialsRepository.findAll();
        assertThat(credentialsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCredentials() throws Exception {
        // Initialize the database
        credentialsRepository.saveAndFlush(credentials);

        // Get all the credentialsList
        restCredentialsMockMvc.perform(get("/api/credentials?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(credentials.getId().intValue())))
            .andExpect(jsonPath("$.[*].tonr").value(hasItem(DEFAULT_TONR)))
            .andExpect(jsonPath("$.[*].ask").value(hasItem(DEFAULT_ASK)))
            .andExpect(jsonPath("$.[*].password").value(hasItem(DEFAULT_PASSWORD)));
    }
    
    @Test
    @Transactional
    public void getCredentials() throws Exception {
        // Initialize the database
        credentialsRepository.saveAndFlush(credentials);

        // Get the credentials
        restCredentialsMockMvc.perform(get("/api/credentials/{id}", credentials.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(credentials.getId().intValue()))
            .andExpect(jsonPath("$.tonr").value(DEFAULT_TONR))
            .andExpect(jsonPath("$.ask").value(DEFAULT_ASK))
            .andExpect(jsonPath("$.password").value(DEFAULT_PASSWORD));
    }
    @Test
    @Transactional
    public void getNonExistingCredentials() throws Exception {
        // Get the credentials
        restCredentialsMockMvc.perform(get("/api/credentials/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCredentials() throws Exception {
        // Initialize the database
        credentialsRepository.saveAndFlush(credentials);

        int databaseSizeBeforeUpdate = credentialsRepository.findAll().size();

        // Update the credentials
        Credentials updatedCredentials = credentialsRepository.findById(credentials.getId()).get();
        // Disconnect from session so that the updates on updatedCredentials are not directly saved in db
        em.detach(updatedCredentials);
        updatedCredentials
            .tonr(UPDATED_TONR)
            .ask(UPDATED_ASK)
            .password(UPDATED_PASSWORD);
        CredentialsDTO credentialsDTO = credentialsMapper.toDto(updatedCredentials);

        restCredentialsMockMvc.perform(put("/api/credentials")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(credentialsDTO)))
            .andExpect(status().isOk());

        // Validate the Credentials in the database
        List<Credentials> credentialsList = credentialsRepository.findAll();
        assertThat(credentialsList).hasSize(databaseSizeBeforeUpdate);
        Credentials testCredentials = credentialsList.get(credentialsList.size() - 1);
        assertThat(testCredentials.getTonr()).isEqualTo(UPDATED_TONR);
        assertThat(testCredentials.getAsk()).isEqualTo(UPDATED_ASK);
        assertThat(testCredentials.getPassword()).isEqualTo(UPDATED_PASSWORD);
    }

    @Test
    @Transactional
    public void updateNonExistingCredentials() throws Exception {
        int databaseSizeBeforeUpdate = credentialsRepository.findAll().size();

        // Create the Credentials
        CredentialsDTO credentialsDTO = credentialsMapper.toDto(credentials);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCredentialsMockMvc.perform(put("/api/credentials")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(credentialsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Credentials in the database
        List<Credentials> credentialsList = credentialsRepository.findAll();
        assertThat(credentialsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCredentials() throws Exception {
        // Initialize the database
        credentialsRepository.saveAndFlush(credentials);

        int databaseSizeBeforeDelete = credentialsRepository.findAll().size();

        // Delete the credentials
        restCredentialsMockMvc.perform(delete("/api/credentials/{id}", credentials.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Credentials> credentialsList = credentialsRepository.findAll();
        assertThat(credentialsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
