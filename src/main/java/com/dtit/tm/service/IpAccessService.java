package com.dtit.tm.service;

import com.dtit.tm.domain.IpAccess;
import com.dtit.tm.repository.IpAccessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link IpAccess}.
 */
@Service
@Transactional
public class IpAccessService {

    private final Logger log = LoggerFactory.getLogger(IpAccessService.class);

    private final IpAccessRepository ipAccessRepository;

    public IpAccessService(IpAccessRepository ipAccessRepository) {
        this.ipAccessRepository = ipAccessRepository;
    }

    /**
     * Save a ipAccess.
     *
     * @param ipAccess the entity to save.
     * @return the persisted entity.
     */
    public IpAccess save(IpAccess ipAccess) {
        log.debug("Request to save IpAccess : {}", ipAccess);
        return ipAccessRepository.save(ipAccess);
    }

    /**
     * Get all the ipAccesses.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<IpAccess> findAll(Pageable pageable) {
        log.debug("Request to get all IpAccesses");
        return ipAccessRepository.findAll(pageable);
    }


    /**
     * Get one ipAccess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<IpAccess> findOne(Long id) {
        log.debug("Request to get IpAccess : {}", id);
        return ipAccessRepository.findById(id);
    }

    /**
     * Delete the ipAccess by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete IpAccess : {}", id);
        ipAccessRepository.deleteById(id);
    }
}
