package com.dtit.tm.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dtit.tm.web.rest.TestUtil;

public class CredentialsDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CredentialsDTO.class);
        CredentialsDTO credentialsDTO1 = new CredentialsDTO();
        credentialsDTO1.setId(1L);
        CredentialsDTO credentialsDTO2 = new CredentialsDTO();
        assertThat(credentialsDTO1).isNotEqualTo(credentialsDTO2);
        credentialsDTO2.setId(credentialsDTO1.getId());
        assertThat(credentialsDTO1).isEqualTo(credentialsDTO2);
        credentialsDTO2.setId(2L);
        assertThat(credentialsDTO1).isNotEqualTo(credentialsDTO2);
        credentialsDTO1.setId(null);
        assertThat(credentialsDTO1).isNotEqualTo(credentialsDTO2);
    }
}
