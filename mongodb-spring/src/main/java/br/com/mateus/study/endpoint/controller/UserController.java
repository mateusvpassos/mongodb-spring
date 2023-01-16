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

import br.com.mateus.study.endpoint.dto.UserDTO;
import br.com.mateus.study.endpoint.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable final String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@Valid @RequestBody final UserDTO user, UriComponentsBuilder uriBuilder) {
        final UserDTO newUser = userService.save(user);
        final URI uri = uriBuilder.path("/user/" + newUser.getId()).build().toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody final UserDTO user) {
        final UserDTO newUser = userService.save(user);
        return ResponseEntity.ok().body(newUser);
    }
}
