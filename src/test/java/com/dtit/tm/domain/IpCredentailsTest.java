package com.dtit.tm.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dtit.tm.web.rest.TestUtil;

public class IpCredentailsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(IpCredentails.class);
        IpCredentails ipCredentails1 = new IpCredentails();
        ipCredentails1.setId(1L);
        IpCredentails ipCredentails2 = new IpCredentails();
        ipCredentails2.setId(ipCredentails1.getId());
        assertThat(ipCredentails1).isEqualTo(ipCredentails2);
        ipCredentails2.setId(2L);
        assertThat(ipCredentails1).isNotEqualTo(ipCredentails2);
        ipCredentails1.setId(null);
        assertThat(ipCredentails1).isNotEqualTo(ipCredentails2);
    }
}
