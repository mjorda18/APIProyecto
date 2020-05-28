package net.jaumebalmes.proyecto.controllers;


import net.jaumebalmes.proyecto.dao.EmpRepository;

import net.jaumebalmes.proyecto.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpController {
    @Autowired
    EmpRepository empRepository;


    @GetMapping("/controlApp/Emp/{id}")
    public ResponseEntity<Emp> getEmp(@PathVariable Long id) {
        Optional<Emp> EmpOpt = empRepository.findById(id);
        if (EmpOpt.isPresent()) {
            Emp Emp = EmpOpt.get();
            return new ResponseEntity<Emp>(Emp, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/controlApp/Emp/")
    public ResponseEntity<ArrayList<Emp>> getAllEmp() {
        Iterable<Emp> EmpOpt = empRepository.findAll();
        ArrayList<Emp> result = new ArrayList<>();
        EmpOpt.forEach(result::add);
        return new ResponseEntity<ArrayList<Emp>>(result,HttpStatus.OK);
    }

    @PostMapping("/controlApp/Emp/")
    public ResponseEntity<Emp> addEmp(@RequestBody Emp Emp) {
       empRepository.save(Emp);
        return new ResponseEntity<Emp>(Emp,HttpStatus.CREATED);
    }

    @PutMapping("/controlApp/Emp/")
    public ResponseEntity<Emp> updateEmp(@RequestBody Emp Emp) {
        empRepository.save(Emp);
        return new ResponseEntity<Emp>(Emp,HttpStatus.OK);
    }

    @DeleteMapping("/controlApp/Emp/")
    public  ResponseEntity<Emp> deleteEmp(@RequestBody Emp Emp) {
       empRepository.delete(Emp);
        return new ResponseEntity<Emp>(HttpStatus.OK);
    }
}
