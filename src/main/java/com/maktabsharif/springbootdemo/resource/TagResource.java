package com.maktabsharif.springbootdemo.resource;

import com.maktabsharif.springbootdemo.base.resource.BaseResource;
import com.maktabsharif.springbootdemo.domain.Tag;
import com.maktabsharif.springbootdemo.mapper.TagMapper;
import com.maktabsharif.springbootdemo.service.TagService;
import com.maktabsharif.springbootdemo.service.dto.TagDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagResource extends BaseResource<Tag, TagDTO, Long, TagService, TagMapper> {

    public TagResource(TagService baseService, TagMapper baseMapper) {
        super(baseService, baseMapper);
    }

}
