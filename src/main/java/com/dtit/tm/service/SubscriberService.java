package com.dtit.tm.service;

import com.dtit.tm.domain.Subscriber;
import com.dtit.tm.repository.SubscriberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Subscriber}.
 */
@Service
@Transactional
public class SubscriberService {

    private final Logger log = LoggerFactory.getLogger(SubscriberService.class);

    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    /**
     * Save a subscriber.
     *
     * @param subscriber the entity to save.
     * @return the persisted entity.
     */
    public Subscriber save(Subscriber subscriber) {
        log.debug("Request to save Subscriber : {}", subscriber);
        return subscriberRepository.save(subscriber);
    }

    /**
     * Get all the subscribers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Subscriber> findAll(Pageable pageable) {
        log.debug("Request to get all Subscribers");
        return subscriberRepository.findAll(pageable);
    }


    /**
     * Get one subscriber by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Subscriber> findOne(Long id) {
        log.debug("Request to get Subscriber : {}", id);
        return subscriberRepository.findById(id);
    }

    /**
     * Delete the subscriber by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Subscriber : {}", id);
        subscriberRepository.deleteById(id);
    }
}
