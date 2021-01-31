package com.dtit.tm.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LineMapperTest {

    private LineMapper lineMapper;

    @BeforeEach
    public void setUp() {
        lineMapper = new LineMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(lineMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(lineMapper.fromId(null)).isNull();
    }
}
