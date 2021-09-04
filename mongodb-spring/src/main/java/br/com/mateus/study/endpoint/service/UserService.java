package br.com.mateus.study.endpoint.service;

import br.com.mateus.study.endpoint.model.User;

import java.util.List;

public interface UserService {
    User save(User object);
    User findById(String id);
    List<User> findAll();
    void delete(String id);
    User update(User object);
}
