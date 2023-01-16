package br.com.mateus.study.endpoint.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.study.endpoint.dto.ReviewDTO;
import br.com.mateus.study.endpoint.model.Review;
import br.com.mateus.study.endpoint.model.Subject;
import br.com.mateus.study.endpoint.model.User;
import br.com.mateus.study.endpoint.repository.ReviewRepository;
import br.com.mateus.study.endpoint.repository.SubjectRepository;
import br.com.mateus.study.endpoint.repository.UserRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserRepository userRepository;

    public ReviewDTO save(final ReviewDTO reviewDto) {
        if (!Strings.isBlank(reviewDto.getId())) {
            throw new IllegalArgumentException("ID should be empty (auto generated)");
        }

        final Subject subject = subjectRepository
                .findById(reviewDto.getSubject().getId())
                .orElseThrow(() -> new EntityNotFoundException("Subject not found!"));
        final User user = userRepository
                .findById(reviewDto.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));
        final Review review = new Review(reviewDto, subject, user);
        return new ReviewDTO(reviewRepository.save(review));
    }

    public ReviewDTO findById(final String id) {
        throwIfNotExists(id);
        final Review review = reviewRepository.findById(id).get();
        return new ReviewDTO(review);
    }

    public List<ReviewDTO> findAll() {
        final List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(ReviewDTO::new).collect(Collectors.toList());
    }

    public void delete(final String id) {
        throwIfNotExists(id);
        reviewRepository.deleteById(id);
    }

    public ReviewDTO update(final ReviewDTO reviewDto) {
        throwIfNotExists(reviewDto.getId());

        final Subject subject = subjectRepository
                .findById(reviewDto.getSubject().getId())
                .orElseThrow(() -> new EntityNotFoundException("Subject not found!"));
        final User user = userRepository
                .findById(reviewDto.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));
        final Review review = new Review(reviewDto, subject, user);
        return new ReviewDTO(reviewRepository.save(review));
    }

    private void throwIfNotExists(final String id) {
        if (Strings.isBlank(id) || !reviewRepository.existsById(id)) {
            throw new EntityNotFoundException("Review not found!");
        }
    }
}
