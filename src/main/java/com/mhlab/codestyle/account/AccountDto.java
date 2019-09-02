package com.mhlab.codestyle.account;

import com.mhlab.codestyle.account.enums.Status;
import com.mhlab.codestyle.account.enums.Type;
import com.mhlab.codestyle.common.utils.Utils;
import lombok.*;

/**
 * Created by mhlab(dex) on 2019-09-02.
 */

public class AccountDto {

    /////////////////////////
    //     Create User
    /////////////////////////

    @ToString
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateAccount {
        private String id; //사용자 ID
        private String password; //사용자 암호
        private String email;
        private Type userType; //계정 타입
        private Status status; //계정 상태

        @Builder
        public CreateAccount(String id, String password, String email, Type userType, Status status) {
            this.id = id;
            this.password = Utils.encryptStr(password); //암호화를 진행해준다.
            this.email = email;
            this.userType = userType;
            this.status = status;
        }

        Account toEntity() {
            return Account.builder()
                    .id(this.id)
                    .password(this.password)
                    .email(this.email)
                    .userType(this.userType)
                    .status(this.status)
                    .build();
        }
    }



    /////////////////////////
    //      로그인 Dto
    /////////////////////////

    @ToString
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Login {
        private String id; //사용자 ID
        private String password; //사용자 암호

        @Builder
        public Login(String id, String password) {
            this.id = id;
            this.password = password;
        }
    }


    /////////////////////////
    //    로그인 성공 Dto
    /////////////////////////
    @ToString
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LoginResult {
        private boolean isLogin; //로그인 성공 여부
        private String id; //로그인 시도 계정 ID
        private String msg; //처리 결과 메세지

        @Builder
        public LoginResult(boolean isLogin, String id, String msg) {
            this.isLogin = isLogin;
            this.id = id;
            this.msg = msg;
        }
    }

}
