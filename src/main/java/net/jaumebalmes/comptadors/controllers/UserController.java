package net.jaumebalmes.comptadors.controllers;

import net.jaumebalmes.comptadors.dao.ClientRepository;
import net.jaumebalmes.comptadors.dao.ClientRepository;
import net.jaumebalmes.comptadors.dao.UserRepository;
import net.jaumebalmes.comptadors.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

}
