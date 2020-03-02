package net.jaumebalmes.comptadors.controllers;

import net.jaumebalmes.comptadors.dao.LecturaRepository;
import net.jaumebalmes.comptadors.model.Lectura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LecturaController {
    @Autowired
    LecturaRepository lecturaRepository;

    @GetMapping("/controlGas/Lectura/{id}")
    public ResponseEntity<Lectura> getLectura(@PathVariable Long id) {
        Optional<Lectura> lecturaOpt = lecturaRepository.findById(id);
        if (lecturaOpt.isPresent()) {
            Lectura lectura = lecturaOpt.get();
            return new ResponseEntity<Lectura>(lectura,HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/controlGas/Lectura/")
    public ResponseEntity<Lectura> addLectura(@RequestBody Lectura lectura) {
        lecturaRepository.save(lectura);
        return new ResponseEntity<Lectura>(lectura,HttpStatus.CREATED);
    }

    @PutMapping("/controlGas/Lectura/")
    public ResponseEntity<Lectura> updateLectura(@RequestBody Lectura lectura) {
        lecturaRepository.save(lectura);
        return new ResponseEntity<Lectura>(lectura,HttpStatus.OK);
    }

    @DeleteMapping("/controlGas/Lectura/")
    public  ResponseEntity<Lectura> deleteLectura(@RequestBody Lectura lectura) {
        lecturaRepository.delete(lectura);
        return new ResponseEntity<Lectura>(HttpStatus.OK);
    }
}
