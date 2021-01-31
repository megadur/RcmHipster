package com.dtit.tm.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.dtit.tm.web.rest.TestUtil;

public class LineDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(LineDTO.class);
        LineDTO lineDTO1 = new LineDTO();
        lineDTO1.setId(1L);
        LineDTO lineDTO2 = new LineDTO();
        assertThat(lineDTO1).isNotEqualTo(lineDTO2);
        lineDTO2.setId(lineDTO1.getId());
        assertThat(lineDTO1).isEqualTo(lineDTO2);
        lineDTO2.setId(2L);
        assertThat(lineDTO1).isNotEqualTo(lineDTO2);
        lineDTO1.setId(null);
        assertThat(lineDTO1).isNotEqualTo(lineDTO2);
    }
}
