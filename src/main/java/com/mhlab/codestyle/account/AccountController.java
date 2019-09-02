package com.mhlab.codestyle.account;

import com.mhlab.codestyle.common.vo.JsonResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by mhlab(dex) on 2019-09-02.
 */

@Controller
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;


    @PostMapping("login")
    public JsonResult<AccountDto.LoginResult> postLogin(@RequestBody AccountDto.Login dto) {

        return null;
    }

    //로그인 Post

}
