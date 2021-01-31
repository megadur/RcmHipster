package com.dtit.tm.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IpAccessMapperTest {

    private IpAccessMapper ipAccessMapper;

    @BeforeEach
    public void setUp() {
        ipAccessMapper = new IpAccessMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(ipAccessMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(ipAccessMapper.fromId(null)).isNull();
    }
}
