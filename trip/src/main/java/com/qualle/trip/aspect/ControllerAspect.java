package com.qualle.trip.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerAspect {

    @Before("execution(public * com.qualle.trip.controller.*.*(..))")
    public void adviceTripDao(JoinPoint point) {
        log.info("Controller before - {}", point.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(*  com.qualle.trip.controller.*.*(..))", throwing = "ex")
    public void log(Exception ex) {
        log.warn("Controller exception - {}", ex.getMessage(), ex);
    }
}
