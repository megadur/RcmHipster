package com.dtit.tm.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IpCredentailsMapperTest {

    private IpCredentailsMapper ipCredentailsMapper;

    @BeforeEach
    public void setUp() {
        ipCredentailsMapper = new IpCredentailsMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(ipCredentailsMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(ipCredentailsMapper.fromId(null)).isNull();
    }
}
