package br.com.mateus.study.endpoint.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mateus.study.endpoint.model.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String> {
}
