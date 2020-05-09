package com.ninthwave.samplefi.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspect that is invoked any time the annotation @LogExection is defined.
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * Logs our execution info
     *
     * @param joinPoint The joinpoint details
     * @return Object The result of the underlying requests
     * @throws Throwable
     */
    @Around("@annotation(LogExecution)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        long timer = System.currentTimeMillis();
        logger.info("starting method: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();

        long execMillis = System.currentTimeMillis() - timer;
        logger.info("completed method: " + joinPoint.getSignature().getName() + " in " + execMillis + "ms");
        return result;
    }
}
