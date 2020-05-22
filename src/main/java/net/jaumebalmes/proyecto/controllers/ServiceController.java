package net.jaumebalmes.proyecto.controllers;

import net.jaumebalmes.proyecto.dao.LecturaRepository;
import net.jaumebalmes.proyecto.dao.ServiceRepository;
import net.jaumebalmes.proyecto.model.Lectura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;


}
