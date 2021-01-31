package com.dtit.tm.web.rest;

import com.dtit.tm.RcmDemoMsApp;
import com.dtit.tm.domain.IpAccess;
import com.dtit.tm.repository.IpAccessRepository;
import com.dtit.tm.service.IpAccessService;

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

    private static final String DEFAULT_COANAKREACTION = "AAAAAAAAAA";
    private static final String UPDATED_COANAKREACTION = "BBBBBBBBBB";

    private static final String DEFAULT_CREDENTIALSREQUESTED = "AAAAAAAAAA";
    private static final String UPDATED_CREDENTIALSREQUESTED = "BBBBBBBBBB";

    private static final String DEFAULT_DELEGATEDIPV_6_PREFIX = "AAAAAAAAAA";
    private static final String UPDATED_DELEGATEDIPV_6_PREFIX = "BBBBBBBBBB";

    private static final String DEFAULT_DELEGATEDIPV_6_PREFIXLENGTH = "AAAAAAAAAA";
    private static final String UPDATED_DELEGATEDIPV_6_PREFIXLENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_DNSPROFILE = "AAAAAAAAAA";
    private static final String UPDATED_DNSPROFILE = "BBBBBBBBBB";

    private static final String DEFAULT_FILTERID = "AAAAAAAAAA";
    private static final String UPDATED_FILTERID = "BBBBBBBBBB";

    private static final String DEFAULT_FON_AKTIV = "AAAAAAAAAA";
    private static final String UPDATED_FON_AKTIV = "BBBBBBBBBB";

    private static final String DEFAULT_FRAMEDIPV_6_PREFIX = "AAAAAAAAAA";
    private static final String UPDATED_FRAMEDIPV_6_PREFIX = "BBBBBBBBBB";

    private static final String DEFAULT_FRAMEDIPV_6_PREFIXLENGTH = "AAAAAAAAAA";
    private static final String UPDATED_FRAMEDIPV_6_PREFIXLENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_HA_MSISDN = "AAAAAAAAAA";
    private static final String UPDATED_HA_MSISDN = "BBBBBBBBBB";

    private static final String DEFAULT_INFLUENCESESSION = "AAAAAAAAAA";
    private static final String UPDATED_INFLUENCESESSION = "BBBBBBBBBB";

    private static final String DEFAULT_IPTV_ENABLED = "AAAAAAAAAA";
    private static final String UPDATED_IPTV_ENABLED = "BBBBBBBBBB";

    private static final String DEFAULT_IPV_4_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_IPV_4_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_IPV_4_NETMASK = "AAAAAAAAAA";
    private static final String UPDATED_IPV_4_NETMASK = "BBBBBBBBBB";

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

    private static final String DEFAULT_PROFILSET = "AAAAAAAAAA";
    private static final String UPDATED_PROFILSET = "BBBBBBBBBB";

    private static final String DEFAULT_RECHT_AUF_FESTE_IPADRESSE = "AAAAAAAAAA";
    private static final String UPDATED_RECHT_AUF_FESTE_IPADRESSE = "BBBBBBBBBB";

    private static final String DEFAULT_RESERVEPREFIX = "AAAAAAAAAA";
    private static final String UPDATED_RESERVEPREFIX = "BBBBBBBBBB";

    private static final String DEFAULT_TEILNEHMERSPERRE = "AAAAAAAAAA";
    private static final String UPDATED_TEILNEHMERSPERRE = "BBBBBBBBBB";

    private static final String DEFAULT_TERMINATIONPROFILE = "AAAAAAAAAA";
    private static final String UPDATED_TERMINATIONPROFILE = "BBBBBBBBBB";

    private static final String DEFAULT_TO_NR = "AAAAAAAAAA";
    private static final String UPDATED_TO_NR = "BBBBBBBBBB";

    private static final String DEFAULT_TUNNELPROFILE = "AAAAAAAAAA";
    private static final String UPDATED_TUNNELPROFILE = "BBBBBBBBBB";

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

    private static final String DEFAULT_VOIP_IS_PRESENT = "AAAAAAAAAA";
    private static final String UPDATED_VOIP_IS_PRESENT = "BBBBBBBBBB";

    @Autowired
    private IpAccessRepository ipAccessRepository;

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
            .coanakreaction(DEFAULT_COANAKREACTION)
            .credentialsrequested(DEFAULT_CREDENTIALSREQUESTED)
            .delegatedipv6prefix(DEFAULT_DELEGATEDIPV_6_PREFIX)
            .delegatedipv6prefixlength(DEFAULT_DELEGATEDIPV_6_PREFIXLENGTH)
            .dnsprofile(DEFAULT_DNSPROFILE)
            .filterid(DEFAULT_FILTERID)
            .fonAktiv(DEFAULT_FON_AKTIV)
            .framedipv6prefix(DEFAULT_FRAMEDIPV_6_PREFIX)
            .framedipv6prefixlength(DEFAULT_FRAMEDIPV_6_PREFIXLENGTH)
            .haMSISDN(DEFAULT_HA_MSISDN)
            .influencesession(DEFAULT_INFLUENCESESSION)
            .iptvEnabled(DEFAULT_IPTV_ENABLED)
            .ipv4address(DEFAULT_IPV_4_ADDRESS)
            .ipv4netmask(DEFAULT_IPV_4_NETMASK)
            .ipversion(DEFAULT_IPVERSION)
            .lineid(DEFAULT_LINEID)
            .maxdownspeed(DEFAULT_MAXDOWNSPEED)
            .maxsessionduration(DEFAULT_MAXSESSIONDURATION)
            .maxupspeed(DEFAULT_MAXUPSPEED)
            .mehrfachzugang(DEFAULT_MEHRFACHZUGANG)
            .profileid(DEFAULT_PROFILEID)
            .profilset(DEFAULT_PROFILSET)
            .rechtAufFesteIpadresse(DEFAULT_RECHT_AUF_FESTE_IPADRESSE)
            .reserveprefix(DEFAULT_RESERVEPREFIX)
            .teilnehmersperre(DEFAULT_TEILNEHMERSPERRE)
            .terminationprofile(DEFAULT_TERMINATIONPROFILE)
            .toNr(DEFAULT_TO_NR)
            .tunnelprofile(DEFAULT_TUNNELPROFILE)
            .umtServiceDataOcssubscriptionid(DEFAULT_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID)
            .umtServiceDataThrottledownl3(DEFAULT_UMT_SERVICE_DATA_THROTTLEDOWNL_3)
            .umtServiceDataThrottleprofile(DEFAULT_UMT_SERVICE_DATA_THROTTLEPROFILE)
            .umtServiceDataThrottleupl3(DEFAULT_UMT_SERVICE_DATA_THROTTLEUPL_3)
            .usecase(DEFAULT_USECASE)
            .userauthenticationrequired(DEFAULT_USERAUTHENTICATIONREQUIRED)
            .voipIsPresent(DEFAULT_VOIP_IS_PRESENT);
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
            .coanakreaction(UPDATED_COANAKREACTION)
            .credentialsrequested(UPDATED_CREDENTIALSREQUESTED)
            .delegatedipv6prefix(UPDATED_DELEGATEDIPV_6_PREFIX)
            .delegatedipv6prefixlength(UPDATED_DELEGATEDIPV_6_PREFIXLENGTH)
            .dnsprofile(UPDATED_DNSPROFILE)
            .filterid(UPDATED_FILTERID)
            .fonAktiv(UPDATED_FON_AKTIV)
            .framedipv6prefix(UPDATED_FRAMEDIPV_6_PREFIX)
            .framedipv6prefixlength(UPDATED_FRAMEDIPV_6_PREFIXLENGTH)
            .haMSISDN(UPDATED_HA_MSISDN)
            .influencesession(UPDATED_INFLUENCESESSION)
            .iptvEnabled(UPDATED_IPTV_ENABLED)
            .ipv4address(UPDATED_IPV_4_ADDRESS)
            .ipv4netmask(UPDATED_IPV_4_NETMASK)
            .ipversion(UPDATED_IPVERSION)
            .lineid(UPDATED_LINEID)
            .maxdownspeed(UPDATED_MAXDOWNSPEED)
            .maxsessionduration(UPDATED_MAXSESSIONDURATION)
            .maxupspeed(UPDATED_MAXUPSPEED)
            .mehrfachzugang(UPDATED_MEHRFACHZUGANG)
            .profileid(UPDATED_PROFILEID)
            .profilset(UPDATED_PROFILSET)
            .rechtAufFesteIpadresse(UPDATED_RECHT_AUF_FESTE_IPADRESSE)
            .reserveprefix(UPDATED_RESERVEPREFIX)
            .teilnehmersperre(UPDATED_TEILNEHMERSPERRE)
            .terminationprofile(UPDATED_TERMINATIONPROFILE)
            .toNr(UPDATED_TO_NR)
            .tunnelprofile(UPDATED_TUNNELPROFILE)
            .umtServiceDataOcssubscriptionid(UPDATED_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID)
            .umtServiceDataThrottledownl3(UPDATED_UMT_SERVICE_DATA_THROTTLEDOWNL_3)
            .umtServiceDataThrottleprofile(UPDATED_UMT_SERVICE_DATA_THROTTLEPROFILE)
            .umtServiceDataThrottleupl3(UPDATED_UMT_SERVICE_DATA_THROTTLEUPL_3)
            .usecase(UPDATED_USECASE)
            .userauthenticationrequired(UPDATED_USERAUTHENTICATIONREQUIRED)
            .voipIsPresent(UPDATED_VOIP_IS_PRESENT);
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
        restIpAccessMockMvc.perform(post("/api/ip-accesses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipAccess)))
            .andExpect(status().isCreated());

        // Validate the IpAccess in the database
        List<IpAccess> ipAccessList = ipAccessRepository.findAll();
        assertThat(ipAccessList).hasSize(databaseSizeBeforeCreate + 1);
        IpAccess testIpAccess = ipAccessList.get(ipAccessList.size() - 1);
        assertThat(testIpAccess.getAnschlussbilanzierung()).isEqualTo(DEFAULT_ANSCHLUSSBILANZIERUNG);
        assertThat(testIpAccess.getBssoeorderid()).isEqualTo(DEFAULT_BSSOEORDERID);
        assertThat(testIpAccess.getCoanakreaction()).isEqualTo(DEFAULT_COANAKREACTION);
        assertThat(testIpAccess.getCredentialsrequested()).isEqualTo(DEFAULT_CREDENTIALSREQUESTED);
        assertThat(testIpAccess.getDelegatedipv6prefix()).isEqualTo(DEFAULT_DELEGATEDIPV_6_PREFIX);
        assertThat(testIpAccess.getDelegatedipv6prefixlength()).isEqualTo(DEFAULT_DELEGATEDIPV_6_PREFIXLENGTH);
        assertThat(testIpAccess.getDnsprofile()).isEqualTo(DEFAULT_DNSPROFILE);
        assertThat(testIpAccess.getFilterid()).isEqualTo(DEFAULT_FILTERID);
        assertThat(testIpAccess.getFonAktiv()).isEqualTo(DEFAULT_FON_AKTIV);
        assertThat(testIpAccess.getFramedipv6prefix()).isEqualTo(DEFAULT_FRAMEDIPV_6_PREFIX);
        assertThat(testIpAccess.getFramedipv6prefixlength()).isEqualTo(DEFAULT_FRAMEDIPV_6_PREFIXLENGTH);
        assertThat(testIpAccess.getHaMSISDN()).isEqualTo(DEFAULT_HA_MSISDN);
        assertThat(testIpAccess.getInfluencesession()).isEqualTo(DEFAULT_INFLUENCESESSION);
        assertThat(testIpAccess.getIptvEnabled()).isEqualTo(DEFAULT_IPTV_ENABLED);
        assertThat(testIpAccess.getIpv4address()).isEqualTo(DEFAULT_IPV_4_ADDRESS);
        assertThat(testIpAccess.getIpv4netmask()).isEqualTo(DEFAULT_IPV_4_NETMASK);
        assertThat(testIpAccess.getIpversion()).isEqualTo(DEFAULT_IPVERSION);
        assertThat(testIpAccess.getLineid()).isEqualTo(DEFAULT_LINEID);
        assertThat(testIpAccess.getMaxdownspeed()).isEqualTo(DEFAULT_MAXDOWNSPEED);
        assertThat(testIpAccess.getMaxsessionduration()).isEqualTo(DEFAULT_MAXSESSIONDURATION);
        assertThat(testIpAccess.getMaxupspeed()).isEqualTo(DEFAULT_MAXUPSPEED);
        assertThat(testIpAccess.getMehrfachzugang()).isEqualTo(DEFAULT_MEHRFACHZUGANG);
        assertThat(testIpAccess.getProfileid()).isEqualTo(DEFAULT_PROFILEID);
        assertThat(testIpAccess.getProfilset()).isEqualTo(DEFAULT_PROFILSET);
        assertThat(testIpAccess.getRechtAufFesteIpadresse()).isEqualTo(DEFAULT_RECHT_AUF_FESTE_IPADRESSE);
        assertThat(testIpAccess.getReserveprefix()).isEqualTo(DEFAULT_RESERVEPREFIX);
        assertThat(testIpAccess.getTeilnehmersperre()).isEqualTo(DEFAULT_TEILNEHMERSPERRE);
        assertThat(testIpAccess.getTerminationprofile()).isEqualTo(DEFAULT_TERMINATIONPROFILE);
        assertThat(testIpAccess.getToNr()).isEqualTo(DEFAULT_TO_NR);
        assertThat(testIpAccess.getTunnelprofile()).isEqualTo(DEFAULT_TUNNELPROFILE);
        assertThat(testIpAccess.getUmtServiceDataOcssubscriptionid()).isEqualTo(DEFAULT_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID);
        assertThat(testIpAccess.getUmtServiceDataThrottledownl3()).isEqualTo(DEFAULT_UMT_SERVICE_DATA_THROTTLEDOWNL_3);
        assertThat(testIpAccess.getUmtServiceDataThrottleprofile()).isEqualTo(DEFAULT_UMT_SERVICE_DATA_THROTTLEPROFILE);
        assertThat(testIpAccess.getUmtServiceDataThrottleupl3()).isEqualTo(DEFAULT_UMT_SERVICE_DATA_THROTTLEUPL_3);
        assertThat(testIpAccess.getUsecase()).isEqualTo(DEFAULT_USECASE);
        assertThat(testIpAccess.getUserauthenticationrequired()).isEqualTo(DEFAULT_USERAUTHENTICATIONREQUIRED);
        assertThat(testIpAccess.getVoipIsPresent()).isEqualTo(DEFAULT_VOIP_IS_PRESENT);
    }

    @Test
    @Transactional
    public void createIpAccessWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = ipAccessRepository.findAll().size();

        // Create the IpAccess with an existing ID
        ipAccess.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restIpAccessMockMvc.perform(post("/api/ip-accesses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipAccess)))
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
            .andExpect(jsonPath("$.[*].coanakreaction").value(hasItem(DEFAULT_COANAKREACTION)))
            .andExpect(jsonPath("$.[*].credentialsrequested").value(hasItem(DEFAULT_CREDENTIALSREQUESTED)))
            .andExpect(jsonPath("$.[*].delegatedipv6prefix").value(hasItem(DEFAULT_DELEGATEDIPV_6_PREFIX)))
            .andExpect(jsonPath("$.[*].delegatedipv6prefixlength").value(hasItem(DEFAULT_DELEGATEDIPV_6_PREFIXLENGTH)))
            .andExpect(jsonPath("$.[*].dnsprofile").value(hasItem(DEFAULT_DNSPROFILE)))
            .andExpect(jsonPath("$.[*].filterid").value(hasItem(DEFAULT_FILTERID)))
            .andExpect(jsonPath("$.[*].fonAktiv").value(hasItem(DEFAULT_FON_AKTIV)))
            .andExpect(jsonPath("$.[*].framedipv6prefix").value(hasItem(DEFAULT_FRAMEDIPV_6_PREFIX)))
            .andExpect(jsonPath("$.[*].framedipv6prefixlength").value(hasItem(DEFAULT_FRAMEDIPV_6_PREFIXLENGTH)))
            .andExpect(jsonPath("$.[*].haMSISDN").value(hasItem(DEFAULT_HA_MSISDN)))
            .andExpect(jsonPath("$.[*].influencesession").value(hasItem(DEFAULT_INFLUENCESESSION)))
            .andExpect(jsonPath("$.[*].iptvEnabled").value(hasItem(DEFAULT_IPTV_ENABLED)))
            .andExpect(jsonPath("$.[*].ipv4address").value(hasItem(DEFAULT_IPV_4_ADDRESS)))
            .andExpect(jsonPath("$.[*].ipv4netmask").value(hasItem(DEFAULT_IPV_4_NETMASK)))
            .andExpect(jsonPath("$.[*].ipversion").value(hasItem(DEFAULT_IPVERSION)))
            .andExpect(jsonPath("$.[*].lineid").value(hasItem(DEFAULT_LINEID)))
            .andExpect(jsonPath("$.[*].maxdownspeed").value(hasItem(DEFAULT_MAXDOWNSPEED)))
            .andExpect(jsonPath("$.[*].maxsessionduration").value(hasItem(DEFAULT_MAXSESSIONDURATION)))
            .andExpect(jsonPath("$.[*].maxupspeed").value(hasItem(DEFAULT_MAXUPSPEED)))
            .andExpect(jsonPath("$.[*].mehrfachzugang").value(hasItem(DEFAULT_MEHRFACHZUGANG)))
            .andExpect(jsonPath("$.[*].profileid").value(hasItem(DEFAULT_PROFILEID)))
            .andExpect(jsonPath("$.[*].profilset").value(hasItem(DEFAULT_PROFILSET)))
            .andExpect(jsonPath("$.[*].rechtAufFesteIpadresse").value(hasItem(DEFAULT_RECHT_AUF_FESTE_IPADRESSE)))
            .andExpect(jsonPath("$.[*].reserveprefix").value(hasItem(DEFAULT_RESERVEPREFIX)))
            .andExpect(jsonPath("$.[*].teilnehmersperre").value(hasItem(DEFAULT_TEILNEHMERSPERRE)))
            .andExpect(jsonPath("$.[*].terminationprofile").value(hasItem(DEFAULT_TERMINATIONPROFILE)))
            .andExpect(jsonPath("$.[*].toNr").value(hasItem(DEFAULT_TO_NR)))
            .andExpect(jsonPath("$.[*].tunnelprofile").value(hasItem(DEFAULT_TUNNELPROFILE)))
            .andExpect(jsonPath("$.[*].umtServiceDataOcssubscriptionid").value(hasItem(DEFAULT_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID)))
            .andExpect(jsonPath("$.[*].umtServiceDataThrottledownl3").value(hasItem(DEFAULT_UMT_SERVICE_DATA_THROTTLEDOWNL_3)))
            .andExpect(jsonPath("$.[*].umtServiceDataThrottleprofile").value(hasItem(DEFAULT_UMT_SERVICE_DATA_THROTTLEPROFILE)))
            .andExpect(jsonPath("$.[*].umtServiceDataThrottleupl3").value(hasItem(DEFAULT_UMT_SERVICE_DATA_THROTTLEUPL_3)))
            .andExpect(jsonPath("$.[*].usecase").value(hasItem(DEFAULT_USECASE)))
            .andExpect(jsonPath("$.[*].userauthenticationrequired").value(hasItem(DEFAULT_USERAUTHENTICATIONREQUIRED)))
            .andExpect(jsonPath("$.[*].voipIsPresent").value(hasItem(DEFAULT_VOIP_IS_PRESENT)));
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
            .andExpect(jsonPath("$.coanakreaction").value(DEFAULT_COANAKREACTION))
            .andExpect(jsonPath("$.credentialsrequested").value(DEFAULT_CREDENTIALSREQUESTED))
            .andExpect(jsonPath("$.delegatedipv6prefix").value(DEFAULT_DELEGATEDIPV_6_PREFIX))
            .andExpect(jsonPath("$.delegatedipv6prefixlength").value(DEFAULT_DELEGATEDIPV_6_PREFIXLENGTH))
            .andExpect(jsonPath("$.dnsprofile").value(DEFAULT_DNSPROFILE))
            .andExpect(jsonPath("$.filterid").value(DEFAULT_FILTERID))
            .andExpect(jsonPath("$.fonAktiv").value(DEFAULT_FON_AKTIV))
            .andExpect(jsonPath("$.framedipv6prefix").value(DEFAULT_FRAMEDIPV_6_PREFIX))
            .andExpect(jsonPath("$.framedipv6prefixlength").value(DEFAULT_FRAMEDIPV_6_PREFIXLENGTH))
            .andExpect(jsonPath("$.haMSISDN").value(DEFAULT_HA_MSISDN))
            .andExpect(jsonPath("$.influencesession").value(DEFAULT_INFLUENCESESSION))
            .andExpect(jsonPath("$.iptvEnabled").value(DEFAULT_IPTV_ENABLED))
            .andExpect(jsonPath("$.ipv4address").value(DEFAULT_IPV_4_ADDRESS))
            .andExpect(jsonPath("$.ipv4netmask").value(DEFAULT_IPV_4_NETMASK))
            .andExpect(jsonPath("$.ipversion").value(DEFAULT_IPVERSION))
            .andExpect(jsonPath("$.lineid").value(DEFAULT_LINEID))
            .andExpect(jsonPath("$.maxdownspeed").value(DEFAULT_MAXDOWNSPEED))
            .andExpect(jsonPath("$.maxsessionduration").value(DEFAULT_MAXSESSIONDURATION))
            .andExpect(jsonPath("$.maxupspeed").value(DEFAULT_MAXUPSPEED))
            .andExpect(jsonPath("$.mehrfachzugang").value(DEFAULT_MEHRFACHZUGANG))
            .andExpect(jsonPath("$.profileid").value(DEFAULT_PROFILEID))
            .andExpect(jsonPath("$.profilset").value(DEFAULT_PROFILSET))
            .andExpect(jsonPath("$.rechtAufFesteIpadresse").value(DEFAULT_RECHT_AUF_FESTE_IPADRESSE))
            .andExpect(jsonPath("$.reserveprefix").value(DEFAULT_RESERVEPREFIX))
            .andExpect(jsonPath("$.teilnehmersperre").value(DEFAULT_TEILNEHMERSPERRE))
            .andExpect(jsonPath("$.terminationprofile").value(DEFAULT_TERMINATIONPROFILE))
            .andExpect(jsonPath("$.toNr").value(DEFAULT_TO_NR))
            .andExpect(jsonPath("$.tunnelprofile").value(DEFAULT_TUNNELPROFILE))
            .andExpect(jsonPath("$.umtServiceDataOcssubscriptionid").value(DEFAULT_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID))
            .andExpect(jsonPath("$.umtServiceDataThrottledownl3").value(DEFAULT_UMT_SERVICE_DATA_THROTTLEDOWNL_3))
            .andExpect(jsonPath("$.umtServiceDataThrottleprofile").value(DEFAULT_UMT_SERVICE_DATA_THROTTLEPROFILE))
            .andExpect(jsonPath("$.umtServiceDataThrottleupl3").value(DEFAULT_UMT_SERVICE_DATA_THROTTLEUPL_3))
            .andExpect(jsonPath("$.usecase").value(DEFAULT_USECASE))
            .andExpect(jsonPath("$.userauthenticationrequired").value(DEFAULT_USERAUTHENTICATIONREQUIRED))
            .andExpect(jsonPath("$.voipIsPresent").value(DEFAULT_VOIP_IS_PRESENT));
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
        ipAccessService.save(ipAccess);

        int databaseSizeBeforeUpdate = ipAccessRepository.findAll().size();

        // Update the ipAccess
        IpAccess updatedIpAccess = ipAccessRepository.findById(ipAccess.getId()).get();
        // Disconnect from session so that the updates on updatedIpAccess are not directly saved in db
        em.detach(updatedIpAccess);
        updatedIpAccess
            .anschlussbilanzierung(UPDATED_ANSCHLUSSBILANZIERUNG)
            .bssoeorderid(UPDATED_BSSOEORDERID)
            .coanakreaction(UPDATED_COANAKREACTION)
            .credentialsrequested(UPDATED_CREDENTIALSREQUESTED)
            .delegatedipv6prefix(UPDATED_DELEGATEDIPV_6_PREFIX)
            .delegatedipv6prefixlength(UPDATED_DELEGATEDIPV_6_PREFIXLENGTH)
            .dnsprofile(UPDATED_DNSPROFILE)
            .filterid(UPDATED_FILTERID)
            .fonAktiv(UPDATED_FON_AKTIV)
            .framedipv6prefix(UPDATED_FRAMEDIPV_6_PREFIX)
            .framedipv6prefixlength(UPDATED_FRAMEDIPV_6_PREFIXLENGTH)
            .haMSISDN(UPDATED_HA_MSISDN)
            .influencesession(UPDATED_INFLUENCESESSION)
            .iptvEnabled(UPDATED_IPTV_ENABLED)
            .ipv4address(UPDATED_IPV_4_ADDRESS)
            .ipv4netmask(UPDATED_IPV_4_NETMASK)
            .ipversion(UPDATED_IPVERSION)
            .lineid(UPDATED_LINEID)
            .maxdownspeed(UPDATED_MAXDOWNSPEED)
            .maxsessionduration(UPDATED_MAXSESSIONDURATION)
            .maxupspeed(UPDATED_MAXUPSPEED)
            .mehrfachzugang(UPDATED_MEHRFACHZUGANG)
            .profileid(UPDATED_PROFILEID)
            .profilset(UPDATED_PROFILSET)
            .rechtAufFesteIpadresse(UPDATED_RECHT_AUF_FESTE_IPADRESSE)
            .reserveprefix(UPDATED_RESERVEPREFIX)
            .teilnehmersperre(UPDATED_TEILNEHMERSPERRE)
            .terminationprofile(UPDATED_TERMINATIONPROFILE)
            .toNr(UPDATED_TO_NR)
            .tunnelprofile(UPDATED_TUNNELPROFILE)
            .umtServiceDataOcssubscriptionid(UPDATED_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID)
            .umtServiceDataThrottledownl3(UPDATED_UMT_SERVICE_DATA_THROTTLEDOWNL_3)
            .umtServiceDataThrottleprofile(UPDATED_UMT_SERVICE_DATA_THROTTLEPROFILE)
            .umtServiceDataThrottleupl3(UPDATED_UMT_SERVICE_DATA_THROTTLEUPL_3)
            .usecase(UPDATED_USECASE)
            .userauthenticationrequired(UPDATED_USERAUTHENTICATIONREQUIRED)
            .voipIsPresent(UPDATED_VOIP_IS_PRESENT);

        restIpAccessMockMvc.perform(put("/api/ip-accesses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedIpAccess)))
            .andExpect(status().isOk());

        // Validate the IpAccess in the database
        List<IpAccess> ipAccessList = ipAccessRepository.findAll();
        assertThat(ipAccessList).hasSize(databaseSizeBeforeUpdate);
        IpAccess testIpAccess = ipAccessList.get(ipAccessList.size() - 1);
        assertThat(testIpAccess.getAnschlussbilanzierung()).isEqualTo(UPDATED_ANSCHLUSSBILANZIERUNG);
        assertThat(testIpAccess.getBssoeorderid()).isEqualTo(UPDATED_BSSOEORDERID);
        assertThat(testIpAccess.getCoanakreaction()).isEqualTo(UPDATED_COANAKREACTION);
        assertThat(testIpAccess.getCredentialsrequested()).isEqualTo(UPDATED_CREDENTIALSREQUESTED);
        assertThat(testIpAccess.getDelegatedipv6prefix()).isEqualTo(UPDATED_DELEGATEDIPV_6_PREFIX);
        assertThat(testIpAccess.getDelegatedipv6prefixlength()).isEqualTo(UPDATED_DELEGATEDIPV_6_PREFIXLENGTH);
        assertThat(testIpAccess.getDnsprofile()).isEqualTo(UPDATED_DNSPROFILE);
        assertThat(testIpAccess.getFilterid()).isEqualTo(UPDATED_FILTERID);
        assertThat(testIpAccess.getFonAktiv()).isEqualTo(UPDATED_FON_AKTIV);
        assertThat(testIpAccess.getFramedipv6prefix()).isEqualTo(UPDATED_FRAMEDIPV_6_PREFIX);
        assertThat(testIpAccess.getFramedipv6prefixlength()).isEqualTo(UPDATED_FRAMEDIPV_6_PREFIXLENGTH);
        assertThat(testIpAccess.getHaMSISDN()).isEqualTo(UPDATED_HA_MSISDN);
        assertThat(testIpAccess.getInfluencesession()).isEqualTo(UPDATED_INFLUENCESESSION);
        assertThat(testIpAccess.getIptvEnabled()).isEqualTo(UPDATED_IPTV_ENABLED);
        assertThat(testIpAccess.getIpv4address()).isEqualTo(UPDATED_IPV_4_ADDRESS);
        assertThat(testIpAccess.getIpv4netmask()).isEqualTo(UPDATED_IPV_4_NETMASK);
        assertThat(testIpAccess.getIpversion()).isEqualTo(UPDATED_IPVERSION);
        assertThat(testIpAccess.getLineid()).isEqualTo(UPDATED_LINEID);
        assertThat(testIpAccess.getMaxdownspeed()).isEqualTo(UPDATED_MAXDOWNSPEED);
        assertThat(testIpAccess.getMaxsessionduration()).isEqualTo(UPDATED_MAXSESSIONDURATION);
        assertThat(testIpAccess.getMaxupspeed()).isEqualTo(UPDATED_MAXUPSPEED);
        assertThat(testIpAccess.getMehrfachzugang()).isEqualTo(UPDATED_MEHRFACHZUGANG);
        assertThat(testIpAccess.getProfileid()).isEqualTo(UPDATED_PROFILEID);
        assertThat(testIpAccess.getProfilset()).isEqualTo(UPDATED_PROFILSET);
        assertThat(testIpAccess.getRechtAufFesteIpadresse()).isEqualTo(UPDATED_RECHT_AUF_FESTE_IPADRESSE);
        assertThat(testIpAccess.getReserveprefix()).isEqualTo(UPDATED_RESERVEPREFIX);
        assertThat(testIpAccess.getTeilnehmersperre()).isEqualTo(UPDATED_TEILNEHMERSPERRE);
        assertThat(testIpAccess.getTerminationprofile()).isEqualTo(UPDATED_TERMINATIONPROFILE);
        assertThat(testIpAccess.getToNr()).isEqualTo(UPDATED_TO_NR);
        assertThat(testIpAccess.getTunnelprofile()).isEqualTo(UPDATED_TUNNELPROFILE);
        assertThat(testIpAccess.getUmtServiceDataOcssubscriptionid()).isEqualTo(UPDATED_UMT_SERVICE_DATA_OCSSUBSCRIPTIONID);
        assertThat(testIpAccess.getUmtServiceDataThrottledownl3()).isEqualTo(UPDATED_UMT_SERVICE_DATA_THROTTLEDOWNL_3);
        assertThat(testIpAccess.getUmtServiceDataThrottleprofile()).isEqualTo(UPDATED_UMT_SERVICE_DATA_THROTTLEPROFILE);
        assertThat(testIpAccess.getUmtServiceDataThrottleupl3()).isEqualTo(UPDATED_UMT_SERVICE_DATA_THROTTLEUPL_3);
        assertThat(testIpAccess.getUsecase()).isEqualTo(UPDATED_USECASE);
        assertThat(testIpAccess.getUserauthenticationrequired()).isEqualTo(UPDATED_USERAUTHENTICATIONREQUIRED);
        assertThat(testIpAccess.getVoipIsPresent()).isEqualTo(UPDATED_VOIP_IS_PRESENT);
    }

    @Test
    @Transactional
    public void updateNonExistingIpAccess() throws Exception {
        int databaseSizeBeforeUpdate = ipAccessRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIpAccessMockMvc.perform(put("/api/ip-accesses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(ipAccess)))
            .andExpect(status().isBadRequest());

        // Validate the IpAccess in the database
        List<IpAccess> ipAccessList = ipAccessRepository.findAll();
        assertThat(ipAccessList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteIpAccess() throws Exception {
        // Initialize the database
        ipAccessService.save(ipAccess);

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
