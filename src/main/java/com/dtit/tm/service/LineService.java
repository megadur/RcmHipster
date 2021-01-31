package com.dtit.tm.service;

import com.dtit.tm.domain.Line;
import com.dtit.tm.repository.LineRepository;
import com.dtit.tm.service.dto.LineDTO;
import com.dtit.tm.service.mapper.LineMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Line}.
 */
@Service
@Transactional
public class LineService {

    private final Logger log = LoggerFactory.getLogger(LineService.class);

    private final LineRepository lineRepository;

    private final LineMapper lineMapper;

    public LineService(LineRepository lineRepository, LineMapper lineMapper) {
        this.lineRepository = lineRepository;
        this.lineMapper = lineMapper;
    }

    /**
     * Save a line.
     *
     * @param lineDTO the entity to save.
     * @return the persisted entity.
     */
    public LineDTO save(LineDTO lineDTO) {
        log.debug("Request to save Line : {}", lineDTO);
        Line line = lineMapper.toEntity(lineDTO);
        line = lineRepository.save(line);
        return lineMapper.toDto(line);
    }

    /**
     * Get all the lines.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<LineDTO> findAll() {
        log.debug("Request to get all Lines");
        return lineRepository.findAll().stream()
            .map(lineMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one line by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<LineDTO> findOne(Long id) {
        log.debug("Request to get Line : {}", id);
        return lineRepository.findById(id)
            .map(lineMapper::toDto);
    }

    /**
     * Delete the line by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Line : {}", id);
        lineRepository.deleteById(id);
    }
}
