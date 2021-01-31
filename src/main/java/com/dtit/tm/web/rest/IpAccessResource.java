package com.dtit.tm.web.rest;

import com.dtit.tm.domain.IpAccess;
import com.dtit.tm.service.IpAccessService;
import com.dtit.tm.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.dtit.tm.domain.IpAccess}.
 */
@RestController
@RequestMapping("/api")
public class IpAccessResource {

    private final Logger log = LoggerFactory.getLogger(IpAccessResource.class);

    private static final String ENTITY_NAME = "ipAccess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IpAccessService ipAccessService;

    public IpAccessResource(IpAccessService ipAccessService) {
        this.ipAccessService = ipAccessService;
    }

    /**
     * {@code POST  /ip-accesses} : Create a new ipAccess.
     *
     * @param ipAccess the ipAccess to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ipAccess, or with status {@code 400 (Bad Request)} if the ipAccess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ip-accesses")
    public ResponseEntity<IpAccess> createIpAccess(@RequestBody IpAccess ipAccess) throws URISyntaxException {
        log.debug("REST request to save IpAccess : {}", ipAccess);
        if (ipAccess.getId() != null) {
            throw new BadRequestAlertException("A new ipAccess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IpAccess result = ipAccessService.save(ipAccess);
        return ResponseEntity.created(new URI("/api/ip-accesses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ip-accesses} : Updates an existing ipAccess.
     *
     * @param ipAccess the ipAccess to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ipAccess,
     * or with status {@code 400 (Bad Request)} if the ipAccess is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ipAccess couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ip-accesses")
    public ResponseEntity<IpAccess> updateIpAccess(@RequestBody IpAccess ipAccess) throws URISyntaxException {
        log.debug("REST request to update IpAccess : {}", ipAccess);
        if (ipAccess.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IpAccess result = ipAccessService.save(ipAccess);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, ipAccess.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ip-accesses} : get all the ipAccesses.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ipAccesses in body.
     */
    @GetMapping("/ip-accesses")
    public ResponseEntity<List<IpAccess>> getAllIpAccesses(Pageable pageable) {
        log.debug("REST request to get a page of IpAccesses");
        Page<IpAccess> page = ipAccessService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ip-accesses/:id} : get the "id" ipAccess.
     *
     * @param id the id of the ipAccess to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ipAccess, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ip-accesses/{id}")
    public ResponseEntity<IpAccess> getIpAccess(@PathVariable Long id) {
        log.debug("REST request to get IpAccess : {}", id);
        Optional<IpAccess> ipAccess = ipAccessService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ipAccess);
    }

    /**
     * {@code DELETE  /ip-accesses/:id} : delete the "id" ipAccess.
     *
     * @param id the id of the ipAccess to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ip-accesses/{id}")
    public ResponseEntity<Void> deleteIpAccess(@PathVariable Long id) {
        log.debug("REST request to delete IpAccess : {}", id);
        ipAccessService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
