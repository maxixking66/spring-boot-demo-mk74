package com.maktabsharif.springbootdemo.service.dto.extra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO implements Serializable {

    private String username;

    private Boolean isSuccessFUll;
}
