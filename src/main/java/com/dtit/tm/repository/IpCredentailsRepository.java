package com.dtit.tm.repository;

import com.dtit.tm.domain.IpCredentails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the IpCredentails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IpCredentailsRepository extends JpaRepository<IpCredentails, Long> {
}
