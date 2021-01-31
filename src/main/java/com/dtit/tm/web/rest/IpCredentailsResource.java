package com.dtit.tm.web.rest;

import com.dtit.tm.service.IpCredentailsService;
import com.dtit.tm.web.rest.errors.BadRequestAlertException;
import com.dtit.tm.service.dto.IpCredentailsDTO;

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
 * REST controller for managing {@link com.dtit.tm.domain.IpCredentails}.
 */
@RestController
@RequestMapping("/api")
public class IpCredentailsResource {

    private final Logger log = LoggerFactory.getLogger(IpCredentailsResource.class);

    private static final String ENTITY_NAME = "ipCredentails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IpCredentailsService ipCredentailsService;

    public IpCredentailsResource(IpCredentailsService ipCredentailsService) {
        this.ipCredentailsService = ipCredentailsService;
    }

    /**
     * {@code POST  /ip-credentails} : Create a new ipCredentails.
     *
     * @param ipCredentailsDTO the ipCredentailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ipCredentailsDTO, or with status {@code 400 (Bad Request)} if the ipCredentails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ip-credentails")
    public ResponseEntity<IpCredentailsDTO> createIpCredentails(@RequestBody IpCredentailsDTO ipCredentailsDTO) throws URISyntaxException {
        log.debug("REST request to save IpCredentails : {}", ipCredentailsDTO);
        if (ipCredentailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new ipCredentails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IpCredentailsDTO result = ipCredentailsService.save(ipCredentailsDTO);
        return ResponseEntity.created(new URI("/api/ip-credentails/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ip-credentails} : Updates an existing ipCredentails.
     *
     * @param ipCredentailsDTO the ipCredentailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ipCredentailsDTO,
     * or with status {@code 400 (Bad Request)} if the ipCredentailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ipCredentailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ip-credentails")
    public ResponseEntity<IpCredentailsDTO> updateIpCredentails(@RequestBody IpCredentailsDTO ipCredentailsDTO) throws URISyntaxException {
        log.debug("REST request to update IpCredentails : {}", ipCredentailsDTO);
        if (ipCredentailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IpCredentailsDTO result = ipCredentailsService.save(ipCredentailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, ipCredentailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ip-credentails} : get all the ipCredentails.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ipCredentails in body.
     */
    @GetMapping("/ip-credentails")
    public List<IpCredentailsDTO> getAllIpCredentails() {
        log.debug("REST request to get all IpCredentails");
        return ipCredentailsService.findAll();
    }

    /**
     * {@code GET  /ip-credentails/:id} : get the "id" ipCredentails.
     *
     * @param id the id of the ipCredentailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ipCredentailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ip-credentails/{id}")
    public ResponseEntity<IpCredentailsDTO> getIpCredentails(@PathVariable Long id) {
        log.debug("REST request to get IpCredentails : {}", id);
        Optional<IpCredentailsDTO> ipCredentailsDTO = ipCredentailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ipCredentailsDTO);
    }

    /**
     * {@code DELETE  /ip-credentails/:id} : delete the "id" ipCredentails.
     *
     * @param id the id of the ipCredentailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ip-credentails/{id}")
    public ResponseEntity<Void> deleteIpCredentails(@PathVariable Long id) {
        log.debug("REST request to delete IpCredentails : {}", id);
        ipCredentailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
