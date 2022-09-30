package com.maktabsharif.springbootdemo;

import com.maktabsharif.springbootdemo.domain.User;
import com.maktabsharif.springbootdemo.service.UserService;
import com.maktabsharif.springbootdemo.service.dto.extra.UserSearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

        UserService userService = context.getBean(UserService.class);

        List<User> userList = userService.findAllByAdvanceSearch(
                new UserSearch(null, "es", "ro")
        );

        userList.forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName()));

    }

}
