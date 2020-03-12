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
public class ServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);

    @Before("execution(public * com.qualle.trip.service.AllowanceService.*(..))")
    public void adviceAllowanceService(JoinPoint point) {
        LOGGER.info("before - AllowanceService." + point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.service.EmployeeService.*(..))")
    public void adviceEmployeeService(JoinPoint point) {
        LOGGER.info("before - EmployeeService." + point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.service.MemberService.*(..))")
    public void adviceMemberService(JoinPoint point) {
        LOGGER.info("before - MemberService." + point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.service.TicketService.*(..))")
    public void adviceTicketService(JoinPoint point) {
        LOGGER.info("before - TicketService." + point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.service.TripService.*(..))")
    public void adviceTripService(JoinPoint point) {
        LOGGER.info("before - TripService." + point.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(*  com.qualle.trip.service.*.*(..))", throwing = "ex")
    public void adviceService(Exception ex) {
        LOGGER.warn("Service exception - " + ex.getMessage(), ex);
    }
}
