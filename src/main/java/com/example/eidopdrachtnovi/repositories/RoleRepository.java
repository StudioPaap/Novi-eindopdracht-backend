package com.example.eidopdrachtnovi.repositories;

import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RoleRepository extends CrudRepository<Role, String> {
}