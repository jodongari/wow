package jodongari.wow.video.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class VideoUploadRequest {
    @NotBlank
    String videoName;
    @NotBlank
    String description;
    @NotNull
    MultipartFile video;
}
