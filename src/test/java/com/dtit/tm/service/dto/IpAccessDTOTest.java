package com.dtit.tm.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dtit.tm.web.rest.TestUtil;

public class IpAccessDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(IpAccessDTO.class);
        IpAccessDTO ipAccessDTO1 = new IpAccessDTO();
        ipAccessDTO1.setId(1L);
        IpAccessDTO ipAccessDTO2 = new IpAccessDTO();
        assertThat(ipAccessDTO1).isNotEqualTo(ipAccessDTO2);
        ipAccessDTO2.setId(ipAccessDTO1.getId());
        assertThat(ipAccessDTO1).isEqualTo(ipAccessDTO2);
        ipAccessDTO2.setId(2L);
        assertThat(ipAccessDTO1).isNotEqualTo(ipAccessDTO2);
        ipAccessDTO1.setId(null);
        assertThat(ipAccessDTO1).isNotEqualTo(ipAccessDTO2);
    }
}
