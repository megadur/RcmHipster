package com.dtit.tm.web.rest;

import com.dtit.tm.RcmHipsterApp;
import com.dtit.tm.domain.IpCredentails;
import com.dtit.tm.repository.IpCredentailsRepository;
import com.dtit.tm.service.IpCredentailsService;
import com.dtit.tm.service.dto.IpCredentailsDTO;
import com.dtit.tm.service.mapper.IpCredentailsMapper;

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
 * Integration tests for the {@link IpCredentailsResource} REST controller.
 */
@SpringBootTest(classes = RcmHipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class IpCredentailsResourceIT {

    private static final String DEFAULT_TO_NR = "AAAAAAAAAA";
    private static final String UPDATED_TO_NR = "BBBBBBBBBB";

    @Autowired
    private IpCredentailsRepository ipCredentailsRepository;

    @Autowired
    private IpCredentailsMapper ipCredentailsMapper;

    @Autowired
    private IpCredentailsService ipCredentailsService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restIpCredentailsMockMvc;

    private IpCredentails ipCredentails;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IpCredentails createEntity(EntityManager em) {
        IpCredentails ipCredentails = new IpCredentails()
            .toNr(DEFAULT_TO_NR);
        return ipCredentails;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IpCredentails createUpdatedEntity(EntityManager em) {
        IpCredentails ipCredentails = new IpCredentails()
            .toNr(UPDATED_TO_NR);
        return ipCredentails;
    }

    @BeforeEach
    public void initTest() {
        ipCredentails = createEntity(em);
    }

    @Test
    @Transactional
    public void createIpCredentails() throws Exception {
        int databaseSizeBeforeCreate = ipCredentailsRepository.findAll().size();
        // Create the IpCredentails
        IpCredentailsDTO ipCredentailsDTO = ipCredentailsMapper.toDto(ipCredentails);
        restIpCredentailsMockMvc.perform(post("/api/ip-credentails")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipCredentailsDTO)))
            .andExpect(status().isCreated());

        // Validate the IpCredentails in the database
        List<IpCredentails> ipCredentailsList = ipCredentailsRepository.findAll();
        assertThat(ipCredentailsList).hasSize(databaseSizeBeforeCreate + 1);
        IpCredentails testIpCredentails = ipCredentailsList.get(ipCredentailsList.size() - 1);
        assertThat(testIpCredentails.getToNr()).isEqualTo(DEFAULT_TO_NR);
    }

    @Test
    @Transactional
    public void createIpCredentailsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = ipCredentailsRepository.findAll().size();

        // Create the IpCredentails with an existing ID
        ipCredentails.setId(1L);
        IpCredentailsDTO ipCredentailsDTO = ipCredentailsMapper.toDto(ipCredentails);

        // An entity with an existing ID cannot be created, so this API call must fail
        restIpCredentailsMockMvc.perform(post("/api/ip-credentails")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipCredentailsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IpCredentails in the database
        List<IpCredentails> ipCredentailsList = ipCredentailsRepository.findAll();
        assertThat(ipCredentailsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllIpCredentails() throws Exception {
        // Initialize the database
        ipCredentailsRepository.saveAndFlush(ipCredentails);

        // Get all the ipCredentailsList
        restIpCredentailsMockMvc.perform(get("/api/ip-credentails?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ipCredentails.getId().intValue())))
            .andExpect(jsonPath("$.[*].toNr").value(hasItem(DEFAULT_TO_NR)));
    }
    
    @Test
    @Transactional
    public void getIpCredentails() throws Exception {
        // Initialize the database
        ipCredentailsRepository.saveAndFlush(ipCredentails);

        // Get the ipCredentails
        restIpCredentailsMockMvc.perform(get("/api/ip-credentails/{id}", ipCredentails.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(ipCredentails.getId().intValue()))
            .andExpect(jsonPath("$.toNr").value(DEFAULT_TO_NR));
    }
    @Test
    @Transactional
    public void getNonExistingIpCredentails() throws Exception {
        // Get the ipCredentails
        restIpCredentailsMockMvc.perform(get("/api/ip-credentails/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateIpCredentails() throws Exception {
        // Initialize the database
        ipCredentailsRepository.saveAndFlush(ipCredentails);

        int databaseSizeBeforeUpdate = ipCredentailsRepository.findAll().size();

        // Update the ipCredentails
        IpCredentails updatedIpCredentails = ipCredentailsRepository.findById(ipCredentails.getId()).get();
        // Disconnect from session so that the updates on updatedIpCredentails are not directly saved in db
        em.detach(updatedIpCredentails);
        updatedIpCredentails
            .toNr(UPDATED_TO_NR);
        IpCredentailsDTO ipCredentailsDTO = ipCredentailsMapper.toDto(updatedIpCredentails);

        restIpCredentailsMockMvc.perform(put("/api/ip-credentails")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipCredentailsDTO)))
            .andExpect(status().isOk());

        // Validate the IpCredentails in the database
        List<IpCredentails> ipCredentailsList = ipCredentailsRepository.findAll();
        assertThat(ipCredentailsList).hasSize(databaseSizeBeforeUpdate);
        IpCredentails testIpCredentails = ipCredentailsList.get(ipCredentailsList.size() - 1);
        assertThat(testIpCredentails.getToNr()).isEqualTo(UPDATED_TO_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingIpCredentails() throws Exception {
        int databaseSizeBeforeUpdate = ipCredentailsRepository.findAll().size();

        // Create the IpCredentails
        IpCredentailsDTO ipCredentailsDTO = ipCredentailsMapper.toDto(ipCredentails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIpCredentailsMockMvc.perform(put("/api/ip-credentails")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipCredentailsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IpCredentails in the database
        List<IpCredentails> ipCredentailsList = ipCredentailsRepository.findAll();
        assertThat(ipCredentailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteIpCredentails() throws Exception {
        // Initialize the database
        ipCredentailsRepository.saveAndFlush(ipCredentails);

        int databaseSizeBeforeDelete = ipCredentailsRepository.findAll().size();

        // Delete the ipCredentails
        restIpCredentailsMockMvc.perform(delete("/api/ip-credentails/{id}", ipCredentails.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<IpCredentails> ipCredentailsList = ipCredentailsRepository.findAll();
        assertThat(ipCredentailsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
