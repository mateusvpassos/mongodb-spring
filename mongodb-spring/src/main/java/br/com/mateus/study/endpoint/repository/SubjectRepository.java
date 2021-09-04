package br.com.mateus.study.endpoint.repository;

import br.com.mateus.study.endpoint.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, String> {
}
