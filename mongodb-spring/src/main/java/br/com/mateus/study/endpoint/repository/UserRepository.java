package br.com.mateus.study.endpoint.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mateus.study.endpoint.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
