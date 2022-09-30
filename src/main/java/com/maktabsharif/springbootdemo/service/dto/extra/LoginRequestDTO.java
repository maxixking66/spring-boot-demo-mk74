package com.maktabsharif.springbootdemo.service.dto.extra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
