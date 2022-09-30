package com.maktabsharif.springbootdemo.service.impl;

import com.maktabsharif.springbootdemo.base.service.impl.BaseEntityServiceImpl;
import com.maktabsharif.springbootdemo.domain.User;
import com.maktabsharif.springbootdemo.repository.UserRepository;
import com.maktabsharif.springbootdemo.service.UserService;
import com.maktabsharif.springbootdemo.service.dto.extra.UserSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> findAllByAdvanceSearch(UserSearch userSearch) {
        return repository.findAll(
                (root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    setFirstNameInPredicate(predicates, root, criteriaBuilder, userSearch.getFirstName());
                    setLastNameInPredicate(predicates, root, criteriaBuilder, userSearch.getLastName());
                    setUsernameInPredicate(predicates, root, criteriaBuilder, userSearch.getUsername());
                    return criteriaBuilder.and(
                            predicates.toArray(new Predicate[0])
                    );
                }
        );
    }

    private void setFirstNameInPredicate(List<Predicate> predicates, Root<User> root,
                                         CriteriaBuilder criteriaBuilder, String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("firstName"),
                            "%" + firstName + "%"
                    )
            );
        }
    }

    private void setLastNameInPredicate(List<Predicate> predicates, Root<User> root,
                                        CriteriaBuilder criteriaBuilder, String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("lastName"),
                            "%" + lastName + "%"
                    )
            );
        }
    }

    private void setUsernameInPredicate(List<Predicate> predicates, Root<User> root,
                                        CriteriaBuilder criteriaBuilder, String username) {
        if (username != null && !username.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("username"),
                            "%" + username + "%"
                    )
            );
        }
    }
}