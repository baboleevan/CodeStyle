package com.mhlab.codestyle.common.component;

import com.mhlab.codestyle.account.AccountDto;
import com.mhlab.codestyle.account.AccountService;
import com.mhlab.codestyle.account.enums.Status;
import com.mhlab.codestyle.account.enums.Type;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

/**
 * Server Up/Down Listener
 * Created by mhlab(dex) on 2019-09-02.
 */

@Slf4j
@Component
@AllArgsConstructor
public class StartUpApplicationListener {

    private AccountService accountService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(event.getTimestamp()), TimeZone.getDefault().toZoneId());
        String startMsg = "\n\n===== Application Start =====\n"
                + "=====   SERVER  START   =====\n"
                + "[Up-Time] : " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) + "\n";
        log.info(startMsg);

        //임시로 더미 데이터를 만들어 주는 메서드
        checkDummyData();
    }

    @EventListener
    public void shutdownApplicationEvent(ContextClosedEvent event) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(event.getTimestamp()), TimeZone.getDefault().toZoneId());
        String endMsg = "\n\n===== Application Stop =====\n"
                + "=====   SERVER  DOWN   =====\n"
                + "[Down-Time] : " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) + "\n";
        log.info(endMsg);
    }


    /**
     * 임시로 더미 데이터를 생성해주는 메서드
     */
    private void checkDummyData() {
        if (accountService.countByAllUser() <= 0) {

            //Dummy 계정을 생성해준다.
            accountService.createAccountData(AccountDto.CreateAccount.builder()
                    .id("admin")
                    .password("admin")
                    .email("test@test.com")
                    .userType(Type.ADMIN)
                    .status(Status.ACTIVE)
                    .build());

            accountService.createAccountData(AccountDto.CreateAccount.builder()
                    .id("user1")
                    .password("user")
                    .email("user1@test.com")
                    .userType(Type.USER)
                    .status(Status.ACTIVE)
                    .build());

            accountService.createAccountData(AccountDto.CreateAccount.builder()
                    .id("user2")
                    .password("user")
                    .email("user2@test.com")
                    .userType(Type.USER)
                    .status(Status.WAIT)
                    .build());

            accountService.createAccountData(AccountDto.CreateAccount.builder()
                    .id("guest")
                    .password("guest")
                    .email("guest@test.com")
                    .userType(Type.GUEST)
                    .status(Status.WAIT)
                    .build());
        }
    }

}
