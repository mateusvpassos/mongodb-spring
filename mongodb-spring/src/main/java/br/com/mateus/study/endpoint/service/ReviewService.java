package br.com.mateus.study.endpoint.service;

import br.com.mateus.study.endpoint.model.Review;

import java.util.List;

public interface ReviewService {
    Review save(Review object);
    Review findById(String id);
    List<Review> findAll();
    void delete(String id);
    Review update(Review object);
}
