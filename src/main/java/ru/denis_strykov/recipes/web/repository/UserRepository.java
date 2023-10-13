package ru.denis_strykov.recipes.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis_strykov.recipes.web.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    UserEntity findByUserName(String userName);
    UserEntity findFirstByUserName(String username);

}
