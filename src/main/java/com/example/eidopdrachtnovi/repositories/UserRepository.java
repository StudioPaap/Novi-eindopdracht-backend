package com.example.eidopdrachtnovi.repositories;

import com.example.eidopdrachtnovi.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
