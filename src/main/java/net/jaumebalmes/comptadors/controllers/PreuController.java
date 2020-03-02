package net.jaumebalmes.comptadors.controllers;

import net.jaumebalmes.comptadors.dao.PreuRepository;
import net.jaumebalmes.comptadors.dao.PreuRepository;
import net.jaumebalmes.comptadors.model.Preu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PreuController {
    @Autowired
    PreuRepository preuRepository;

    @GetMapping("/controlGas/Preu/{id}")
    public ResponseEntity<Preu> getPreu(@PathVariable Long id) {
        Optional<Preu> PreuOpt = preuRepository.findById(id);
        if (PreuOpt.isPresent()) {
            Preu Preu = PreuOpt.get();
            return new ResponseEntity<Preu>(Preu, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/controlGas/Preu/")
    public ResponseEntity<Preu> addPreu(@RequestBody Preu Preu) {
        preuRepository.save(Preu);
        return new ResponseEntity<Preu>(Preu,HttpStatus.CREATED);
    }

    @PutMapping("/controlGas/Preu/")
    public ResponseEntity<Preu> updatePreu(@RequestBody Preu Preu) {
        preuRepository.save(Preu);
        return new ResponseEntity<Preu>(Preu,HttpStatus.OK);
    }

    @DeleteMapping("/controlGas/Preu/")
    public  ResponseEntity<Preu> deletePreu(@RequestBody Preu Preu) {
        preuRepository.delete(Preu);
        return new ResponseEntity<Preu>(HttpStatus.OK);
    }
}
