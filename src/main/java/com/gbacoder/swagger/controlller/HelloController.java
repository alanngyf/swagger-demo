package com.gbacoder.swagger.controlller;

import com.gbacoder.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alanulog
 * @create 2024-01-14
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/user")
    public User user() {
        return new User("Alan", "123123");
    }

    @ApiOperation("Hello Controller: Say Hello to user")
    @GetMapping("/hello2")
    public String hello2(String username) {
        return "Hello " + username;
    }
}
