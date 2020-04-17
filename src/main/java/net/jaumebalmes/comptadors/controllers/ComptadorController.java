package net.jaumebalmes.comptadors.controllers;

import net.jaumebalmes.comptadors.dao.ComptadorRepository;
import net.jaumebalmes.comptadors.model.Comptador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ComptadorController {
    @Autowired
    ComptadorRepository comptadorRepository;

    @GetMapping("/controlGas/Comptador/{id}")
    public ResponseEntity<Comptador> getComptador(@PathVariable Long id) {
        Optional<Comptador> ComptadorOpt = comptadorRepository.findById(id);
        if (ComptadorOpt.isPresent()) {
            Comptador Comptador = ComptadorOpt.get();
            return new ResponseEntity<Comptador>(Comptador,HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/controlGas/Comptador/")
    public ResponseEntity<Comptador> addComptador(@RequestBody Comptador Comptador) {
        comptadorRepository.save(Comptador);
        return new ResponseEntity<Comptador>(Comptador,HttpStatus.CREATED);
    }

    @PutMapping("/controlGas/Comptador/")
    public ResponseEntity<Comptador> updateComptador(@RequestBody Comptador Comptador) {
        comptadorRepository.save(Comptador);
        return new ResponseEntity<Comptador>(Comptador,HttpStatus.OK);
    }

    @DeleteMapping("/controlGas/Comptador/")
    public  ResponseEntity<Comptador> deleteComptador(@RequestBody Comptador Comptador) {
        comptadorRepository.delete(Comptador);
        return new ResponseEntity<Comptador>(HttpStatus.OK);
    }
}
