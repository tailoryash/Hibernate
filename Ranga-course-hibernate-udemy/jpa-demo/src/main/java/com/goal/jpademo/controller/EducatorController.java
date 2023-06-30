package com.goal.jpademo.controller;

import com.goal.jpademo.entity.jdbc.Educator;
import com.goal.jpademo.service.EducatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educators")
@RequiredArgsConstructor
public class EducatorController {

    private final EducatorService educatorService;

    @GetMapping
    public List<Educator> findAllEducators() {
        return educatorService.findAllEducators();
    }

    @GetMapping("/{id}")
    public Educator findEducator(@PathVariable int id) {
        return educatorService.findEducator(id);
    }

    @DeleteMapping("/{id}")
    public int deleteEducator(@PathVariable int id) {
        return educatorService.deleteEducator(id);
    }

    @PostMapping
    public int saveEducator(@RequestBody Educator educator) {
        return educatorService.saveEducator(educator);
    }

    @PutMapping
    public int updateEducator(@RequestBody Educator educator) {
        return educatorService.updateEducator(educator);
    }
}
