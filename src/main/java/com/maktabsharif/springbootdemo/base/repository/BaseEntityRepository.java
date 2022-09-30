package com.maktabsharif.springbootdemo.base.repository;

import com.maktabsharif.springbootdemo.base.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseEntityRepository<E extends BaseEntity<ID>, ID extends Serializable>
        extends JpaRepository<E, ID> {
}
