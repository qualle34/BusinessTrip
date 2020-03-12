package com.qualle.trip.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryAspect.class);

    @Before("execution(public * com.qualle.trip.controller.*.*(..))")
    public void adviceTripDao(JoinPoint point) {
        LOGGER.info("before - Controller " + point.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(*  com.qualle.trip.controller.*.*(..))", throwing = "ex")
    public void log(Exception ex) {
        LOGGER.warn("Controller exception - " + ex.getMessage(), ex);
    }
}
