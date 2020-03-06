package com.qualle.trip.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryAspect.class);

    @Before("execution(public * com.qualle.trip.repository.AllowanceDao.*(..))")
    public void adviceAllowanceDao(JoinPoint point) {
        LOGGER.info("before - AllowanceDao." + point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.EmployeeDao.*(..))")
    public void adviceEmployeeDao(JoinPoint point) {
        LOGGER.info("before - EmployeeDao." + point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.MemberAllowanceDao.*(..))")
    public void adviceMemberAllowanceDao(JoinPoint point) {
        LOGGER.info("before - MemberAllowanceDao." + point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.MemberDao.*(..))")
    public void adviceMemberDao(JoinPoint point) {
        LOGGER.info("before - MemberDao." + point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.TicketDao.*(..))")
    public void adviceTicketDao(JoinPoint point) {
        LOGGER.info("before - TicketDao." + point.getSignature().getName());
    }

    @Before("execution(public * com.qualle.trip.repository.TripDao.*(..))")
    public void adviceTripDao(JoinPoint point) {
        LOGGER.info("before - TripDao." + point.getSignature().getName());
    }
}
