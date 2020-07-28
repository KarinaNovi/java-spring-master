package ru.noorsoft.javaeducation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.noorsoft.javaeducation.model.User;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    void deleteById(Long id);
    Optional<User> findById(Long id);
}