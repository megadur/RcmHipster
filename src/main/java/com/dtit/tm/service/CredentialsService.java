package com.dtit.tm.service;

import com.dtit.tm.domain.Credentials;
import com.dtit.tm.repository.CredentialsRepository;
import com.dtit.tm.service.dto.CredentialsDTO;
import com.dtit.tm.service.mapper.CredentialsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Credentials}.
 */
@Service
@Transactional
public class CredentialsService {

    private final Logger log = LoggerFactory.getLogger(CredentialsService.class);

    private final CredentialsRepository credentialsRepository;

    private final CredentialsMapper credentialsMapper;

    public CredentialsService(CredentialsRepository credentialsRepository, CredentialsMapper credentialsMapper) {
        this.credentialsRepository = credentialsRepository;
        this.credentialsMapper = credentialsMapper;
    }

    /**
     * Save a credentials.
     *
     * @param credentialsDTO the entity to save.
     * @return the persisted entity.
     */
    public CredentialsDTO save(CredentialsDTO credentialsDTO) {
        log.debug("Request to save Credentials : {}", credentialsDTO);
        Credentials credentials = credentialsMapper.toEntity(credentialsDTO);
        credentials = credentialsRepository.save(credentials);
        return credentialsMapper.toDto(credentials);
    }

    /**
     * Get all the credentials.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<CredentialsDTO> findAll() {
        log.debug("Request to get all Credentials");
        return credentialsRepository.findAll().stream()
            .map(credentialsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one credentials by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CredentialsDTO> findOne(Long id) {
        log.debug("Request to get Credentials : {}", id);
        return credentialsRepository.findById(id)
            .map(credentialsMapper::toDto);
    }

    /**
     * Delete the credentials by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Credentials : {}", id);
        credentialsRepository.deleteById(id);
    }
}
