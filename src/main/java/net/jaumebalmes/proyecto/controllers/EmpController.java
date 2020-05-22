package net.jaumebalmes.proyecto.controllers;

import net.jaumebalmes.proyecto.dao.ComptadorRepository;
import net.jaumebalmes.proyecto.dao.EmpRepository;
import net.jaumebalmes.proyecto.model.Comptador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {
    @Autowired
    EmpRepository empRepository;

}
