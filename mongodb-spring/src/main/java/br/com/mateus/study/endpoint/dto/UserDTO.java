package br.com.mateus.study.endpoint.dto;

import javax.validation.constraints.NotBlank;

import br.com.mateus.study.endpoint.model.Role;
import br.com.mateus.study.endpoint.model.User;

public class UserDTO {

    private String id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Login is mandatory")
    private String login;
    private String password;
    @NotBlank(message = "Role is mandatory")
    private Role role;

    public UserDTO() {

    }

    public UserDTO(final User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setRole(final Role role) {
        this.role = role;
    }
}
