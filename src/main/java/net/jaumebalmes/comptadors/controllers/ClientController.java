package net.jaumebalmes.comptadors.controllers;

import net.jaumebalmes.comptadors.dao.ClientRepository;
import net.jaumebalmes.comptadors.dao.ClientRepository;
import net.jaumebalmes.comptadors.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/controlGas/Client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        Optional<Client> ClientOpt = clientRepository.findById(id);
        if (ClientOpt.isPresent()) {
            Client Client = ClientOpt.get();
            return new ResponseEntity<Client>(Client,HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/controlGas/Client/")
    public ResponseEntity<Client> addClient(@RequestBody Client Client) {
        clientRepository.save(Client);
        return new ResponseEntity<Client>(Client,HttpStatus.CREATED);
    }

    @PutMapping("/controlGas/Client/")
    public ResponseEntity<Client> updateClient(@RequestBody Client Client) {
        clientRepository.save(Client);
        return new ResponseEntity<Client>(Client,HttpStatus.OK);
    }

    @DeleteMapping("/controlGas/Client/")
    public  ResponseEntity<Client> deleteClient(@RequestBody Client Client) {
        clientRepository.delete(Client);
        return new ResponseEntity<Client>(HttpStatus.OK);
    }
}
