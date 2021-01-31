package com.dtit.tm.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dtit.tm.web.rest.TestUtil;

public class IpCredentailsDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(IpCredentailsDTO.class);
        IpCredentailsDTO ipCredentailsDTO1 = new IpCredentailsDTO();
        ipCredentailsDTO1.setId(1L);
        IpCredentailsDTO ipCredentailsDTO2 = new IpCredentailsDTO();
        assertThat(ipCredentailsDTO1).isNotEqualTo(ipCredentailsDTO2);
        ipCredentailsDTO2.setId(ipCredentailsDTO1.getId());
        assertThat(ipCredentailsDTO1).isEqualTo(ipCredentailsDTO2);
        ipCredentailsDTO2.setId(2L);
        assertThat(ipCredentailsDTO1).isNotEqualTo(ipCredentailsDTO2);
        ipCredentailsDTO1.setId(null);
        assertThat(ipCredentailsDTO1).isNotEqualTo(ipCredentailsDTO2);
    }
}
