package ru.noorsoft.javaeducation.service;

import ru.noorsoft.javaeducation.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
    void delete(Long id);

}
