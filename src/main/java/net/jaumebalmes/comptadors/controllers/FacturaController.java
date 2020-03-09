package net.jaumebalmes.comptadors.controllers;

import net.jaumebalmes.comptadors.dao.ComptadorRepository;
import net.jaumebalmes.comptadors.dao.FacturaRepository;
import net.jaumebalmes.comptadors.dao.PreuRepository;
import net.jaumebalmes.comptadors.dao.LecturaRepository;
import net.jaumebalmes.comptadors.model.Comptador;
import net.jaumebalmes.comptadors.model.Factura;
import net.jaumebalmes.comptadors.model.Lectura;
import net.jaumebalmes.comptadors.model.Preu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class FacturaController {
    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    ComptadorRepository comptadorRepository;
    @Autowired
    LecturaRepository lecturaRepository;
    @Autowired
    PreuRepository preuRepository;

    @GetMapping("/controlGas/Factura/{id}")
    public ResponseEntity<Factura> getFactura(@PathVariable Long id) {
        Optional<Factura> facturaOpt = facturaRepository.findById(id);
        if (facturaOpt.isPresent()) {
            Factura factura = facturaOpt.get();
            return new ResponseEntity<Factura>(factura, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/controlGas/Factura/")
    public ResponseEntity<Factura> addFactura(@RequestBody Factura factura) {
        facturaRepository.save(factura);
        return new ResponseEntity<Factura>(factura,HttpStatus.CREATED);
    }

    @PutMapping("/controlGas/Factura/")
    public ResponseEntity<Factura> updateLectura(@RequestBody Factura factura) {
        facturaRepository.save(factura);
        return new ResponseEntity<Factura>(factura,HttpStatus.OK);
    }

    @DeleteMapping("/controlGas/Factura/")
    public  ResponseEntity<Factura> deleteLectura(@RequestBody Factura factura) {
        facturaRepository.delete(factura);
        return new ResponseEntity<Factura>(HttpStatus.OK);
    }

    public void calculaFactures() {
        for (Comptador comptador:comptadorRepository.findAll()) {
            Lectura ultimaLecturaFactura = comptador.getUltimaLecturaFacturada();
            Date dataUltimaLecturaFacturada = ultimaLecturaFactura.getData();

            List<Lectura> lecturaList = lecturaRepository.findByComptadorAndDataBefore(comptador,dataUltimaLecturaFacturada);
            if (!lecturaList.isEmpty()) {
                Date ultimaLecturaData = ultimaLecturaFactura.getData();
                Lectura maxLectura = lecturaList.get(0);
                for (Lectura lecturaNoFacturada:lecturaList) {
                    Date dataLectura = lecturaNoFacturada.getData();
                    if (dataLectura.after(ultimaLecturaData)) {
                        ultimaLecturaData=dataLectura;
                        maxLectura = lecturaNoFacturada;
                    }
                }
                Double consum = maxLectura.getValor() - ultimaLecturaFactura.getValor();
                List<Preu> preuList= preuRepository.findByIniciAfterAndFiBefore(consum,consum);
                Preu preu = preuList.get(0);
                Double preuKWh = preu.getValor();
                Double total = consum * preuKWh;

                Factura factura = new Factura();
                factura.setClient(comptador.getClient());
                factura.setComptador(comptador);
                factura.setLecturaInicial(ultimaLecturaFactura.getValor());
                factura.setLecturaFinal(maxLectura.getValor());
                factura.setConsum(consum);
                factura.setTotal(total);

                factura.setDataEmissio(Calendar.getInstance().getTime());
                facturaRepository.save(factura);
                comptador.setUltimaLecturaFacturada(maxLectura);
                comptadorRepository.save(comptador);
            }
        }

        // obtenir comptadors
            //obtenir ultima lectura facturada

            // si existeix lectura més nova
                // calculo consum (lectura actual - lectura anterior)
                // calculo factura
                // genero factura
                // actualitzo ultima lectura factura
    }
}
