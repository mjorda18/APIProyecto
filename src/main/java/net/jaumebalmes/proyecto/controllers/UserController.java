package net.jaumebalmes.proyecto.controllers;

import net.jaumebalmes.proyecto.dao.ClientRepository;
import net.jaumebalmes.proyecto.dao.UserRepository;
import net.jaumebalmes.proyecto.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

}
