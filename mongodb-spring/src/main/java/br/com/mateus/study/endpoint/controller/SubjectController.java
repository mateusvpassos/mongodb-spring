package br.com.mateus.study.endpoint.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mateus.study.endpoint.dto.SubjectDTO;
import br.com.mateus.study.endpoint.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> findAll() {
        return ResponseEntity.ok().body(subjectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDTO> findById(@PathVariable final String id) {
        return ResponseEntity.ok().body(subjectService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SubjectDTO> save(@Valid @RequestBody final SubjectDTO subject,
            UriComponentsBuilder uriBuilder) {
        final SubjectDTO newSubject = subjectService.save(subject);
        final URI uri = uriBuilder.path("/subject/" + newSubject.getId()).build().toUri();
        return ResponseEntity.created(uri).body(newSubject);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        subjectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<SubjectDTO> update(@RequestBody final SubjectDTO subject) {
        final SubjectDTO newSubject = subjectService.save(subject);
        return ResponseEntity.ok().body(newSubject);
    }
}
