package com.mhlab.codestyle.board;

import com.mhlab.codestyle.account.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 임시 게시판 컨트롤러
 *
 * Created by mhlab(dex) on 2019-09-02.
 */

@RestController
public class BoardController {


    @GetMapping("board/main")
    public String getBoard(HttpServletRequest request) {
        Account targetAccount = (Account)request.getSession().getAttribute("Account");
        return "[" + targetAccount.getId() + "] 사용자로 로그인 하였습니다. \n 로그인 사용자 정보 : " + targetAccount.toString();
    }
}
