package com.mhlab.codestyle.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by MHLab on 2019/10/25..
 */

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    /**
     * 특정 메서드 호출 시간을 체크할 때 사용하는 메서드(어노테이션 기반)
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.mhlab.codestyle.common.annotations.PerformanceLog)")
    public Object performanceCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("["+joinPoint.getSignature().getName()+"]");

        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return proceed;
    }
}
