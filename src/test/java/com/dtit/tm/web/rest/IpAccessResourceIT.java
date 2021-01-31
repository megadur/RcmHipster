package com.dtit.tm.web.rest;

import com.dtit.tm.RcmDemoMsApp;
import com.dtit.tm.domain.IpAccess;
import com.dtit.tm.repository.IpAccessRepository;
import com.dtit.tm.service.IpAccessService;
import com.dtit.tm.service.dto.IpAccessDTO;
import com.dtit.tm.service.mapper.IpAccessMapper;

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
 * Integration tests for the {@link IpAccessResource} REST controller.
 */
@SpringBootTest(classes = RcmDemoMsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class IpAccessResourceIT {

    private static final String DEFAULT_ANSCHLUSSBILANZIERUNG = "AAAAAAAAAA";
    private static final String UPDATED_ANSCHLUSSBILANZIERUNG = "BBBBBBBBBB";

    private static final String DEFAULT_BSSOEORDERID = "AAAAAAAAAA";
    private static final String UPDATED_BSSOEORDERID = "BBBBBBBBBB";

    private static final String DEFAULT_DNSPROFILE = "AAAAAAAAAA";
    private static final String UPDATED_DNSPROFILE = "BBBBBBBBBB";

    private static final String DEFAULT_FILTERID = "AAAAAAAAAA";
    private static final String UPDATED_FILTERID = "BBBBBBBBBB";

    private static final String DEFAULT_FON_AKTIV = "AAAAAAAAAA";
    private static final String UPDATED_FON_AKTIV = "BBBBBBBBBB";

    private static final String DEFAULT_IPVERSION = "AAAAAAAAAA";
    private static final String UPDATED_IPVERSION = "BBBBBBBBBB";

    private static final String DEFAULT_LINEID = "AAAAAAAAAA";
    private static final String UPDATED_LINEID = "BBBBBBBBBB";

    private static final String DEFAULT_MAXDOWNSPEED = "AAAAAAAAAA";
    private static final String UPDATED_MAXDOWNSPEED = "BBBBBBBBBB";

    private static final String DEFAULT_MAXSESSIONDURATION = "AAAAAAAAAA";
    private static final String UPDATED_MAXSESSIONDURATION = "BBBBBBBBBB";

    private static final String DEFAULT_MAXUPSPEED = "AAAAAAAAAA";
    private static final String UPDATED_MAXUPSPEED = "BBBBBBBBBB";

    private static final String DEFAULT_MEHRFACHZUGANG = "AAAAAAAAAA";
    private static final String UPDATED_MEHRFACHZUGANG = "BBBBBBBBBB";

    private static final String DEFAULT_PROFILEID = "AAAAAAAAAA";
    private static final String UPDATED_PROFILEID = "BBBBBBBBBB";

    private static final String DEFAULT_RECHT_AUF_FESTE_IPADRESSE = "AAAAAAAAAA";
    private static final String UPDATED_RECHT_AUF_FESTE_IPADRESSE = "BBBBBBBBBB";

    private static final String DEFAULT_TO_NR = "AAAAAAAAAA";
    private static final String UPDATED_TO_NR = "BBBBBBBBBB";

    private static final String DEFAULT_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID = "AAAAAAAAAA";
    private static final String UPDATED_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID = "BBBBBBBBBB";

    private static final String DEFAULT_UMT_SERVICE_DATA_THROTTLEDOWNL_3 = "AAAAAAAAAA";
    private static final String UPDATED_UMT_SERVICE_DATA_THROTTLEDOWNL_3 = "BBBBBBBBBB";

    private static final String DEFAULT_UMT_SERVICE_DATA_THROTTLEPROFILE = "AAAAAAAAAA";
    private static final String UPDATED_UMT_SERVICE_DATA_THROTTLEPROFILE = "BBBBBBBBBB";

    private static final String DEFAULT_UMT_SERVICE_DATA_THROTTLEUPL_3 = "AAAAAAAAAA";
    private static final String UPDATED_UMT_SERVICE_DATA_THROTTLEUPL_3 = "BBBBBBBBBB";

    private static final String DEFAULT_USECASE = "AAAAAAAAAA";
    private static final String UPDATED_USECASE = "BBBBBBBBBB";

    private static final String DEFAULT_USERAUTHENTICATIONREQUIRED = "AAAAAAAAAA";
    private static final String UPDATED_USERAUTHENTICATIONREQUIRED = "BBBBBBBBBB";

    @Autowired
    private IpAccessRepository ipAccessRepository;

    @Autowired
    private IpAccessMapper ipAccessMapper;

    @Autowired
    private IpAccessService ipAccessService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restIpAccessMockMvc;

    private IpAccess ipAccess;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IpAccess createEntity(EntityManager em) {
        IpAccess ipAccess = new IpAccess()
            .anschlussbilanzierung(DEFAULT_ANSCHLUSSBILANZIERUNG)
            .bssoeorderid(DEFAULT_BSSOEORDERID)
            .dnsprofile(DEFAULT_DNSPROFILE)
            .filterid(DEFAULT_FILTERID)
            .fonAktiv(DEFAULT_FON_AKTIV)
            .ipversion(DEFAULT_IPVERSION)
            .lineid(DEFAULT_LINEID)
            .maxdownspeed(DEFAULT_MAXDOWNSPEED)
            .maxsessionduration(DEFAULT_MAXSESSIONDURATION)
            .maxupspeed(DEFAULT_MAXUPSPEED)
            .mehrfachzugang(DEFAULT_MEHRFACHZUGANG)
            .profileid(DEFAULT_PROFILEID)
            .rechtAufFesteIpadresse(DEFAULT_RECHT_AUF_FESTE_IPADRESSE)
            .toNr(DEFAULT_TO_NR)
            .umtServiceDataOcssubscriptionid(DEFAULT_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID)
            .umtServiceDataThrottledownl3(DEFAULT_UMT_SERVICE_DATA_THROTTLEDOWNL_3)
            .umtServiceDataThrottleprofile(DEFAULT_UMT_SERVICE_DATA_THROTTLEPROFILE)
            .umtServiceDataThrottleupl3(DEFAULT_UMT_SERVICE_DATA_THROTTLEUPL_3)
            .usecase(DEFAULT_USECASE)
            .userauthenticationrequired(DEFAULT_USERAUTHENTICATIONREQUIRED);
        return ipAccess;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IpAccess createUpdatedEntity(EntityManager em) {
        IpAccess ipAccess = new IpAccess()
            .anschlussbilanzierung(UPDATED_ANSCHLUSSBILANZIERUNG)
            .bssoeorderid(UPDATED_BSSOEORDERID)
            .dnsprofile(UPDATED_DNSPROFILE)
            .filterid(UPDATED_FILTERID)
            .fonAktiv(UPDATED_FON_AKTIV)
            .ipversion(UPDATED_IPVERSION)
            .lineid(UPDATED_LINEID)
            .maxdownspeed(UPDATED_MAXDOWNSPEED)
            .maxsessionduration(UPDATED_MAXSESSIONDURATION)
            .maxupspeed(UPDATED_MAXUPSPEED)
            .mehrfachzugang(UPDATED_MEHRFACHZUGANG)
            .profileid(UPDATED_PROFILEID)
            .rechtAufFesteIpadresse(UPDATED_RECHT_AUF_FESTE_IPADRESSE)
            .toNr(UPDATED_TO_NR)
            .umtServiceDataOcssubscriptionid(UPDATED_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID)
            .umtServiceDataThrottledownl3(UPDATED_UMT_SERVICE_DATA_THROTTLEDOWNL_3)
            .umtServiceDataThrottleprofile(UPDATED_UMT_SERVICE_DATA_THROTTLEPROFILE)
            .umtServiceDataThrottleupl3(UPDATED_UMT_SERVICE_DATA_THROTTLEUPL_3)
            .usecase(UPDATED_USECASE)
            .userauthenticationrequired(UPDATED_USERAUTHENTICATIONREQUIRED);
        return ipAccess;
    }

    @BeforeEach
    public void initTest() {
        ipAccess = createEntity(em);
    }

    @Test
    @Transactional
    public void createIpAccess() throws Exception {
        int databaseSizeBeforeCreate = ipAccessRepository.findAll().size();
        // Create the IpAccess
        IpAccessDTO ipAccessDTO = ipAccessMapper.toDto(ipAccess);
        restIpAccessMockMvc.perform(post("/api/ip-accesses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipAccessDTO)))
            .andExpect(status().isCreated());

        // Validate the IpAccess in the database
        List<IpAccess> ipAccessList = ipAccessRepository.findAll();
        assertThat(ipAccessList).hasSize(databaseSizeBeforeCreate + 1);
        IpAccess testIpAccess = ipAccessList.get(ipAccessList.size() - 1);
        assertThat(testIpAccess.getAnschlussbilanzierung()).isEqualTo(DEFAULT_ANSCHLUSSBILANZIERUNG);
        assertThat(testIpAccess.getBssoeorderid()).isEqualTo(DEFAULT_BSSOEORDERID);
        assertThat(testIpAccess.getDnsprofile()).isEqualTo(DEFAULT_DNSPROFILE);
        assertThat(testIpAccess.getFilterid()).isEqualTo(DEFAULT_FILTERID);
        assertThat(testIpAccess.getFonAktiv()).isEqualTo(DEFAULT_FON_AKTIV);
        assertThat(testIpAccess.getIpversion()).isEqualTo(DEFAULT_IPVERSION);
        assertThat(testIpAccess.getLineid()).isEqualTo(DEFAULT_LINEID);
        assertThat(testIpAccess.getMaxdownspeed()).isEqualTo(DEFAULT_MAXDOWNSPEED);
        assertThat(testIpAccess.getMaxsessionduration()).isEqualTo(DEFAULT_MAXSESSIONDURATION);
        assertThat(testIpAccess.getMaxupspeed()).isEqualTo(DEFAULT_MAXUPSPEED);
        assertThat(testIpAccess.getMehrfachzugang()).isEqualTo(DEFAULT_MEHRFACHZUGANG);
        assertThat(testIpAccess.getProfileid()).isEqualTo(DEFAULT_PROFILEID);
        assertThat(testIpAccess.getRechtAufFesteIpadresse()).isEqualTo(DEFAULT_RECHT_AUF_FESTE_IPADRESSE);
        assertThat(testIpAccess.getToNr()).isEqualTo(DEFAULT_TO_NR);
        assertThat(testIpAccess.getUmtServiceDataOcssubscriptionid()).isEqualTo(DEFAULT_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID);
        assertThat(testIpAccess.getUmtServiceDataThrottledownl3()).isEqualTo(DEFAULT_UMT_SERVICE_DATA_THROTTLEDOWNL_3);
        assertThat(testIpAccess.getUmtServiceDataThrottleprofile()).isEqualTo(DEFAULT_UMT_SERVICE_DATA_THROTTLEPROFILE);
        assertThat(testIpAccess.getUmtServiceDataThrottleupl3()).isEqualTo(DEFAULT_UMT_SERVICE_DATA_THROTTLEUPL_3);
        assertThat(testIpAccess.getUsecase()).isEqualTo(DEFAULT_USECASE);
        assertThat(testIpAccess.getUserauthenticationrequired()).isEqualTo(DEFAULT_USERAUTHENTICATIONREQUIRED);
    }

    @Test
    @Transactional
    public void createIpAccessWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = ipAccessRepository.findAll().size();

        // Create the IpAccess with an existing ID
        ipAccess.setId(1L);
        IpAccessDTO ipAccessDTO = ipAccessMapper.toDto(ipAccess);

        // An entity with an existing ID cannot be created, so this API call must fail
        restIpAccessMockMvc.perform(post("/api/ip-accesses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipAccessDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IpAccess in the database
        List<IpAccess> ipAccessList = ipAccessRepository.findAll();
        assertThat(ipAccessList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllIpAccesses() throws Exception {
        // Initialize the database
        ipAccessRepository.saveAndFlush(ipAccess);

        // Get all the ipAccessList
        restIpAccessMockMvc.perform(get("/api/ip-accesses?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ipAccess.getId().intValue())))
            .andExpect(jsonPath("$.[*].anschlussbilanzierung").value(hasItem(DEFAULT_ANSCHLUSSBILANZIERUNG)))
            .andExpect(jsonPath("$.[*].bssoeorderid").value(hasItem(DEFAULT_BSSOEORDERID)))
            .andExpect(jsonPath("$.[*].dnsprofile").value(hasItem(DEFAULT_DNSPROFILE)))
            .andExpect(jsonPath("$.[*].filterid").value(hasItem(DEFAULT_FILTERID)))
            .andExpect(jsonPath("$.[*].fonAktiv").value(hasItem(DEFAULT_FON_AKTIV)))
            .andExpect(jsonPath("$.[*].ipversion").value(hasItem(DEFAULT_IPVERSION)))
            .andExpect(jsonPath("$.[*].lineid").value(hasItem(DEFAULT_LINEID)))
            .andExpect(jsonPath("$.[*].maxdownspeed").value(hasItem(DEFAULT_MAXDOWNSPEED)))
            .andExpect(jsonPath("$.[*].maxsessionduration").value(hasItem(DEFAULT_MAXSESSIONDURATION)))
            .andExpect(jsonPath("$.[*].maxupspeed").value(hasItem(DEFAULT_MAXUPSPEED)))
            .andExpect(jsonPath("$.[*].mehrfachzugang").value(hasItem(DEFAULT_MEHRFACHZUGANG)))
            .andExpect(jsonPath("$.[*].profileid").value(hasItem(DEFAULT_PROFILEID)))
            .andExpect(jsonPath("$.[*].rechtAufFesteIpadresse").value(hasItem(DEFAULT_RECHT_AUF_FESTE_IPADRESSE)))
            .andExpect(jsonPath("$.[*].toNr").value(hasItem(DEFAULT_TO_NR)))
            .andExpect(jsonPath("$.[*].umtServiceDataOcssubscriptionid").value(hasItem(DEFAULT_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID)))
            .andExpect(jsonPath("$.[*].umtServiceDataThrottledownl3").value(hasItem(DEFAULT_UMT_SERVICE_DATA_THROTTLEDOWNL_3)))
            .andExpect(jsonPath("$.[*].umtServiceDataThrottleprofile").value(hasItem(DEFAULT_UMT_SERVICE_DATA_THROTTLEPROFILE)))
            .andExpect(jsonPath("$.[*].umtServiceDataThrottleupl3").value(hasItem(DEFAULT_UMT_SERVICE_DATA_THROTTLEUPL_3)))
            .andExpect(jsonPath("$.[*].usecase").value(hasItem(DEFAULT_USECASE)))
            .andExpect(jsonPath("$.[*].userauthenticationrequired").value(hasItem(DEFAULT_USERAUTHENTICATIONREQUIRED)));
    }
    
    @Test
    @Transactional
    public void getIpAccess() throws Exception {
        // Initialize the database
        ipAccessRepository.saveAndFlush(ipAccess);

        // Get the ipAccess
        restIpAccessMockMvc.perform(get("/api/ip-accesses/{id}", ipAccess.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(ipAccess.getId().intValue()))
            .andExpect(jsonPath("$.anschlussbilanzierung").value(DEFAULT_ANSCHLUSSBILANZIERUNG))
            .andExpect(jsonPath("$.bssoeorderid").value(DEFAULT_BSSOEORDERID))
            .andExpect(jsonPath("$.dnsprofile").value(DEFAULT_DNSPROFILE))
            .andExpect(jsonPath("$.filterid").value(DEFAULT_FILTERID))
            .andExpect(jsonPath("$.fonAktiv").value(DEFAULT_FON_AKTIV))
            .andExpect(jsonPath("$.ipversion").value(DEFAULT_IPVERSION))
            .andExpect(jsonPath("$.lineid").value(DEFAULT_LINEID))
            .andExpect(jsonPath("$.maxdownspeed").value(DEFAULT_MAXDOWNSPEED))
            .andExpect(jsonPath("$.maxsessionduration").value(DEFAULT_MAXSESSIONDURATION))
            .andExpect(jsonPath("$.maxupspeed").value(DEFAULT_MAXUPSPEED))
            .andExpect(jsonPath("$.mehrfachzugang").value(DEFAULT_MEHRFACHZUGANG))
            .andExpect(jsonPath("$.profileid").value(DEFAULT_PROFILEID))
            .andExpect(jsonPath("$.rechtAufFesteIpadresse").value(DEFAULT_RECHT_AUF_FESTE_IPADRESSE))
            .andExpect(jsonPath("$.toNr").value(DEFAULT_TO_NR))
            .andExpect(jsonPath("$.umtServiceDataOcssubscriptionid").value(DEFAULT_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID))
            .andExpect(jsonPath("$.umtServiceDataThrottledownl3").value(DEFAULT_UMT_SERVICE_DATA_THROTTLEDOWNL_3))
            .andExpect(jsonPath("$.umtServiceDataThrottleprofile").value(DEFAULT_UMT_SERVICE_DATA_THROTTLEPROFILE))
            .andExpect(jsonPath("$.umtServiceDataThrottleupl3").value(DEFAULT_UMT_SERVICE_DATA_THROTTLEUPL_3))
            .andExpect(jsonPath("$.usecase").value(DEFAULT_USECASE))
            .andExpect(jsonPath("$.userauthenticationrequired").value(DEFAULT_USERAUTHENTICATIONREQUIRED));
    }
    @Test
    @Transactional
    public void getNonExistingIpAccess() throws Exception {
        // Get the ipAccess
        restIpAccessMockMvc.perform(get("/api/ip-accesses/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateIpAccess() throws Exception {
        // Initialize the database
        ipAccessRepository.saveAndFlush(ipAccess);

        int databaseSizeBeforeUpdate = ipAccessRepository.findAll().size();

        // Update the ipAccess
        IpAccess updatedIpAccess = ipAccessRepository.findById(ipAccess.getId()).get();
        // Disconnect from session so that the updates on updatedIpAccess are not directly saved in db
        em.detach(updatedIpAccess);
        updatedIpAccess
            .anschlussbilanzierung(UPDATED_ANSCHLUSSBILANZIERUNG)
            .bssoeorderid(UPDATED_BSSOEORDERID)
            .dnsprofile(UPDATED_DNSPROFILE)
            .filterid(UPDATED_FILTERID)
            .fonAktiv(UPDATED_FON_AKTIV)
            .ipversion(UPDATED_IPVERSION)
            .lineid(UPDATED_LINEID)
            .maxdownspeed(UPDATED_MAXDOWNSPEED)
            .maxsessionduration(UPDATED_MAXSESSIONDURATION)
            .maxupspeed(UPDATED_MAXUPSPEED)
            .mehrfachzugang(UPDATED_MEHRFACHZUGANG)
            .profileid(UPDATED_PROFILEID)
            .rechtAufFesteIpadresse(UPDATED_RECHT_AUF_FESTE_IPADRESSE)
            .toNr(UPDATED_TO_NR)
            .umtServiceDataOcssubscriptionid(UPDATED_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID)
            .umtServiceDataThrottledownl3(UPDATED_UMT_SERVICE_DATA_THROTTLEDOWNL_3)
            .umtServiceDataThrottleprofile(UPDATED_UMT_SERVICE_DATA_THROTTLEPROFILE)
            .umtServiceDataThrottleupl3(UPDATED_UMT_SERVICE_DATA_THROTTLEUPL_3)
            .usecase(UPDATED_USECASE)
            .userauthenticationrequired(UPDATED_USERAUTHENTICATIONREQUIRED);
        IpAccessDTO ipAccessDTO = ipAccessMapper.toDto(updatedIpAccess);

        restIpAccessMockMvc.perform(put("/api/ip-accesses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipAccessDTO)))
            .andExpect(status().isOk());

        // Validate the IpAccess in the database
        List<IpAccess> ipAccessList = ipAccessRepository.findAll();
        assertThat(ipAccessList).hasSize(databaseSizeBeforeUpdate);
        IpAccess testIpAccess = ipAccessList.get(ipAccessList.size() - 1);
        assertThat(testIpAccess.getAnschlussbilanzierung()).isEqualTo(UPDATED_ANSCHLUSSBILANZIERUNG);
        assertThat(testIpAccess.getBssoeorderid()).isEqualTo(UPDATED_BSSOEORDERID);
        assertThat(testIpAccess.getDnsprofile()).isEqualTo(UPDATED_DNSPROFILE);
        assertThat(testIpAccess.getFilterid()).isEqualTo(UPDATED_FILTERID);
        assertThat(testIpAccess.getFonAktiv()).isEqualTo(UPDATED_FON_AKTIV);
        assertThat(testIpAccess.getIpversion()).isEqualTo(UPDATED_IPVERSION);
        assertThat(testIpAccess.getLineid()).isEqualTo(UPDATED_LINEID);
        assertThat(testIpAccess.getMaxdownspeed()).isEqualTo(UPDATED_MAXDOWNSPEED);
        assertThat(testIpAccess.getMaxsessionduration()).isEqualTo(UPDATED_MAXSESSIONDURATION);
        assertThat(testIpAccess.getMaxupspeed()).isEqualTo(UPDATED_MAXUPSPEED);
        assertThat(testIpAccess.getMehrfachzugang()).isEqualTo(UPDATED_MEHRFACHZUGANG);
        assertThat(testIpAccess.getProfileid()).isEqualTo(UPDATED_PROFILEID);
        assertThat(testIpAccess.getRechtAufFesteIpadresse()).isEqualTo(UPDATED_RECHT_AUF_FESTE_IPADRESSE);
        assertThat(testIpAccess.getToNr()).isEqualTo(UPDATED_TO_NR);
        assertThat(testIpAccess.getUmtServiceDataOcssubscriptionid()).isEqualTo(UPDATED_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID);
        assertThat(testIpAccess.getUmtServiceDataThrottledownl3()).isEqualTo(UPDATED_UMT_SERVICE_DATA_THROTTLEDOWNL_3);
        assertThat(testIpAccess.getUmtServiceDataThrottleprofile()).isEqualTo(UPDATED_UMT_SERVICE_DATA_THROTTLEPROFILE);
        assertThat(testIpAccess.getUmtServiceDataThrottleupl3()).isEqualTo(UPDATED_UMT_SERVICE_DATA_THROTTLEUPL_3);
        assertThat(testIpAccess.getUsecase()).isEqualTo(UPDATED_USECASE);
        assertThat(testIpAccess.getUserauthenticationrequired()).isEqualTo(UPDATED_USERAUTHENTICATIONREQUIRED);
    }

    @Test
    @Transactional
    public void updateNonExistingIpAccess() throws Exception {
        int databaseSizeBeforeUpdate = ipAccessRepository.findAll().size();

        // Create the IpAccess
        IpAccessDTO ipAccessDTO = ipAccessMapper.toDto(ipAccess);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIpAccessMockMvc.perform(put("/api/ip-accesses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipAccessDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IpAccess in the database
        List<IpAccess> ipAccessList = ipAccessRepository.findAll();
        assertThat(ipAccessList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteIpAccess() throws Exception {
        // Initialize the database
        ipAccessRepository.saveAndFlush(ipAccess);

        int databaseSizeBeforeDelete = ipAccessRepository.findAll().size();

        // Delete the ipAccess
        restIpAccessMockMvc.perform(delete("/api/ip-accesses/{id}", ipAccess.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<IpAccess> ipAccessList = ipAccessRepository.findAll();
        assertThat(ipAccessList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
