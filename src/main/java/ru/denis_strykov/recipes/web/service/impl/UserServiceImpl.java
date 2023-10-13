package ru.denis_strykov.recipes.web.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import ru.denis_strykov.recipes.web.dto.RegistrationDto;
import ru.denis_strykov.recipes.web.models.Role;
import ru.denis_strykov.recipes.web.models.UserEntity;
import ru.denis_strykov.recipes.web.repository.RoleRepository;
import ru.denis_strykov.recipes.web.repository.UserRepository;
import ru.denis_strykov.recipes.web.service.UserService;

import java.util.Arrays;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository repository) {
        this.userRepository = userRepository;
        this.roleRepository = repository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUserName(registrationDto.getUserName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
