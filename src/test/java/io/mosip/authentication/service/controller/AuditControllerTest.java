package io.mosip.authentication.service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.mosip.authentication.service.dto.AuditRequest;
import io.mosip.authentication.service.repositories.AuditEventRepository;
import io.mosip.kernel.core.util.exception.JsonProcessingException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(AuditController.class)
public class AuditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuditEventRepository repository;

    @Test
    public void testAuditLogSuccess() throws JsonProcessingException , Exception {

        ObjectMapper mapper = new ObjectMapper();
        var data = new  AuditRequest("LOGIN","User attempted login","12345");
        String payload = mapper.writeValueAsString(data);

        mockMvc.perform(post("/api/v1/audit/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk());
    }
}
