package com.maktabsharif.springbootdemo.resource;

import com.maktabsharif.springbootdemo.domain.User;
import com.maktabsharif.springbootdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    //    /user?id=5
    @GetMapping
    public User getById(@RequestParam(name = "id") Long id) {
        return userService.findById(id).get();
    }

    @GetMapping("/{id}")
    public User getByIdByPath(@PathVariable Long id) {
        return userService.findById(id).get();
    }
}
