package com.mhlab.codestyle.account;

import com.mhlab.codestyle.common.vo.JsonResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mhlab(dex) on 2019-09-02.
 */

@RestController
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    /**
     * 로그인 실패 또는 필요시 이동하는 임시 페이지
     * @return
     */
    @GetMapping("users/no_auth")
    public String getNeedLogin() {
        return "Login을 해주세요.";
    }

    /**
     * 로그인을 처리하는 메서드
     * @param dto
     * @return
     */
    @ResponseBody
    @PostMapping("users/login")
    public JsonResult<AccountDto.LoginResult> postLogin(HttpServletRequest request,  @RequestBody AccountDto.Login dto) {
        return accountService.userLogin(request.getSession(), dto);
    }



}
