package com.maktabsharif.springbootdemo.resource;

import com.maktabsharif.springbootdemo.domain.User;
import com.maktabsharif.springbootdemo.service.UserService;
import com.maktabsharif.springbootdemo.service.dto.extra.UserSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/search")
    public List<User> search(@RequestBody UserSearch userSearch) {
        return userService.findAllByAdvanceSearch(userSearch);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

}
