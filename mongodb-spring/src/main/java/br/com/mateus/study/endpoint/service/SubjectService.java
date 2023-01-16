package br.com.mateus.study.endpoint.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.study.endpoint.dto.SubjectDTO;
import br.com.mateus.study.endpoint.model.Subject;
import br.com.mateus.study.endpoint.repository.SubjectRepository;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectDTO save(final SubjectDTO subjectDto) {
        if (!Strings.isBlank(subjectDto.getId())) {
            throw new IllegalArgumentException("ID should be empty (auto generated)");
        }

        return new SubjectDTO(subjectRepository.save(new Subject(subjectDto)));
    }

    public SubjectDTO findById(final String id) {
        throwIfNotExists(id);
        final Subject subject = subjectRepository.findById(id).get();
        return new SubjectDTO(subject);
    }

    public List<SubjectDTO> findAll() {
        final List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map(SubjectDTO::new).collect(Collectors.toList());
    }

    public void delete(final String id) {
        throwIfNotExists(id);
        subjectRepository.deleteById(id);
    }

    public SubjectDTO update(final SubjectDTO subjectDto) {
        throwIfNotExists(subjectDto.getId());
        return new SubjectDTO(subjectRepository.save(new Subject(subjectDto)));
    }

    private void throwIfNotExists(final String id) {
        if (Strings.isBlank(id) || !subjectRepository.existsById(id)) {
            throw new EntityNotFoundException("Subject not found!");
        }
    }
}
