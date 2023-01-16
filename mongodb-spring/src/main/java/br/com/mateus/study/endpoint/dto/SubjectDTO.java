package br.com.mateus.study.endpoint.dto;

import javax.validation.constraints.NotBlank;

import br.com.mateus.study.endpoint.model.Subject;

public class SubjectDTO {

    private String id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    private String description;

    public SubjectDTO() {

    }

    public SubjectDTO(final Subject subject) {
        this.id = subject.getId();
        this.title = subject.getTitle();
        this.description = subject.getDescription();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
