package net.jaumebalmes.comptadors.controllers;

import net.jaumebalmes.comptadors.dao.LecturaRepository;
import net.jaumebalmes.comptadors.dao.ServiceRepository;
import net.jaumebalmes.comptadors.model.Lectura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;


}
