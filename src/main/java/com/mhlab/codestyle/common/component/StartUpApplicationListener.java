package com.mhlab.codestyle.common.component;

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
public class StartUpApplicationListener {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(event.getTimestamp()), TimeZone.getDefault().toZoneId());
        String startMsg = "\n\n===== Application Start =====\n"
                + "=====   SERVER  START   =====\n"
                + "[Up-Time] : " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) + "\n";
        log.info(startMsg);
    }

    @EventListener
    public void shutdownApplicationEvent(ContextClosedEvent event) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(event.getTimestamp()), TimeZone.getDefault().toZoneId());
        String endMsg = "\n\n===== Application Stop =====\n"
                + "=====   SERVER  DOWN   =====\n"
                + "[Down-Time] : " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) + "\n";
        log.info(endMsg);
    }

}
