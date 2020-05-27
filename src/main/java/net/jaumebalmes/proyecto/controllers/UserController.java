package net.jaumebalmes.proyecto.controllers;


import net.jaumebalmes.proyecto.dao.UserRepository;
import net.jaumebalmes.proyecto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/controlApp/User/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> UserOpt = userRepository.findById(id);
        if (UserOpt.isPresent()) {
            User User = UserOpt.get();
            return new ResponseEntity<User>(User, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/controlApp/User/")
    public ResponseEntity<User> addClient(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<User>(user,HttpStatus.CREATED);
    }

    @PutMapping("/controlApp/User/")
    public ResponseEntity<User> updateClient(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @DeleteMapping("/controlApp/User/")
    public  ResponseEntity<User> deleteClient(@RequestBody User user) {
        userRepository.delete(user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

}
