package com.maktabsharif.springbootdemo;

import com.github.javafaker.Faker;
import com.maktabsharif.springbootdemo.domain.User;
import com.maktabsharif.springbootdemo.repository.UserRepository;
import com.maktabsharif.springbootdemo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class SpringBootDemoApplication {

    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        UserService userService = context.getBean(UserService.class);

        Pageable pageable = PageRequest.of(0, 10);
        Page<User> page =
//                userService.findAllByLastNameContaining("ch", pageable);
                userService.findAll(pageable);

        System.out.println("pageNumber: " + page.getNumber());
        System.out.println("pageSize: " + page.getSize());
        System.out.println("totalElement: " + page.getTotalElements());
        System.out.println("totalPage: " + page.getTotalPages());
        System.out.println("hasNext: " + page.hasNext());
        System.out.println("isLast: " + page.isLast());
        page.getContent().forEach(user -> System.out.println(user.getFirstName() + "-" + user.getLastName()));

        UserRepository repository = context.getBean(UserRepository.class);

        /*IdProjection idProjection = repository.findByUsername("mat", IdProjection.class);
        System.out.println("id mat = " + idProjection.getId());

        Page<FirstLastNameProjection> page = repository.findAllByIdIsNotNull(
                FirstLastNameProjection.class, PageRequest.of(2, 10)
        );
        System.out.println("pageNumber: " + page.getNumber());
        System.out.println("pageSize: " + page.getSize());
        System.out.println("totalElement: " + page.getTotalElements());
        System.out.println("totalPage: " + page.getTotalPages());
        System.out.println("hasNext: " + page.hasNext());
        System.out.println("isLast: " + page.isLast());
        page.getContent().forEach(user -> System.out.println(user.getFirstName() + " - " + user.getLastName()));*/
    }

}
