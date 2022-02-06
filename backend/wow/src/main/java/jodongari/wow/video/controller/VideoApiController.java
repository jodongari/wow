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

    @GetMapping(value = VideoApiUrl.VIDEO_MANIFEST + "/{videoHash}")
    @ResponseBody
    public ResponseEntity<byte[]> getManifestFile(@PathVariable String videoHash) {
        try{
            return videoApiService.getManifestFile(videoHash);
        } catch (Exception e){
            return null;
        }
    }

    @GetMapping(value = VideoApiUrl.VIDEO_DOWNLOAD + "/{m4sFile}")
    @ResponseBody
    public ResponseEntity<byte[]> download(@PathVariable String m4sFile) {
        try{
            return videoApiService.download(m4sFile);
        } catch (Exception e){
            return null;
        }
    }

    @GetMapping(value= VideoApiUrl.VIDEO_LIST)
    public ResponseEntity<ResultResponse> getList() {
        return videoApiService.getList();
    }
}
