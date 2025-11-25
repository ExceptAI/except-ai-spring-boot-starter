package ai.except.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(ExceptAIProperties.class)
@ConditionalOnProperty(prefix = "except-ai", name = "enabled", havingValue = "true", matchIfMissing = true)
public class ExceptAIAutoConfiguration {

    @Bean
    public ExceptAIClient exceptAIClient(ExceptAIProperties properties) {
        log.info("✅ ExceptAI starter enabled. Endpoint: {}", properties.getEndpoint());
        return new ExceptAIClient(properties);
    }

    @Bean
    public ExceptAIExceptionHandler exceptAIExceptionHandler(ExceptAIClient client) {
        return new ExceptAIExceptionHandler(client);
    }

    @Bean
    public ExceptAIScheduledTaskAspect exceptAIScheduledTaskAspect(ExceptAIClient client) {
        log.info("✅ ExceptAI @Scheduled error monitoring enabled");
        return new ExceptAIScheduledTaskAspect(client);
    }
}