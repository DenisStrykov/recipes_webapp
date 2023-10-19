package ru.denis_strykov.recipes.web.service;


import ru.denis_strykov.recipes.web.dto.RegistrationDto;
import ru.denis_strykov.recipes.web.models.UserEntity;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
