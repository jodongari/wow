package jodongari.wow.video.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class VideoDownloadRequest {

    @NotBlank
    String manifestPath;
}
