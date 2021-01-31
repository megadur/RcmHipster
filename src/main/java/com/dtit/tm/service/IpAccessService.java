package com.dtit.tm.service;

import com.dtit.tm.domain.IpAccess;
import com.dtit.tm.repository.IpAccessRepository;
import com.dtit.tm.service.dto.IpAccessDTO;
import com.dtit.tm.service.mapper.IpAccessMapper;
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

    private final IpAccessMapper ipAccessMapper;

    public IpAccessService(IpAccessRepository ipAccessRepository, IpAccessMapper ipAccessMapper) {
        this.ipAccessRepository = ipAccessRepository;
        this.ipAccessMapper = ipAccessMapper;
    }

    /**
     * Save a ipAccess.
     *
     * @param ipAccessDTO the entity to save.
     * @return the persisted entity.
     */
    public IpAccessDTO save(IpAccessDTO ipAccessDTO) {
        log.debug("Request to save IpAccess : {}", ipAccessDTO);
        IpAccess ipAccess = ipAccessMapper.toEntity(ipAccessDTO);
        ipAccess = ipAccessRepository.save(ipAccess);
        return ipAccessMapper.toDto(ipAccess);
    }

    /**
     * Get all the ipAccesses.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<IpAccessDTO> findAll(Pageable pageable) {
        log.debug("Request to get all IpAccesses");
        return ipAccessRepository.findAll(pageable)
            .map(ipAccessMapper::toDto);
    }


    /**
     * Get one ipAccess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<IpAccessDTO> findOne(Long id) {
        log.debug("Request to get IpAccess : {}", id);
        return ipAccessRepository.findById(id)
            .map(ipAccessMapper::toDto);
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
