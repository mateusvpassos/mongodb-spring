package br.com.mateus.study.endpoint.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mateus.study.endpoint.dto.ReviewDTO;
import br.com.mateus.study.endpoint.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> findAll() {
        return ResponseEntity.ok().body(reviewService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> findById(@PathVariable final String id) {
        return ResponseEntity.ok().body(reviewService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> save(@Valid @RequestBody final ReviewDTO review, UriComponentsBuilder uriBuilder) {
        final ReviewDTO newReview = reviewService.save(review);
        final URI uri = uriBuilder.path("/review/" + newReview.getId()).build().toUri();
        return ResponseEntity.created(uri).body(newReview);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ReviewDTO> update(@RequestBody final ReviewDTO review) {
        final ReviewDTO newReview = reviewService.save(review);
        return ResponseEntity.ok().body(newReview);
    }
}
