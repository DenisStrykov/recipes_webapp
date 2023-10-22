package ru.denis_strykov.recipes.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis_strykov.recipes.web.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}


