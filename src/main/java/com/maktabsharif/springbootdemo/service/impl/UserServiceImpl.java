package com.maktabsharif.springbootdemo.service.impl;

import com.maktabsharif.springbootdemo.base.service.impl.BaseEntityServiceImpl;
import com.maktabsharif.springbootdemo.domain.User;
import com.maktabsharif.springbootdemo.repository.UserRepository;
import com.maktabsharif.springbootdemo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseEntityServiceImpl<User, Long, UserRepository>
        implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User getByUsername(String username) {
        return repository.getByUsername(username);
    }

    @Override
    public Page<User> findAllByLastNameContaining(String lastName, Pageable pageable) {
        return repository.findAllByLastNameContaining(lastName, pageable);
    }
}
