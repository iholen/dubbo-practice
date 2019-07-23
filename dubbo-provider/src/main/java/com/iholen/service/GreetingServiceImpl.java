package com.iholen.service;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author huliang
 * @date 2019-07-23 13:49
 */
@Service(version = "1.0.0")
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String say(String message) {
        return "dubbo.provider say:" + message;
    }

}
