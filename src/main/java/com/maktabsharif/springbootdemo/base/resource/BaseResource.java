package com.maktabsharif.springbootdemo.base.resource;

import com.maktabsharif.springbootdemo.base.domain.BaseEntity;
import com.maktabsharif.springbootdemo.base.mapper.BaseMapper;
import com.maktabsharif.springbootdemo.base.service.BaseEntityService;
import com.maktabsharif.springbootdemo.base.service.dto.BaseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseResource<E extends BaseEntity<ID>,
        D extends BaseDTO<ID>,
        ID extends Serializable,
        S extends BaseEntityService<E, ID>,
        M extends BaseMapper<E, D, ID>> {

    protected final S baseService;

    protected final M baseMapper;

    @GetMapping
    public ResponseEntity<D> getById(@RequestParam ID id) {
        Optional<E> optional = baseService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(
                    baseMapper.convertEntityToDTO(
                            optional.get()
                    )
            );
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("test", "test");
            return ResponseEntity.notFound().headers(headers)
                    .build();
        }
        /*return optional.map(e -> ResponseEntity.ok(
                baseMapper.convertEntityToDTO(
                        e
                )
        )).orElseGet(() -> ResponseEntity.notFound().build());*/
    }

    @PostMapping
    public ResponseEntity<D> save(@RequestBody D d) {
        E e = baseService.save(
                baseMapper.convertDTOToEntity(d)
        );
        return ResponseEntity.ok(baseMapper.convertEntityToDTO(e));
    }

    @PutMapping
    public ResponseEntity<D> update(@RequestBody D d) {
        E e = baseService.save(
                baseMapper.convertDTOToEntity(d)
        );
        return ResponseEntity.ok(baseMapper.convertEntityToDTO(e));
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<D>> getPage(Pageable pageable) {
        Page<E> page = baseService.findAll(pageable);
        return ResponseEntity.ok(
                page.map(baseMapper::convertEntityToDTO)
        );
    }
}
