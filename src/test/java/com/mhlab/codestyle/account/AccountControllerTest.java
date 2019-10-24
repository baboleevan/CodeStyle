package com.mhlab.codestyle.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mhlab.codestyle.common.annotations.TestDescription;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Account Controller Test
 * Created by MHLab on 2019/10/25..
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountControllerTest {
    //Logger
    private Logger logger = LoggerFactory.getLogger(AccountControllerTest.class);

    //ObjectMapper -> Json 변환 사용
    @Autowired private ObjectMapper objectMapper;

    @Autowired private WebApplicationContext context;

    private MockMvc mockMvc;


    /**
     * 테스트 전 작업 mockMvc 초기화 수행
     */
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }


    @Test
    @TestDescription("로그인 api 테스트 케이스")
    public void testLogin() throws Exception {
        //테스트 계정 정보
        AccountDto.Login loginDto = AccountDto.Login.builder()
                .id("Test")
                .password("1234")
                .build();

        String json = objectMapper.writeValueAsString(loginDto);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/no_auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
