package jodongari.wow.video.service;

import jodongari.wow.protocol.ResultResponse;
import jodongari.wow.video.dto.SavedFileInfo;
import jodongari.wow.video.dto.request.VideoDownloadRequest;
import jodongari.wow.video.dto.request.VideoUploadRequest;
import jodongari.wow.video.dto.response.VideoUploadResponse;
import jodongari.wow.video.exception.VideoErrorCode;
import jodongari.wow.video.exception.VideoException;
import jodongari.wow.video.repository.VideoRepository;
import jodongari.wow.video.repository.entity.VideoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VideoApiService {

    private final FileStoreService fileStoreService;
    private final VideoRepository videoRepository;

    public ResponseEntity<VideoUploadResponse> upload(VideoUploadRequest request) {

        try {
            final SavedFileInfo savedFileInfo = fileStoreService.saveOriginalFile(request.getVideo(), FileStoreService.TypeOfMedia.Videos);

            final VideoEntity entity = VideoEntity.builder()
                    .videoHash(request.getVideoName()) // need to hashing
                    .videoName(request.getVideoName())
                    .manifestPath(savedFileInfo.getManifestPath())
                    .description(request.getDescription())
                    .runningTime(savedFileInfo.getRunningTime())
                    .build();

            videoRepository.save(entity);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<VideoUploadResponse>(HttpStatus.OK);
    }

    public ResponseEntity<byte[]> download(VideoDownloadRequest request) {
        RandomAccessFile file = null;

        try {
            file = new RandomAccessFile(request.getManifestPath(), "r");

            byte[] result = new byte[(int)file.length()];
            file.readFully(result);

            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            return new ResponseEntity<>(result, headers, HttpStatus.OK);
        } catch (IOException e) {
            log.error("file download error: {}", request.getManifestPath(), e);
            throw new VideoException(VideoErrorCode.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<ResultResponse> getList() {

        List<VideoEntity> videoList = videoRepository.findAll();
        return new ResponseEntity<>(ResultResponse.builder()
                                                  .error(null)
                                                  .success(true)
                                                  .response(videoList)
                                                  .build(),
                                    HttpStatus.OK);
    }
}
