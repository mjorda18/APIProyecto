package net.jaumebalmes.proyecto.controllers;


import net.jaumebalmes.proyecto.dao.ServiceRepository;

import net.jaumebalmes.proyecto.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/controlApp/Service/{id}")
    public ResponseEntity<Service> getService(@PathVariable Long id) {
        Optional<Service> serviceOpt = serviceRepository.findById(id);
        if (serviceOpt.isPresent()) {
            Service Service = serviceOpt.get();
            return new ResponseEntity<Service>(Service, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/controlApp/Service/")
    public ResponseEntity<Service> addService(@RequestBody Service service) {
        serviceRepository.save(service);
        return new ResponseEntity<Service>(service,HttpStatus.CREATED);
    }

    @PutMapping("/controlApp/Service/")
    public ResponseEntity<Service> updateLectura(@RequestBody Service service) {
        serviceRepository.save(service);
        return new ResponseEntity<Service>(service,HttpStatus.OK);
    }

    @DeleteMapping("/controlApp/Service/")
    public  ResponseEntity<Service> deleteService(@RequestBody Service service) {
        serviceRepository.delete(service);
        return new ResponseEntity<Service>(HttpStatus.OK);
    }


}
