package ru.clevertec.logger.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.logger.aspect.LoggerMonitorAspect;

@Configuration
@ConditionalOnProperty(prefix = "logger.monitor", name = "enabled", havingValue = "true", matchIfMissing = true)
public class LoggerMonitorAutoConfiguration {

    @Bean
    public LoggerMonitorProperties loggerMonitorProperties() {
        return new LoggerMonitorProperties();
    }

    @Bean
    public LoggerMonitorAspect loggerMonitorAspect(LoggerMonitorProperties properties) {
        return new LoggerMonitorAspect(properties);
    }
}
