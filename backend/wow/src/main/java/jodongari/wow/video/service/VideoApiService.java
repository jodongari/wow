package jodongari.wow.video.service;

import jodongari.wow.video.dto.request.VideoUploadRequest;
import jodongari.wow.video.dto.response.VideoUploadResponse;
import jodongari.wow.video.repository.VideoRepository;
import jodongari.wow.video.repository.entity.VideoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class VideoApiService {

    private final FileStoreService fileStoreService;
    private final VideoRepository videoRepository;

    public ResponseEntity<VideoUploadResponse> upload(VideoUploadRequest request) {

        try {
            final String manifestPath = fileStoreService.saveOriginalFile(request.getVideo(), FileStoreService.TypeOfMedia.Videos);

            final VideoEntity entity = VideoEntity.builder()
                    .videoHash(request.getVideoName()) // need to hashing
                    .videoName(request.getVideoName())
                    .manifestPath(manifestPath)
                    .description(request.getDescription())
                    .runningTime(1L)
                    .build();

            videoRepository.save(entity);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<VideoUploadResponse>(HttpStatus.OK);
    }
}
