package br.com.mateus.study.endpoint.controller;

import br.com.mateus.study.endpoint.model.Subject;
import br.com.mateus.study.endpoint.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> findAll(){
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public Subject findById(@PathVariable String id){
        return subjectService.findById(id);
    }

    @PostMapping
    public Subject save(@RequestBody Subject subject){
        return subjectService.save(subject);
    }
}
