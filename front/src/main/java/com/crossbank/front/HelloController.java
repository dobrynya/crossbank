package com.crossbank.front;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Provides greetings.
 * @uathor Dmitry Dobrynin
 * Created at 06.02.16 23:44.
 */

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}