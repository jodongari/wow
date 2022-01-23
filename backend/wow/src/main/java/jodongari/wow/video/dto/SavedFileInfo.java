package jodongari.wow.video.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SavedFileInfo {
    String videoHash;
    String manifestPath;
    Long runningTime;

    @Builder
    public SavedFileInfo(String videoHash, String manifestPath, Long runningTime){
        this.videoHash = videoHash;
        this.manifestPath = manifestPath;
        this.runningTime = runningTime;
    }

}
