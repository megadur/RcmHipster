package com.dtit.tm.service.mapper;


import com.dtit.tm.domain.*;
import com.dtit.tm.service.dto.LineDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Line} and its DTO {@link LineDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface LineMapper extends EntityMapper<LineDTO, Line> {



    default Line fromId(Long id) {
        if (id == null) {
            return null;
        }
        Line line = new Line();
        line.setId(id);
        return line;
    }
}
