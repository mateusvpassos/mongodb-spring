package br.com.mateus.study.endpoint.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mateus.study.endpoint.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
