package com.maktabsharif.springbootdemo.base.resource;

import com.maktabsharif.springbootdemo.base.domain.BaseEntity;
import com.maktabsharif.springbootdemo.base.mapper.BaseMapper;
import com.maktabsharif.springbootdemo.base.service.BaseEntityService;
import com.maktabsharif.springbootdemo.base.service.dto.BaseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RequiredArgsConstructor
public class BaseResource<E extends BaseEntity<ID>,
        D extends BaseDTO<ID>,
        ID extends Serializable,
        S extends BaseEntityService<E, ID>,
        M extends BaseMapper<E, D, ID>> {

    protected final S baseService;

    protected final M baseMapper;

    @GetMapping
    public D getById(@RequestParam ID id) {
        E e = baseService.findById(id).get();
        return baseMapper.convertEntityToDTO(e);
    }

    @PostMapping
    public D save(@RequestBody D d) {
        E e = baseService.save(
                baseMapper.convertDTOToEntity(d)
        );
        return baseMapper.convertEntityToDTO(e);
    }

    @PutMapping
    public D update(@RequestBody D d) {
        E e = baseService.save(
                baseMapper.convertDTOToEntity(d)
        );
        return baseMapper.convertEntityToDTO(e);
    }

    @GetMapping("/pageable")
    public Page<D> getPage(Pageable pageable) {
        Page<E> page = baseService.findAll(pageable);
        return page.map(baseMapper::convertEntityToDTO);
    }
}
