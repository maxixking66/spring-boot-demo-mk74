package com.maktabsharif.springbootdemo.service.dto;

import com.maktabsharif.springbootdemo.base.service.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserBriefDTO extends BaseDTO<Long> {

    private String firstName;

    private String lastName;

    public UserBriefDTO(Long id, String firstName, String lastName) {
        setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
