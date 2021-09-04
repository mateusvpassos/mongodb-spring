package br.com.mateus.study.endpoint.repository;

import br.com.mateus.study.endpoint.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
