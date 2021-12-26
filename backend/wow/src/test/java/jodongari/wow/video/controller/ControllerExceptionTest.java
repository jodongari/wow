package jodongari.wow.video.controller;

import jodongari.wow.protocol.ResultResponse;
import jodongari.wow.video.service.VideoApiService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class ControllerExceptionTest {
    @InjectMocks
    private MockMvc mockMvc;

    @Mock
    private VideoApiService videoApiService;

    @Test
    public void exceptionTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("api/video/v1/upload"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
