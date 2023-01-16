package br.com.mateus.study.endpoint.dto;

import javax.validation.constraints.NotNull;

import br.com.mateus.study.endpoint.model.Review;

public class ReviewDTO {
    private String id;
    private String description;
    @NotNull(message = "Subject should not be null")
    private SubjectDTO subject;
    @NotNull(message = "User should not be null")
    private UserDTO user;

    public ReviewDTO() {

    }

    public ReviewDTO(final Review review) {
        this.id = review.getId();
        this.description = review.getDescription();
        this.subject = new SubjectDTO(review.getSubject());
        this.user = new UserDTO(review.getUser());
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setSubject(final SubjectDTO subject) {
        this.subject = subject;
    }

    public void setUser(final UserDTO user) {
        this.user = user;
    }
}
