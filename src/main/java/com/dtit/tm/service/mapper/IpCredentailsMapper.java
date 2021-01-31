package com.dtit.tm.service.mapper;


import com.dtit.tm.domain.*;
import com.dtit.tm.service.dto.IpCredentailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link IpCredentails} and its DTO {@link IpCredentailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IpCredentailsMapper extends EntityMapper<IpCredentailsDTO, IpCredentails> {



    default IpCredentails fromId(Long id) {
        if (id == null) {
            return null;
        }
        IpCredentails ipCredentails = new IpCredentails();
        ipCredentails.setId(id);
        return ipCredentails;
    }
}
