package com.dtit.tm.web.rest;

import com.dtit.tm.RcmDemoMsApp;
import com.dtit.tm.domain.Subscriber;
import com.dtit.tm.repository.SubscriberRepository;
import com.dtit.tm.service.SubscriberService;

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
 * Integration tests for the {@link SubscriberResource} REST controller.
 */
@SpringBootTest(classes = RcmDemoMsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SubscriberResourceIT {

    private static final String DEFAULT_ASSKENG = "AAAAAAAAAA";
    private static final String UPDATED_ASSKENG = "BBBBBBBBBB";

    private static final String DEFAULT_CALID = "AAAAAAAAAA";
    private static final String UPDATED_CALID = "BBBBBBBBBB";

    private static final String DEFAULT_DNS_PROFILE = "AAAAAAAAAA";
    private static final String UPDATED_DNS_PROFILE = "BBBBBBBBBB";

    private static final String DEFAULT_ERRORELEMENT = "AAAAAAAAAA";
    private static final String UPDATED_ERRORELEMENT = "BBBBBBBBBB";

    private static final String DEFAULT_ERRORMESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_ERRORMESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_ERRORVALUE = "AAAAAAAAAA";
    private static final String UPDATED_ERRORVALUE = "BBBBBBBBBB";

    private static final String DEFAULT_IPVERSION = "AAAAAAAAAA";
    private static final String UPDATED_IPVERSION = "BBBBBBBBBB";

    private static final String DEFAULT_KEYID = "AAAAAAAAAA";
    private static final String UPDATED_KEYID = "BBBBBBBBBB";

    private static final String DEFAULT_MAX_DOWN_L_3 = "AAAAAAAAAA";
    private static final String UPDATED_MAX_DOWN_L_3 = "BBBBBBBBBB";

    private static final String DEFAULT_MAX_SESSION_DURATION = "AAAAAAAAAA";
    private static final String UPDATED_MAX_SESSION_DURATION = "BBBBBBBBBB";

    private static final String DEFAULT_MAX_UP_L_3 = "AAAAAAAAAA";
    private static final String UPDATED_MAX_UP_L_3 = "BBBBBBBBBB";

    private static final String DEFAULT_MFZG = "AAAAAAAAAA";
    private static final String UPDATED_MFZG = "BBBBBBBBBB";

    private static final String DEFAULT_NETPROFILEID = "AAAAAAAAAA";
    private static final String UPDATED_NETPROFILEID = "BBBBBBBBBB";

    private static final String DEFAULT_ORIGIN = "AAAAAAAAAA";
    private static final String UPDATED_ORIGIN = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORT = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORT = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORT_ENC = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORT_ENC = "BBBBBBBBBB";

    private static final String DEFAULT_POLICY_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_POLICY_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_PROFILSET = "AAAAAAAAAA";
    private static final String UPDATED_PROFILSET = "BBBBBBBBBB";

    private static final String DEFAULT_RC = "AAAAAAAAAA";
    private static final String UPDATED_RC = "BBBBBBBBBB";

    private static final String DEFAULT_RECTIME = "AAAAAAAAAA";
    private static final String UPDATED_RECTIME = "BBBBBBBBBB";

    private static final String DEFAULT_REQUEST_ID = "AAAAAAAAAA";
    private static final String UPDATED_REQUEST_ID = "BBBBBBBBBB";

    private static final String DEFAULT_RETURNMESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_RETURNMESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_RSPTIME = "AAAAAAAAAA";
    private static final String UPDATED_RSPTIME = "BBBBBBBBBB";

    private static final String DEFAULT_TLNNR = "AAAAAAAAAA";
    private static final String UPDATED_TLNNR = "BBBBBBBBBB";

    private static final String DEFAULT_TLNSPS = "AAAAAAAAAA";
    private static final String UPDATED_TLNSPS = "BBBBBBBBBB";

    private static final String DEFAULT_USER_AUTH_REQUIRED = "AAAAAAAAAA";
    private static final String UPDATED_USER_AUTH_REQUIRED = "BBBBBBBBBB";

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSubscriberMockMvc;

    private Subscriber subscriber;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Subscriber createEntity(EntityManager em) {
        Subscriber subscriber = new Subscriber()
            .asskeng(DEFAULT_ASSKENG)
            .calid(DEFAULT_CALID)
            .dnsProfile(DEFAULT_DNS_PROFILE)
            .errorelement(DEFAULT_ERRORELEMENT)
            .errormessage(DEFAULT_ERRORMESSAGE)
            .errorvalue(DEFAULT_ERRORVALUE)
            .ipversion(DEFAULT_IPVERSION)
            .keyid(DEFAULT_KEYID)
            .maxDownL3(DEFAULT_MAX_DOWN_L_3)
            .maxSessionDuration(DEFAULT_MAX_SESSION_DURATION)
            .maxUpL3(DEFAULT_MAX_UP_L_3)
            .mfzg(DEFAULT_MFZG)
            .netprofileid(DEFAULT_NETPROFILEID)
            .origin(DEFAULT_ORIGIN)
            .passwort(DEFAULT_PASSWORT)
            .passwortEnc(DEFAULT_PASSWORT_ENC)
            .policyGroup(DEFAULT_POLICY_GROUP)
            .profilset(DEFAULT_PROFILSET)
            .rc(DEFAULT_RC)
            .rectime(DEFAULT_RECTIME)
            .requestID(DEFAULT_REQUEST_ID)
            .returnmessage(DEFAULT_RETURNMESSAGE)
            .rsptime(DEFAULT_RSPTIME)
            .tlnnr(DEFAULT_TLNNR)
            .tlnsps(DEFAULT_TLNSPS)
            .userAuthRequired(DEFAULT_USER_AUTH_REQUIRED);
        return subscriber;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Subscriber createUpdatedEntity(EntityManager em) {
        Subscriber subscriber = new Subscriber()
            .asskeng(UPDATED_ASSKENG)
            .calid(UPDATED_CALID)
            .dnsProfile(UPDATED_DNS_PROFILE)
            .errorelement(UPDATED_ERRORELEMENT)
            .errormessage(UPDATED_ERRORMESSAGE)
            .errorvalue(UPDATED_ERRORVALUE)
            .ipversion(UPDATED_IPVERSION)
            .keyid(UPDATED_KEYID)
            .maxDownL3(UPDATED_MAX_DOWN_L_3)
            .maxSessionDuration(UPDATED_MAX_SESSION_DURATION)
            .maxUpL3(UPDATED_MAX_UP_L_3)
            .mfzg(UPDATED_MFZG)
            .netprofileid(UPDATED_NETPROFILEID)
            .origin(UPDATED_ORIGIN)
            .passwort(UPDATED_PASSWORT)
            .passwortEnc(UPDATED_PASSWORT_ENC)
            .policyGroup(UPDATED_POLICY_GROUP)
            .profilset(UPDATED_PROFILSET)
            .rc(UPDATED_RC)
            .rectime(UPDATED_RECTIME)
            .requestID(UPDATED_REQUEST_ID)
            .returnmessage(UPDATED_RETURNMESSAGE)
            .rsptime(UPDATED_RSPTIME)
            .tlnnr(UPDATED_TLNNR)
            .tlnsps(UPDATED_TLNSPS)
            .userAuthRequired(UPDATED_USER_AUTH_REQUIRED);
        return subscriber;
    }

    @BeforeEach
    public void initTest() {
        subscriber = createEntity(em);
    }

    @Test
    @Transactional
    public void createSubscriber() throws Exception {
        int databaseSizeBeforeCreate = subscriberRepository.findAll().size();
        // Create the Subscriber
        restSubscriberMockMvc.perform(post("/api/subscribers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(subscriber)))
            .andExpect(status().isCreated());

        // Validate the Subscriber in the database
        List<Subscriber> subscriberList = subscriberRepository.findAll();
        assertThat(subscriberList).hasSize(databaseSizeBeforeCreate + 1);
        Subscriber testSubscriber = subscriberList.get(subscriberList.size() - 1);
        assertThat(testSubscriber.getAsskeng()).isEqualTo(DEFAULT_ASSKENG);
        assertThat(testSubscriber.getCalid()).isEqualTo(DEFAULT_CALID);
        assertThat(testSubscriber.getDnsProfile()).isEqualTo(DEFAULT_DNS_PROFILE);
        assertThat(testSubscriber.getErrorelement()).isEqualTo(DEFAULT_ERRORELEMENT);
        assertThat(testSubscriber.getErrormessage()).isEqualTo(DEFAULT_ERRORMESSAGE);
        assertThat(testSubscriber.getErrorvalue()).isEqualTo(DEFAULT_ERRORVALUE);
        assertThat(testSubscriber.getIpversion()).isEqualTo(DEFAULT_IPVERSION);
        assertThat(testSubscriber.getKeyid()).isEqualTo(DEFAULT_KEYID);
        assertThat(testSubscriber.getMaxDownL3()).isEqualTo(DEFAULT_MAX_DOWN_L_3);
        assertThat(testSubscriber.getMaxSessionDuration()).isEqualTo(DEFAULT_MAX_SESSION_DURATION);
        assertThat(testSubscriber.getMaxUpL3()).isEqualTo(DEFAULT_MAX_UP_L_3);
        assertThat(testSubscriber.getMfzg()).isEqualTo(DEFAULT_MFZG);
        assertThat(testSubscriber.getNetprofileid()).isEqualTo(DEFAULT_NETPROFILEID);
        assertThat(testSubscriber.getOrigin()).isEqualTo(DEFAULT_ORIGIN);
        assertThat(testSubscriber.getPasswort()).isEqualTo(DEFAULT_PASSWORT);
        assertThat(testSubscriber.getPasswortEnc()).isEqualTo(DEFAULT_PASSWORT_ENC);
        assertThat(testSubscriber.getPolicyGroup()).isEqualTo(DEFAULT_POLICY_GROUP);
        assertThat(testSubscriber.getProfilset()).isEqualTo(DEFAULT_PROFILSET);
        assertThat(testSubscriber.getRc()).isEqualTo(DEFAULT_RC);
        assertThat(testSubscriber.getRectime()).isEqualTo(DEFAULT_RECTIME);
        assertThat(testSubscriber.getRequestID()).isEqualTo(DEFAULT_REQUEST_ID);
        assertThat(testSubscriber.getReturnmessage()).isEqualTo(DEFAULT_RETURNMESSAGE);
        assertThat(testSubscriber.getRsptime()).isEqualTo(DEFAULT_RSPTIME);
        assertThat(testSubscriber.getTlnnr()).isEqualTo(DEFAULT_TLNNR);
        assertThat(testSubscriber.getTlnsps()).isEqualTo(DEFAULT_TLNSPS);
        assertThat(testSubscriber.getUserAuthRequired()).isEqualTo(DEFAULT_USER_AUTH_REQUIRED);
    }

    @Test
    @Transactional
    public void createSubscriberWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = subscriberRepository.findAll().size();

        // Create the Subscriber with an existing ID
        subscriber.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSubscriberMockMvc.perform(post("/api/subscribers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(subscriber)))
            .andExpect(status().isBadRequest());

        // Validate the Subscriber in the database
        List<Subscriber> subscriberList = subscriberRepository.findAll();
        assertThat(subscriberList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSubscribers() throws Exception {
        // Initialize the database
        subscriberRepository.saveAndFlush(subscriber);

        // Get all the subscriberList
        restSubscriberMockMvc.perform(get("/api/subscribers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(subscriber.getId().intValue())))
            .andExpect(jsonPath("$.[*].asskeng").value(hasItem(DEFAULT_ASSKENG)))
            .andExpect(jsonPath("$.[*].calid").value(hasItem(DEFAULT_CALID)))
            .andExpect(jsonPath("$.[*].dnsProfile").value(hasItem(DEFAULT_DNS_PROFILE)))
            .andExpect(jsonPath("$.[*].errorelement").value(hasItem(DEFAULT_ERRORELEMENT)))
            .andExpect(jsonPath("$.[*].errormessage").value(hasItem(DEFAULT_ERRORMESSAGE)))
            .andExpect(jsonPath("$.[*].errorvalue").value(hasItem(DEFAULT_ERRORVALUE)))
            .andExpect(jsonPath("$.[*].ipversion").value(hasItem(DEFAULT_IPVERSION)))
            .andExpect(jsonPath("$.[*].keyid").value(hasItem(DEFAULT_KEYID)))
            .andExpect(jsonPath("$.[*].maxDownL3").value(hasItem(DEFAULT_MAX_DOWN_L_3)))
            .andExpect(jsonPath("$.[*].maxSessionDuration").value(hasItem(DEFAULT_MAX_SESSION_DURATION)))
            .andExpect(jsonPath("$.[*].maxUpL3").value(hasItem(DEFAULT_MAX_UP_L_3)))
            .andExpect(jsonPath("$.[*].mfzg").value(hasItem(DEFAULT_MFZG)))
            .andExpect(jsonPath("$.[*].netprofileid").value(hasItem(DEFAULT_NETPROFILEID)))
            .andExpect(jsonPath("$.[*].origin").value(hasItem(DEFAULT_ORIGIN)))
            .andExpect(jsonPath("$.[*].passwort").value(hasItem(DEFAULT_PASSWORT)))
            .andExpect(jsonPath("$.[*].passwortEnc").value(hasItem(DEFAULT_PASSWORT_ENC)))
            .andExpect(jsonPath("$.[*].policyGroup").value(hasItem(DEFAULT_POLICY_GROUP)))
            .andExpect(jsonPath("$.[*].profilset").value(hasItem(DEFAULT_PROFILSET)))
            .andExpect(jsonPath("$.[*].rc").value(hasItem(DEFAULT_RC)))
            .andExpect(jsonPath("$.[*].rectime").value(hasItem(DEFAULT_RECTIME)))
            .andExpect(jsonPath("$.[*].requestID").value(hasItem(DEFAULT_REQUEST_ID)))
            .andExpect(jsonPath("$.[*].returnmessage").value(hasItem(DEFAULT_RETURNMESSAGE)))
            .andExpect(jsonPath("$.[*].rsptime").value(hasItem(DEFAULT_RSPTIME)))
            .andExpect(jsonPath("$.[*].tlnnr").value(hasItem(DEFAULT_TLNNR)))
            .andExpect(jsonPath("$.[*].tlnsps").value(hasItem(DEFAULT_TLNSPS)))
            .andExpect(jsonPath("$.[*].userAuthRequired").value(hasItem(DEFAULT_USER_AUTH_REQUIRED)));
    }
    
    @Test
    @Transactional
    public void getSubscriber() throws Exception {
        // Initialize the database
        subscriberRepository.saveAndFlush(subscriber);

        // Get the subscriber
        restSubscriberMockMvc.perform(get("/api/subscribers/{id}", subscriber.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(subscriber.getId().intValue()))
            .andExpect(jsonPath("$.asskeng").value(DEFAULT_ASSKENG))
            .andExpect(jsonPath("$.calid").value(DEFAULT_CALID))
            .andExpect(jsonPath("$.dnsProfile").value(DEFAULT_DNS_PROFILE))
            .andExpect(jsonPath("$.errorelement").value(DEFAULT_ERRORELEMENT))
            .andExpect(jsonPath("$.errormessage").value(DEFAULT_ERRORMESSAGE))
            .andExpect(jsonPath("$.errorvalue").value(DEFAULT_ERRORVALUE))
            .andExpect(jsonPath("$.ipversion").value(DEFAULT_IPVERSION))
            .andExpect(jsonPath("$.keyid").value(DEFAULT_KEYID))
            .andExpect(jsonPath("$.maxDownL3").value(DEFAULT_MAX_DOWN_L_3))
            .andExpect(jsonPath("$.maxSessionDuration").value(DEFAULT_MAX_SESSION_DURATION))
            .andExpect(jsonPath("$.maxUpL3").value(DEFAULT_MAX_UP_L_3))
            .andExpect(jsonPath("$.mfzg").value(DEFAULT_MFZG))
            .andExpect(jsonPath("$.netprofileid").value(DEFAULT_NETPROFILEID))
            .andExpect(jsonPath("$.origin").value(DEFAULT_ORIGIN))
            .andExpect(jsonPath("$.passwort").value(DEFAULT_PASSWORT))
            .andExpect(jsonPath("$.passwortEnc").value(DEFAULT_PASSWORT_ENC))
            .andExpect(jsonPath("$.policyGroup").value(DEFAULT_POLICY_GROUP))
            .andExpect(jsonPath("$.profilset").value(DEFAULT_PROFILSET))
            .andExpect(jsonPath("$.rc").value(DEFAULT_RC))
            .andExpect(jsonPath("$.rectime").value(DEFAULT_RECTIME))
            .andExpect(jsonPath("$.requestID").value(DEFAULT_REQUEST_ID))
            .andExpect(jsonPath("$.returnmessage").value(DEFAULT_RETURNMESSAGE))
            .andExpect(jsonPath("$.rsptime").value(DEFAULT_RSPTIME))
            .andExpect(jsonPath("$.tlnnr").value(DEFAULT_TLNNR))
            .andExpect(jsonPath("$.tlnsps").value(DEFAULT_TLNSPS))
            .andExpect(jsonPath("$.userAuthRequired").value(DEFAULT_USER_AUTH_REQUIRED));
    }
    @Test
    @Transactional
    public void getNonExistingSubscriber() throws Exception {
        // Get the subscriber
        restSubscriberMockMvc.perform(get("/api/subscribers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSubscriber() throws Exception {
        // Initialize the database
        subscriberService.save(subscriber);

        int databaseSizeBeforeUpdate = subscriberRepository.findAll().size();

        // Update the subscriber
        Subscriber updatedSubscriber = subscriberRepository.findById(subscriber.getId()).get();
        // Disconnect from session so that the updates on updatedSubscriber are not directly saved in db
        em.detach(updatedSubscriber);
        updatedSubscriber
            .asskeng(UPDATED_ASSKENG)
            .calid(UPDATED_CALID)
            .dnsProfile(UPDATED_DNS_PROFILE)
            .errorelement(UPDATED_ERRORELEMENT)
            .errormessage(UPDATED_ERRORMESSAGE)
            .errorvalue(UPDATED_ERRORVALUE)
            .ipversion(UPDATED_IPVERSION)
            .keyid(UPDATED_KEYID)
            .maxDownL3(UPDATED_MAX_DOWN_L_3)
            .maxSessionDuration(UPDATED_MAX_SESSION_DURATION)
            .maxUpL3(UPDATED_MAX_UP_L_3)
            .mfzg(UPDATED_MFZG)
            .netprofileid(UPDATED_NETPROFILEID)
            .origin(UPDATED_ORIGIN)
            .passwort(UPDATED_PASSWORT)
            .passwortEnc(UPDATED_PASSWORT_ENC)
            .policyGroup(UPDATED_POLICY_GROUP)
            .profilset(UPDATED_PROFILSET)
            .rc(UPDATED_RC)
            .rectime(UPDATED_RECTIME)
            .requestID(UPDATED_REQUEST_ID)
            .returnmessage(UPDATED_RETURNMESSAGE)
            .rsptime(UPDATED_RSPTIME)
            .tlnnr(UPDATED_TLNNR)
            .tlnsps(UPDATED_TLNSPS)
            .userAuthRequired(UPDATED_USER_AUTH_REQUIRED);

        restSubscriberMockMvc.perform(put("/api/subscribers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSubscriber)))
            .andExpect(status().isOk());

        // Validate the Subscriber in the database
        List<Subscriber> subscriberList = subscriberRepository.findAll();
        assertThat(subscriberList).hasSize(databaseSizeBeforeUpdate);
        Subscriber testSubscriber = subscriberList.get(subscriberList.size() - 1);
        assertThat(testSubscriber.getAsskeng()).isEqualTo(UPDATED_ASSKENG);
        assertThat(testSubscriber.getCalid()).isEqualTo(UPDATED_CALID);
        assertThat(testSubscriber.getDnsProfile()).isEqualTo(UPDATED_DNS_PROFILE);
        assertThat(testSubscriber.getErrorelement()).isEqualTo(UPDATED_ERRORELEMENT);
        assertThat(testSubscriber.getErrormessage()).isEqualTo(UPDATED_ERRORMESSAGE);
        assertThat(testSubscriber.getErrorvalue()).isEqualTo(UPDATED_ERRORVALUE);
        assertThat(testSubscriber.getIpversion()).isEqualTo(UPDATED_IPVERSION);
        assertThat(testSubscriber.getKeyid()).isEqualTo(UPDATED_KEYID);
        assertThat(testSubscriber.getMaxDownL3()).isEqualTo(UPDATED_MAX_DOWN_L_3);
        assertThat(testSubscriber.getMaxSessionDuration()).isEqualTo(UPDATED_MAX_SESSION_DURATION);
        assertThat(testSubscriber.getMaxUpL3()).isEqualTo(UPDATED_MAX_UP_L_3);
        assertThat(testSubscriber.getMfzg()).isEqualTo(UPDATED_MFZG);
        assertThat(testSubscriber.getNetprofileid()).isEqualTo(UPDATED_NETPROFILEID);
        assertThat(testSubscriber.getOrigin()).isEqualTo(UPDATED_ORIGIN);
        assertThat(testSubscriber.getPasswort()).isEqualTo(UPDATED_PASSWORT);
        assertThat(testSubscriber.getPasswortEnc()).isEqualTo(UPDATED_PASSWORT_ENC);
        assertThat(testSubscriber.getPolicyGroup()).isEqualTo(UPDATED_POLICY_GROUP);
        assertThat(testSubscriber.getProfilset()).isEqualTo(UPDATED_PROFILSET);
        assertThat(testSubscriber.getRc()).isEqualTo(UPDATED_RC);
        assertThat(testSubscriber.getRectime()).isEqualTo(UPDATED_RECTIME);
        assertThat(testSubscriber.getRequestID()).isEqualTo(UPDATED_REQUEST_ID);
        assertThat(testSubscriber.getReturnmessage()).isEqualTo(UPDATED_RETURNMESSAGE);
        assertThat(testSubscriber.getRsptime()).isEqualTo(UPDATED_RSPTIME);
        assertThat(testSubscriber.getTlnnr()).isEqualTo(UPDATED_TLNNR);
        assertThat(testSubscriber.getTlnsps()).isEqualTo(UPDATED_TLNSPS);
        assertThat(testSubscriber.getUserAuthRequired()).isEqualTo(UPDATED_USER_AUTH_REQUIRED);
    }

    @Test
    @Transactional
    public void updateNonExistingSubscriber() throws Exception {
        int databaseSizeBeforeUpdate = subscriberRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSubscriberMockMvc.perform(put("/api/subscribers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(subscriber)))
            .andExpect(status().isBadRequest());

        // Validate the Subscriber in the database
        List<Subscriber> subscriberList = subscriberRepository.findAll();
        assertThat(subscriberList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSubscriber() throws Exception {
        // Initialize the database
        subscriberService.save(subscriber);

        int databaseSizeBeforeDelete = subscriberRepository.findAll().size();

        // Delete the subscriber
        restSubscriberMockMvc.perform(delete("/api/subscribers/{id}", subscriber.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Subscriber> subscriberList = subscriberRepository.findAll();
        assertThat(subscriberList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
