package com.maktabsharif.springbootdemo.service;

import com.maktabsharif.springbootdemo.base.service.BaseEntityService;
import com.maktabsharif.springbootdemo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends BaseEntityService<User, Long> {

    User getByUsername(String username);

    Page<User> findAllByLastNameContaining(String lastName, Pageable pageable);

}
