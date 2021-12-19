package jodongari.wow.video.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Data
@Valid
public class VideoUploadRequest {

    String videoName;

    String description;

    MultipartFile video;
}
