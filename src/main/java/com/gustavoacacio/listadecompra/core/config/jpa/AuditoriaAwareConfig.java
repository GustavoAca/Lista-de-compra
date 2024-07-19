package com.gustavoacacio.listadecompra.core.config.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditoriaAwareConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditoriaAwareImpl();
    }
}
