package com.dtit.tm.service;

import com.dtit.tm.domain.IpCredentails;
import com.dtit.tm.repository.IpCredentailsRepository;
import com.dtit.tm.service.dto.IpCredentailsDTO;
import com.dtit.tm.service.mapper.IpCredentailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link IpCredentails}.
 */
@Service
@Transactional
public class IpCredentailsService {

    private final Logger log = LoggerFactory.getLogger(IpCredentailsService.class);

    private final IpCredentailsRepository ipCredentailsRepository;

    private final IpCredentailsMapper ipCredentailsMapper;

    public IpCredentailsService(IpCredentailsRepository ipCredentailsRepository, IpCredentailsMapper ipCredentailsMapper) {
        this.ipCredentailsRepository = ipCredentailsRepository;
        this.ipCredentailsMapper = ipCredentailsMapper;
    }

    /**
     * Save a ipCredentails.
     *
     * @param ipCredentailsDTO the entity to save.
     * @return the persisted entity.
     */
    public IpCredentailsDTO save(IpCredentailsDTO ipCredentailsDTO) {
        log.debug("Request to save IpCredentails : {}", ipCredentailsDTO);
        IpCredentails ipCredentails = ipCredentailsMapper.toEntity(ipCredentailsDTO);
        ipCredentails = ipCredentailsRepository.save(ipCredentails);
        return ipCredentailsMapper.toDto(ipCredentails);
    }

    /**
     * Get all the ipCredentails.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<IpCredentailsDTO> findAll() {
        log.debug("Request to get all IpCredentails");
        return ipCredentailsRepository.findAll().stream()
            .map(ipCredentailsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one ipCredentails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<IpCredentailsDTO> findOne(Long id) {
        log.debug("Request to get IpCredentails : {}", id);
        return ipCredentailsRepository.findById(id)
            .map(ipCredentailsMapper::toDto);
    }

    /**
     * Delete the ipCredentails by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete IpCredentails : {}", id);
        ipCredentailsRepository.deleteById(id);
    }
}
