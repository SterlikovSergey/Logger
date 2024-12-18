package ru.clevertec.logger.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.clevertec.logger.config.LoggerMonitorProperties;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggerMonitorAspect {

    private final Logger logger = Logger.getLogger(LoggerMonitorAspect.class.getName());
    private final LoggerMonitorProperties properties;

    public LoggerMonitorAspect(LoggerMonitorProperties properties) {
        this.properties = properties;
    }

    @Around("@annotation(ru.clevertec.logger.annotation.MonitorLogger)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!properties.isEnabled()) {
            return joinPoint.proceed();
        }

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        String methodName = joinPoint.getSignature().toShortString();
        logger.info(String.format("Method [%s] executed in [%d] ms", methodName, executionTime));

        return result;
    }
}