package com.maktabsharif.springbootdemo.repository;

import com.maktabsharif.springbootdemo.base.repository.BaseEntityRepository;
import com.maktabsharif.springbootdemo.domain.Tag;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends BaseEntityRepository<Tag, Long> {

}
