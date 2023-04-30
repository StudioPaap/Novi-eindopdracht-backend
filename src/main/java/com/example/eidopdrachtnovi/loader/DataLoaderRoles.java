package com.example.eidopdrachtnovi.loader;

import com.example.eidopdrachtnovi.models.Role;
import com.example.eidopdrachtnovi.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoaderRoles implements CommandLineRunner {

    private final RoleRepository roleRepos;

    @Autowired
    public DataLoaderRoles(RoleRepository roleRepos) {
        this.roleRepos = roleRepos;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = new ArrayList<>();
        Role admin = new Role();
        admin.setRolename("ADMIN");
        roles.add(admin);

        Role user = new Role();
        user.setRolename("USER");
        roles.add(user);


        for (Role role : roles) {
            roleRepos.save(role);
        }
    }
}




