package com.dtit.tm.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SubscriberMapperTest {

    private SubscriberMapper subscriberMapper;

    @BeforeEach
    public void setUp() {
        subscriberMapper = new SubscriberMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(subscriberMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(subscriberMapper.fromId(null)).isNull();
    }
}
