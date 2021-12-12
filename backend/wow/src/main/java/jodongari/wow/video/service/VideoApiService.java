package jodongari.wow.video.service;

import jodongari.wow.video.dto.request.VideoUploadRequest;
import jodongari.wow.video.dto.response.VideoUploadResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VideoApiService {

    public ResponseEntity<VideoUploadResponse> upload(VideoUploadRequest request) {
        return new ResponseEntity<VideoUploadResponse>(HttpStatus.OK);
    }
}
