package com.maktabsharif.springbootdemo.domain;

import com.maktabsharif.springbootdemo.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(
        value = {
                @NamedQuery(
                        name = "User.findAllByFirstNameCustom",
                        query = "select u from User u where u.firstName like concat('%', concat(:firstName, '%'))"
                )
        }
)
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "user_tbl";

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String username;

    private String password;


    public String getUsername() {
        return username;
    }
}
