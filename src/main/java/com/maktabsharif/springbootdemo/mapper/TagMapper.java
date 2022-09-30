package com.maktabsharif.springbootdemo.mapper;

import com.maktabsharif.springbootdemo.base.mapper.BaseMapper;
import com.maktabsharif.springbootdemo.domain.Tag;
import com.maktabsharif.springbootdemo.service.dto.TagDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TagMapper extends BaseMapper<Tag, TagDTO, Long> {
}
