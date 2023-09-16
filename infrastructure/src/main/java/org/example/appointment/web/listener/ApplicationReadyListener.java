package org.example.appointment.web.listener;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class ApplicationReadyListener implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger;

    public ApplicationReadyListener(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext.getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> logger.info("Endpoint: {} {}", key, value));
    }
}
