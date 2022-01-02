package jodongari.wow.video.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SavedFileInfo {
    String manifestPath;
    Long runningTime;

    @Builder
    public SavedFileInfo(String manifestPath, Long runningTime){
        this.manifestPath = manifestPath;
        this.runningTime = runningTime;
    }

}
