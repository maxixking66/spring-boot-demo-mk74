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
public class TagDTO extends BaseDTO<Long> {


    private String title;

}
