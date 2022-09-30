package com.maktabsharif.springbootdemo.repository;

import com.maktabsharif.springbootdemo.base.repository.BaseEntityRepository;
import com.maktabsharif.springbootdemo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseEntityRepository<User, Long> {

    @Query("select u from User u where u.username = :username")
    User findByUsernameCustom(@Param("username") String username);

    //    @Query("from User u where u.firstName like concat('%', concat(:firstName, '%'))")
    List<User> findAllByFirstNameCustom(@Param("firstName") String firstName);

    User findByUsername(String username);

    User getByUsername(String username);

    List<User> findAllByFirstNameContaining(String firstName);

    List<User> findAllByFirstNameStartingWith(String firstName);

    Page<User> findAllByLastNameContaining(String lastName, Pageable pageable);

    <P> P findByUsername(String username, Class<P> pClass);

    <P> P findById(String username, Class<P> pClass);

    <P> Page<P> findAllByIdIsNotNull(Class<P> pClass, Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {"addressSet"})
    List<User> findAll();
}
