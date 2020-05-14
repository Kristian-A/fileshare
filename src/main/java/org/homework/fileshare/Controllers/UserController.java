package org.homework.fileshare.Controllers;

import org.homework.fileshare.Entities.UserEntity;
import org.homework.fileshare.PlainEncoder;
import org.homework.fileshare.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    public UserRepository repo;

    @PostMapping(value = "/register")
    public String add(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        UserEntity user = new UserEntity(username, encoder.encode(password));
        repo.save(user);
        return "saved user " + username;
    }
}
