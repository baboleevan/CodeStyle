package com.mhlab.codestyle.account;

import com.mhlab.codestyle.common.vo.JsonResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static com.mhlab.codestyle.common.enums.JsonSuccess.*;
import static com.mhlab.codestyle.common.enums.JsonFail.*;

/**
 * Created by mhlab(dex) on 2019-09-02.
 */

@Slf4j
@Service
@AllArgsConstructor
public class AccountService extends AccountRepoService {


    /**
     * 사용자 로그인을 처리하는 메서드
     * @param session
     * @param dto
     * @return
     */
    JsonResult<AccountDto.LoginResult> userLogin(HttpSession session, AccountDto.Login dto) {
        if (isExistId(dto.getId())) { //
            Account targetAccount = getDataById(dto.getId());
            //로그인 대상 계정의 암호를 체크하여 성공 시 반환
            if (targetAccount.validPw(dto.getPassword())) {
                //세션에 정보를 등록해준다.
                session.setAttribute("Account", targetAccount);

                return JsonResult.<AccountDto.LoginResult>builder()
                        .code(LOGIN_SUCCESS.code())
                        .msg(LOGIN_SUCCESS.msg())
                        .data(AccountDto.LoginResult.builder()
                                .id(dto.getId())
                                .isLogin(true)
                                .msg("Login success.")
                                .build())
                        .build();
            }
        }

        //로그인 실패 응답 처리
        return JsonResult.<AccountDto.LoginResult>builder()
                .code(LOGIN_FAIL.code())
                .msg(LOGIN_FAIL.msg())
                .data(AccountDto.LoginResult.builder()
                        .id(dto.getId())
                        .isLogin(false)
                        .msg("Wrong user info.")
                        .build())
                .build();
    }

    /**
     * 사용자 계정을 생성하는 메서드
     * @param dto
     */
    public void createAccountData(AccountDto.CreateAccount dto) {
        saveData(dto.toEntity());
    }


}
