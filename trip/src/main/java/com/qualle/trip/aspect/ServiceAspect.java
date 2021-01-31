package com.qualle.trip.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Slf4j
@Aspect
@Component
public class ServiceAspect {

    @Before("execution(public * com.qualle.trip.service.AllowanceService.*(..))")
    public void adviceAllowanceService(JoinPoint point) {
        log.info(MessageFormat.format("Service before - AllowanceService.{0}", point.getSignature().getName()));
    }

    @Before("execution(public * com.qualle.trip.service.EmployeeService.*(..))")
    public void adviceEmployeeService(JoinPoint point) {
        log.info(MessageFormat.format("Service before - EmployeeService.{0}", point.getSignature().getName()));
    }

    @Before("execution(public * com.qualle.trip.service.MemberService.*(..))")
    public void adviceMemberService(JoinPoint point) {
        log.info(MessageFormat.format("Service before - MemberService.{0}", point.getSignature().getName()));
    }

    @Before("execution(public * com.qualle.trip.service.TicketService.*(..))")
    public void adviceTicketService(JoinPoint point) {
        log.info(MessageFormat.format("Service before - TicketService.{0}", point.getSignature().getName()));
    }

    @Before("execution(public * com.qualle.trip.service.TripService.*(..))")
    public void adviceTripService(JoinPoint point) {
        log.info(MessageFormat.format("Service before - TripService.{0}", point.getSignature().getName()));
    }

    @AfterThrowing(pointcut = "execution(*  com.qualle.trip.service.*.*(..))", throwing = "ex")
    public void adviceService(Exception ex) {
        log.warn(MessageFormat.format("Service exception - {0}", ex.getMessage()), ex);
    }
}
