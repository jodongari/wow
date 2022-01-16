package jodongari.wow.video.repository.entity;

import jodongari.wow.common.BaseDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Entity
@Table(name="VIDEO")
@NoArgsConstructor
public class VideoEntity extends BaseDateTime {

    @Id
    @Column(name="VIDEO_HASH", nullable = false)
    @Size(max = 32)
    private String videoHash;

    @Column(name="VIDEO_NM", nullable = false)
    @Size(max = 100)
    private String videoName;

    @Column(name="MANIFEST_PATH", nullable = false)
    @Size(max = 200)
    private String manifestPath;

    @Column(name = "VIDEO_DESCRIPTION")
    @Size(max = 500)
    private String description;

    @Column(name = "DEL_YN",
            columnDefinition = "boolean default false")
    private Boolean deleteYn;

    @Column(name = "VIDEO_LIKE_COUNT",
            columnDefinition = "int default 0")
    private Long likeCount;

    @Column(name = "VIDEO_DISLIKE_COUNT",
            columnDefinition = "int default 0")
    private Long dislikeCount;

    @Column(name = "VIDEO_RUNNING_TIME", nullable = false)
    private Long runningTime;

    @Builder
    public VideoEntity(String videoHash, String videoName, String manifestPath, String description, Boolean deleteYn, Long likeCount, Long dislikeCount, Long runningTime) {
        this.videoHash = videoHash;
        this.videoName = videoName;
        this.manifestPath = manifestPath;
        this.description = description;
        this.deleteYn = deleteYn;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.runningTime = runningTime;

    }
}
