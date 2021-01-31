package com.dtit.tm.service.mapper;


import com.dtit.tm.domain.*;
import com.dtit.tm.service.dto.SubscriberDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Subscriber} and its DTO {@link SubscriberDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SubscriberMapper extends EntityMapper<SubscriberDTO, Subscriber> {



    default Subscriber fromId(Long id) {
        if (id == null) {
            return null;
        }
        Subscriber subscriber = new Subscriber();
        subscriber.setId(id);
        return subscriber;
    }
}
