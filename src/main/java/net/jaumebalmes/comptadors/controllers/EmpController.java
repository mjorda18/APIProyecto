package net.jaumebalmes.comptadors.controllers;

import net.jaumebalmes.comptadors.dao.ComptadorRepository;
import net.jaumebalmes.comptadors.dao.EmpRepository;
import net.jaumebalmes.comptadors.model.Comptador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmpController {
    @Autowired
    EmpRepository empRepository;

}
