package ru.noorsoft.javaeducation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.noorsoft.javaeducation.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    void deleteById(Long id);
}