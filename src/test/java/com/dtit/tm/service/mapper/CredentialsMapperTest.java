package com.dtit.tm.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CredentialsMapperTest {

    private CredentialsMapper credentialsMapper;

    @BeforeEach
    public void setUp() {
        credentialsMapper = new CredentialsMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(credentialsMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(credentialsMapper.fromId(null)).isNull();
    }
}
