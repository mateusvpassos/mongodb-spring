package br.com.mateus.study.endpoint.controller;

import br.com.mateus.study.endpoint.model.Review;
import br.com.mateus.study.endpoint.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Review findById(@PathVariable String id){
        return reviewService.findById(id);
    }

    @PostMapping
    public Review save(@RequestBody Review review){
        return reviewService.save(review);
    }
}
