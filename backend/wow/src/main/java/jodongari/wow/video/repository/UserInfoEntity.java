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
@Table(name = "USER_INFO")
@NoArgsConstructor
public class UserInfoEntity extends BaseDateTime {

    @Id
    @Column(name="USER_HASH", nullable = false)
    @Size(max = 32)
    private String userHash;

    @Column(name="USER_EMAIL", nullable = false)
    @Size(max = 50)
    private String userEmail;

    @Column(name="USER_PWD", nullable = false)
    @Size(max = 32)
    private String userPassword;

    @Column(name="USER_NM", nullable = false)
    @Size(max = 100)
    private String userName;

    @Column(name="USER_NICK_NM", nullable = false)
    @Size(max = 100)
    private String userNickName;

    @Column(name="DEL_YN",
            columnDefinition = "boolean default false")
    private Boolean deleteYn;

    @Column(name="PROFILE_IMG_PATH")
    @Size(max = 300)
    private String profileImagePath;

    @Builder
    public UserInfoEntity(String userHash, String userEmail, String userPassword, String userName, String userNickName, Boolean deleteYn, String profileImagePath) {
        this.userHash = userHash;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickName = userNickName;
        this.deleteYn = deleteYn;
        this.profileImagePath = profileImagePath;
    }
}
