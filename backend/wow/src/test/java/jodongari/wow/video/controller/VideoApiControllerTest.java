package jodongari.wow.video.controller;

import jodongari.wow.video.repository.VideoRepository;
import jodongari.wow.video.repository.entity.VideoEntity;
import jodongari.wow.video.service.VideoApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(VideoApiController.class)
class VideoApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private VideoApiService videoApiService;

    @MockBean
    private VideoRepository videoRepository;

    @Test
    public void exceptionTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/video/v1/upload"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    public void listTest() throws Exception {

        VideoEntity videoEntity = VideoEntity.builder()
                .videoHash("test1")
                .videoName("jodongari")
                .description("조동아리 비디오 테스트")
                .manifestPath("test1/path")
                .runningTime(2000L)
                .build();
        System.out.println(videoEntity);
        VideoEntity test1 = videoRepository.save(videoEntity);
        System.out.println(test1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/video/v1/list"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}


