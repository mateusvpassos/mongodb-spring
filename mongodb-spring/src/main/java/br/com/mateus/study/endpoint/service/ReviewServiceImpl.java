package br.com.mateus.study.endpoint.service;

import br.com.mateus.study.endpoint.model.Review;
import br.com.mateus.study.endpoint.model.Subject;
import br.com.mateus.study.endpoint.model.User;
import br.com.mateus.study.endpoint.repository.ReviewRepository;
import br.com.mateus.study.endpoint.repository.SubjectRepository;
import br.com.mateus.study.endpoint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Review save(Review object) {
        Subject subject = subjectRepository
                .findById(object.getSubject().getId())
                .orElseThrow(() -> new IllegalArgumentException("Subject not found!"));
        User user = userRepository
                .findById(object.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
        object.setSubject(subject);
        object.setUser(user);
        return reviewRepository.save(object);
    }

    @Override
    public Review findById(String id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Review not found!"));
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void delete(String id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review update(Review object) {
        return reviewRepository.save(object);
    }
}
