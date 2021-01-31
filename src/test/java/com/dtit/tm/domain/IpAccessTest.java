package com.dtit.tm.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dtit.tm.web.rest.TestUtil;

public class IpAccessTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(IpAccess.class);
        IpAccess ipAccess1 = new IpAccess();
        ipAccess1.setId(1L);
        IpAccess ipAccess2 = new IpAccess();
        ipAccess2.setId(ipAccess1.getId());
        assertThat(ipAccess1).isEqualTo(ipAccess2);
        ipAccess2.setId(2L);
        assertThat(ipAccess1).isNotEqualTo(ipAccess2);
        ipAccess1.setId(null);
        assertThat(ipAccess1).isNotEqualTo(ipAccess2);
    }
}
