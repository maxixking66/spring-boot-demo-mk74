package com.maktabsharif.springbootdemo.resource;

import com.maktabsharif.springbootdemo.domain.Tag;
import com.maktabsharif.springbootdemo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagResource {

    private final TagService tagService;

    //    /tag?id=5
    @GetMapping
    public Tag getById(@RequestParam(name = "id") Long id) {
        return tagService.findById(id).get();
    }

    @PostMapping
    public Tag save(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

}
