package com.dtit.tm.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dtit.tm.web.rest.TestUtil;

public class CredentialsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Credentials.class);
        Credentials credentials1 = new Credentials();
        credentials1.setId(1L);
        Credentials credentials2 = new Credentials();
        credentials2.setId(credentials1.getId());
        assertThat(credentials1).isEqualTo(credentials2);
        credentials2.setId(2L);
        assertThat(credentials1).isNotEqualTo(credentials2);
        credentials1.setId(null);
        assertThat(credentials1).isNotEqualTo(credentials2);
    }
}
