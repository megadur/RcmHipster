package com.dtit.tm.service.mapper;


import com.dtit.tm.domain.*;
import com.dtit.tm.service.dto.IpAccessDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link IpAccess} and its DTO {@link IpAccessDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IpAccessMapper extends EntityMapper<IpAccessDTO, IpAccess> {



    default IpAccess fromId(Long id) {
        if (id == null) {
            return null;
        }
        IpAccess ipAccess = new IpAccess();
        ipAccess.setId(id);
        return ipAccess;
    }
}
