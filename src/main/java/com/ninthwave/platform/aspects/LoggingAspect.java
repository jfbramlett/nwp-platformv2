package com.ninthwave.platform.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(LogExecution)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        long timer = System.currentTimeMillis();
        logger.debug("starting method: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();

        long execMillis = System.currentTimeMillis() - timer;
        logger.debug("completed method: " + joinPoint.getSignature().getName() + " in " + execMillis + "ms");
        return result;
    }
}
