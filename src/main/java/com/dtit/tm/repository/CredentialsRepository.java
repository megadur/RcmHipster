package com.dtit.tm.repository;

import com.dtit.tm.domain.Credentials;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Credentials entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
}
