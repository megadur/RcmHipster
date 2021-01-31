package com.dtit.tm.service.mapper;


import com.dtit.tm.domain.*;
import com.dtit.tm.service.dto.CredentialsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Credentials} and its DTO {@link CredentialsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CredentialsMapper extends EntityMapper<CredentialsDTO, Credentials> {



    default Credentials fromId(Long id) {
        if (id == null) {
            return null;
        }
        Credentials credentials = new Credentials();
        credentials.setId(id);
        return credentials;
    }
}
