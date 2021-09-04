package br.com.mateus.study.endpoint.service;

import br.com.mateus.study.endpoint.model.Subject;
import br.com.mateus.study.endpoint.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject save(Subject object) {
        return subjectRepository.save(object);
    }

    @Override
    public Subject findById(String id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found!"));
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void delete(String id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject update(Subject object) {
        return subjectRepository.save(object);
    }
}
