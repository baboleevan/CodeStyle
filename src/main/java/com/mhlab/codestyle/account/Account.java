package com.mhlab.codestyle.account;

import com.mhlab.codestyle.account.enums.Status;
import com.mhlab.codestyle.account.enums.Type;
import com.mhlab.codestyle.common.models.DateTime;
import com.mhlab.codestyle.common.utils.Utils;
import lombok.*;

import javax.persistence.*;

/**
 * 사용자 계정 Entity
 * Created by mhlab(dex) on 2019-09-02.
 */

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"idx"})
@ToString
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", updatable = false)
    private Long idx;

    @Column(name = "id", nullable = false, unique = true)
    private String id; //사용자 ID

    @Column(name = "pw", nullable = false, length = 250)
    private String password; //사용자 암호

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "user_type", nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private Type userType; //계정 타입

    @Column(name = "status", nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private Status status; //계정 상태

    @Embedded
    private DateTime dateTime = new DateTime();


    @Builder
    public Account(String id, String password, String email, Type userType, Status status) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.status = status;
    }


    /**
     * 암호 검증 메서드
     * @param checkPw
     * @return
     */
    boolean validPw(String checkPw) {
        return Utils.validEncryptStr(checkPw, this.password);
    }

    /**
     * 슈퍼 유저인지 체크하는 메서드
     * @return
     */
    boolean isSuperUser() {
        return this.userType.isSuperUser();
    }

    /**
     * 일반 사용자인지 체크하는 메서드
     * @return
     */
    boolean isNormalUser() {
        return this.userType.isNormalUser();
    }

    /**
     * 기타 사용자인지 체크하는 메서드
     * @return
     */
    boolean isEtcUser() {
        return this.userType.isEtcUser();
    }

}
