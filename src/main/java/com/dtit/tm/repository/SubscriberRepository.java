package com.dtit.tm.repository;

import com.dtit.tm.domain.Subscriber;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Subscriber entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
