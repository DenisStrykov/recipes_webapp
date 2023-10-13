package ru.denis_strykov.recipes.web.service;


import ru.denis_strykov.recipes.web.dto.RegistrationDto;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);

}
