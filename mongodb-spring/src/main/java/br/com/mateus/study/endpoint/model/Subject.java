package br.com.mateus.study.endpoint.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.mateus.study.endpoint.dto.SubjectDTO;

@Document
public class Subject {

    @Id
    private String id;
    private String title;
    private String description;

    public Subject() {
    }

    public Subject(final String id, final String title, final String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Subject(final SubjectDTO subject) {
        this.id = subject.getId();
        this.title = subject.getTitle();
        this.description = subject.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
