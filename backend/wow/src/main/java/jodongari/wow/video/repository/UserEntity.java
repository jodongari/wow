package jodongari.wow.video.repository;

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
@Table(name = "USER")
@NoArgsConstructor
public class UserEntity extends BaseDateTime {

    @Id
    @Column(name="USER_HASH", nullable = false)
    @Size(max = 32)
    private String userHash;

    @Column(name="USER_EMAIL", nullable = false)
    @Size(max = 50)
    private String userEmail;

    @Column(name="USER_PWD", nullable = false)
    @Size(max = 32)
    private String userPwd;

    @Column(name="USER_NM", nullable = false)
    @Size(max = 100)
    private String userNm;

    @Column(name="USER_NICK_NM", nullable = false)
    @Size(max = 100)
    private String userNickNm;

    @Column(name="DEL_YN",
            columnDefinition = "boolean default false")
    private Boolean delYn;

    @Column(name="PROFILE_IMG_PATH")
    @Size(max = 300)
    private String profileImgPath;

    @Builder
    public UserEntity(String userHash, String userEmail, String userPwd, String userNm, String userNickNm, Boolean delYn, String profileImgPath) {
        this.userHash = userHash;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
        this.userNm = userNm;
        this.userNickNm = userNickNm;
        this.delYn = delYn;
        this.profileImgPath = profileImgPath;
    }
}
