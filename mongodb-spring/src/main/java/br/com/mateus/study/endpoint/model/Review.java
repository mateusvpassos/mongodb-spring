package br.com.mateus.study.endpoint.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.mateus.study.endpoint.dto.ReviewDTO;

@Document
public class Review {

    @Id
    private String id;
    private String description;
    @DBRef
    private Subject subject;
    @DBRef
    private User user;

    public Review() {

    }

    public Review(final String id, final String description, final Subject subject, final User user) {
        this.id = id;
        this.description = description;
        this.subject = subject;
        this.user = user;
    }

    public Review(final ReviewDTO review) {
        this.id = review.getId();
        this.description = review.getDescription();
        this.subject = new Subject(review.getSubject());
        this.user = new User(review.getUser());
    }

    public Review(final ReviewDTO review, final Subject subject, final User user) {
        this.id = review.getId();
        this.description = review.getDescription();
        this.subject = subject;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(final Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }
}
