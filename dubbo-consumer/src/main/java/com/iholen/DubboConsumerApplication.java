package com.iholen;

import com.iholen.service.GreetingService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author huliang
 * @date 2019-07-23 14:23
 */
@EnableAutoConfiguration
public class DubboConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private GreetingService greetingService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(greetingService.say("123"));
    }
}
