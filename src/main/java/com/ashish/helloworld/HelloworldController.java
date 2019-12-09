package com.ashish.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: ashishkumarashok
 * Date: 11/21/19
 * Time: 1:50 PM
 * To change this template use File | Settings | File and Code Templates.
 */
@RestController
@RequestMapping("/helloworld")
public class HelloworldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloworldController.class);

    @Value("${greeting.message}")
    private String greetingMessage;

    @GetMapping
    public String printHelloWorld() {
        LOGGER.info("Calling helloworld endpoint");
        return "Hello World";
    }

    @GetMapping("/greeting")
    public String getGreetingMessage() {
        LOGGER.info("Calling greeting endpoint");
        return greetingMessage;
    }

    @GetMapping("/envgreeting")
    public String getEnvGreetingMessage() {
        String greeting = System.getenv().getOrDefault("GREETING_MSG","Default greeting message");
        LOGGER.info("Calling env greeting endpoint. The message is: {}", greeting);
        return greeting;
    }
}
