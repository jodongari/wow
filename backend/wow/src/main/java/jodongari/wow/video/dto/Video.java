package jodongari.wow.video.dto;

import lombok.Data;

import javax.validation.Valid;

@Data
@Valid
public class Video {

    private String videoHash;
    private String videoName;
    private String description;
    private Long runningTime;
}
