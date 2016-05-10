package fr.lauthieb.repository;

import java.util.List;

import fr.lauthieb.business.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);
}