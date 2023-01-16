package br.com.mateus.study.endpoint.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.study.endpoint.dto.UserDTO;
import br.com.mateus.study.endpoint.model.User;
import br.com.mateus.study.endpoint.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO save(final UserDTO userDto) {
        if (!Strings.isBlank(userDto.getId())) {
            throw new IllegalArgumentException("ID should be empty (auto generated)");
        }

        return new UserDTO(userRepository.save(new User(userDto)));
    }

    public UserDTO findById(final String id) {
        throwIfNotExists(id);
        final User subject = userRepository.findById(id).get();
        return new UserDTO(subject);
    }

    public List<UserDTO> findAll() {
        final List<User> subjects = userRepository.findAll();
        return subjects.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public void delete(final String id) {
        throwIfNotExists(id);
        userRepository.deleteById(id);
    }

    public UserDTO update(final UserDTO userDto) {
        throwIfNotExists(userDto.getId());
        return new UserDTO(userRepository.save(new User(userDto)));
    }

    private void throwIfNotExists(final String id) {
        if (Strings.isBlank(id) || !userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found!");
        }
    }
}
