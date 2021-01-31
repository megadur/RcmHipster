package com.dtit.tm.web.rest;

import com.dtit.tm.service.CredentialsService;
import com.dtit.tm.web.rest.errors.BadRequestAlertException;
import com.dtit.tm.service.dto.CredentialsDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.dtit.tm.domain.Credentials}.
 */
@RestController
@RequestMapping("/api")
public class CredentialsResource {

    private final Logger log = LoggerFactory.getLogger(CredentialsResource.class);

    private static final String ENTITY_NAME = "credentials";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CredentialsService credentialsService;

    public CredentialsResource(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    /**
     * {@code POST  /credentials} : Create a new credentials.
     *
     * @param credentialsDTO the credentialsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new credentialsDTO, or with status {@code 400 (Bad Request)} if the credentials has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/credentials")
    public ResponseEntity<CredentialsDTO> createCredentials(@RequestBody CredentialsDTO credentialsDTO) throws URISyntaxException {
        log.debug("REST request to save Credentials : {}", credentialsDTO);
        if (credentialsDTO.getId() != null) {
            throw new BadRequestAlertException("A new credentials cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CredentialsDTO result = credentialsService.save(credentialsDTO);
        return ResponseEntity.created(new URI("/api/credentials/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /credentials} : Updates an existing credentials.
     *
     * @param credentialsDTO the credentialsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated credentialsDTO,
     * or with status {@code 400 (Bad Request)} if the credentialsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the credentialsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/credentials")
    public ResponseEntity<CredentialsDTO> updateCredentials(@RequestBody CredentialsDTO credentialsDTO) throws URISyntaxException {
        log.debug("REST request to update Credentials : {}", credentialsDTO);
        if (credentialsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CredentialsDTO result = credentialsService.save(credentialsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, credentialsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /credentials} : get all the credentials.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of credentials in body.
     */
    @GetMapping("/credentials")
    public List<CredentialsDTO> getAllCredentials() {
        log.debug("REST request to get all Credentials");
        return credentialsService.findAll();
    }

    /**
     * {@code GET  /credentials/:id} : get the "id" credentials.
     *
     * @param id the id of the credentialsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the credentialsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/credentials/{id}")
    public ResponseEntity<CredentialsDTO> getCredentials(@PathVariable Long id) {
        log.debug("REST request to get Credentials : {}", id);
        Optional<CredentialsDTO> credentialsDTO = credentialsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(credentialsDTO);
    }

    /**
     * {@code DELETE  /credentials/:id} : delete the "id" credentials.
     *
     * @param id the id of the credentialsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/credentials/{id}")
    public ResponseEntity<Void> deleteCredentials(@PathVariable Long id) {
        log.debug("REST request to delete Credentials : {}", id);
        credentialsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
