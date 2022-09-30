package com.maktabsharif.springbootdemo.service.impl;

import com.maktabsharif.springbootdemo.base.service.impl.BaseEntityServiceImpl;
import com.maktabsharif.springbootdemo.domain.Tag;
import com.maktabsharif.springbootdemo.repository.TagRepository;
import com.maktabsharif.springbootdemo.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TagServiceImpl extends BaseEntityServiceImpl<Tag, Long, TagRepository>
        implements TagService {

    public TagServiceImpl(TagRepository repository) {
        super(repository);
    }

}