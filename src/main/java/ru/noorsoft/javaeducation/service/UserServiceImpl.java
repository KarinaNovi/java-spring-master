package ru.noorsoft.javaeducation.service;

import org.springframework.stereotype.Service;
import ru.noorsoft.javaeducation.model.User;
import ru.noorsoft.javaeducation.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        for (User user : userRepository.findAll()) {

            users.add(user);
        }
        return users;
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
