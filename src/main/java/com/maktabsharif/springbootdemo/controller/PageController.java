package com.maktabsharif.springbootdemo.controller;

import com.maktabsharif.springbootdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PageController {

    private final UserService userService;

/*    @GetMapping
    public ModelAndView getHomePage() {
//        User user = userService.findByUsernameCustom("mat");
//        System.out.println(user.getFirstName());

        System.out.println(userService.getByUsername("mat").getLastName());
//        System.out.println(userService.findByUsername("mat").getPassword());

//        List<User> userList = userService.findAllByFirstNameCustom("m");
//        System.out.println(userList.size());

//         userList = userService.findAllByFirstNameContaining("m");
//        System.out.println(userList.size());

//        userList = userService.findAllByFirstNameStartingWith("mo");
//        System.out.println(userList.size());
        return new ModelAndView("home");
    }*/

    @GetMapping
    public String getHome() {
        return "home";
    }

    @GetMapping("/test")
    @ResponseBody
    public String getTest() {
        return "home";
    }

}
