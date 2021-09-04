package br.com.mateus.study.endpoint.service;

import br.com.mateus.study.endpoint.model.Subject;

import java.util.List;

public interface SubjectService {
    Subject save(Subject object);
    Subject findById(String id);
    List<Subject> findAll();
    void delete(String id);
    Subject update(Subject object);
}
