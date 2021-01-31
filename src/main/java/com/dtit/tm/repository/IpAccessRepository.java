package com.dtit.tm.repository;

import com.dtit.tm.domain.IpAccess;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the IpAccess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IpAccessRepository extends JpaRepository<IpAccess, Long> {
}
