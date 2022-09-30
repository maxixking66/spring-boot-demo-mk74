package com.maktabsharif.springbootdemo.base.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class BaseDTO<ID extends Serializable> implements Serializable {

    private ID id;

}
