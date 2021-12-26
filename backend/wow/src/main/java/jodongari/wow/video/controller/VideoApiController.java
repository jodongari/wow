package jodongari.wow.video.controller;

import jodongari.wow.video.config.VideoApiUrl;
import jodongari.wow.video.dto.request.VideoUploadRequest;
import jodongari.wow.video.dto.response.VideoUploadResponse;
import jodongari.wow.video.service.VideoApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/video")
public class VideoApiController {

    private final VideoApiService videoApiService;

    @PostMapping(value = VideoApiUrl.VIDEO_UPLOAD,
    consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE
    })
    public ResponseEntity<VideoUploadResponse> upload(@ModelAttribute VideoUploadRequest request) {
        return videoApiService.upload(request);
    }
}
