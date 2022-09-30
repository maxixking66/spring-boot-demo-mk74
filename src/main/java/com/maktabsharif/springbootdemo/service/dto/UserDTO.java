package com.maktabsharif.springbootdemo.service.dto;

import com.maktabsharif.springbootdemo.base.service.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO<Long> {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Set<AddressDTO> addressSet;

}
