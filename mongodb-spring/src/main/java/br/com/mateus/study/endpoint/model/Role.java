package br.com.mateus.study.endpoint.model;

public enum Role {
    ADM("Administrator"),
    CLI("Client");

    private String name;

    Role(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
