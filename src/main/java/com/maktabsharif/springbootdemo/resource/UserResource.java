package com.maktabsharif.springbootdemo.resource;

import com.maktabsharif.springbootdemo.domain.User;
import com.maktabsharif.springbootdemo.mapper.UserMapper;
import com.maktabsharif.springbootdemo.service.UserService;
import com.maktabsharif.springbootdemo.service.dto.UserBriefDTO;
import com.maktabsharif.springbootdemo.service.dto.extra.UserCreateDTO;
import com.maktabsharif.springbootdemo.service.dto.extra.UserSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    private final UserMapper userMapper;

    //    /user?id=5
    @GetMapping
    public User getById(@RequestParam(name = "id") Long id) {
        return userService.findById(id).get();
    }

    @GetMapping("/{id}")
    public UserBriefDTO getByIdByPath(@PathVariable Long id) {
        /*User user = userService.findById(id).get();
        UserBriefDTO userBriefDTO = new UserBriefDTO();
        BeanUtils.copyProperties(user, userBriefDTO);
        return userBriefDTO;*/
//        return new UserBriefDTO(user.getId(), user.getFirstName(), user.getLastName());
        User user = userService.findById(id).get();
        return userMapper.convertUserToBriefDTO(user);
    }

    @PostMapping("/search")
    public List<User> search(@RequestBody UserSearch userSearch) {
        return userService.findAllByAdvanceSearch(userSearch);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/create")
    public User save(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        return userService.save(
                userMapper.convertUserCreateDTOToUser(userCreateDTO)
        );
    }

}
