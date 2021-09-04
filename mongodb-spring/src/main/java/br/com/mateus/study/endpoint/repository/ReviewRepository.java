package br.com.mateus.study.endpoint.repository;

import br.com.mateus.study.endpoint.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
