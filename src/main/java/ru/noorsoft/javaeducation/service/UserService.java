package ru.noorsoft.javaeducation.service;

import ru.noorsoft.javaeducation.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User save(User user);
    Optional<User> findById(Long id);
    void delete(Long id);

}
