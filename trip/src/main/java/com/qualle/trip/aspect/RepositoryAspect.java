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
public class RepositoryAspect {

    @Before("execution(public * com.qualle.trip.repository.AllowanceDao.*(..))")
    public void adviceAllowanceDao(JoinPoint point) {
        log.info("Repository before - AllowanceDao.{}", point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.EmployeeDao.*(..))")
    public void adviceEmployeeDao(JoinPoint point) {
        log.info("Repository before - EmployeeDao.{}", point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.MemberAllowanceDao.*(..))")
    public void adviceMemberAllowanceDao(JoinPoint point) {
        log.info("Repository before - MemberAllowanceDao.{}", point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.MemberDao.*(..))")
    public void adviceMemberDao(JoinPoint point) {
        log.info("Repository before - MemberDao.{}", point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.TicketDao.*(..))")
    public void adviceTicketDao(JoinPoint point) {
        log.info("Repository before - TicketDao.{}", point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.TripDao.*(..))")
    public void adviceTripDao(JoinPoint point) {
        log.info("Repository before - TripDao.{}", point.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(*  com.qualle.trip.repository.*.*(..))", throwing = "ex")
    public void log(Exception ex) {
        log.warn("Repository exception - {}", ex.getMessage(), ex);
    }
}
