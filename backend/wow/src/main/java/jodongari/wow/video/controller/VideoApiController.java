package jodongari.wow.video.controller;

import jodongari.wow.protocol.ResultResponse;
import jodongari.wow.video.config.VideoApiUrl;
import jodongari.wow.video.dto.request.VideoDownloadRequest;
import jodongari.wow.video.dto.request.VideoUploadRequest;
import jodongari.wow.video.dto.response.VideoUploadResponse;
import jodongari.wow.video.service.VideoApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/video")
public class VideoApiController {

    private final VideoApiService videoApiService;

    @PostMapping(value = VideoApiUrl.VIDEO_UPLOAD)
    public ResponseEntity<VideoUploadResponse> upload(@Valid @ModelAttribute VideoUploadRequest request) {
        return videoApiService.upload(request);
    }

    // hash -> DB 주소 -> 주소로
    // 1. 해시코드로 동영상을 요청함
    // 2. DB에서 해당 해시코드 동영상의 주소를 가져옴
    // 3. 로컬캐시에 HashMap<해시코드, 주소> 형태로 주소를 저장해서 가져온다?

    @GetMapping(value = VideoApiUrl.VIDEO_DOWNLOAD + "/{path}")
    @ResponseBody
    public ResponseEntity<byte[]> download(@PathVariable String path) {
        try{
            return videoApiService.download(path);
        } catch (Exception e){
            return null;
        }
    }

    @GetMapping(value= VideoApiUrl.VIDEO_LIST)
    public ResponseEntity<ResultResponse> getList() {
        return videoApiService.getList();
    }
}
