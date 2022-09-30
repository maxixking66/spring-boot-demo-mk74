package com.maktabsharif.springbootdemo.base.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity<ID extends Serializable> implements Serializable {

    @Id
    @GeneratedValue
    private ID id;

    private ZonedDateTime createDate;
}
