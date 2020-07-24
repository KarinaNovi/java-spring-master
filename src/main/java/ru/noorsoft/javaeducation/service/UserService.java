package ru.noorsoft.javaeducation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.noorsoft.javaeducation.model.User;
import ru.noorsoft.javaeducation.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
       userRepository.deleteById(id);
    }


    public User updateUser(User user) {
        return userRepository.save(user);
    }
}






