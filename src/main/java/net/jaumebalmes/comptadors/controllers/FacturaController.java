package net.jaumebalmes.comptadors.controllers;

import net.jaumebalmes.comptadors.dao.FacturaRepository;
import net.jaumebalmes.comptadors.dao.LecturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class FacturaController {
    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    ComptadorRepository comptadorRepository;
    @Autowired
    LecturaRepository lecturaRepository;


    public void calculaFactures() {
        List<Comptador> comptadorList = comptadorRepository.findAll();
        for (Comptador comptador:comptadorList) {
            Long ultimaLecturaFacturaId = comptador.getultimaLecturaFacturadaId();
            Lectura ultimaLecturaFacturada = lecturaRepository.findById(ultimaLecturaFacturaId);
            Date dataUltimaLecturaFacturada = ultimaLecturaFacturada.getData();

            List<Lectura> lecturaList = lecturaRepository.findByComptadorAndDataGreaterThan(comptador,dataUltimaLecturaFacturada);
            if (!lecturaList.isEmpty()) {
                Date ultimaLectura = ultimaLecturaFacturada;
                Lectura maxLectura = lecturaList.get(0);
                for (Lectura lecturaNoFacturada:lecturaList) {
                    Date dataLectura = lecturaNoFacturada.getData();
                    if (dataLectura>ultimaLectura) {
                        ultimaLectura=dataLectura;
                        maxLectura = lecturaNoFacturada;
                    }
                }
                Double consum = maxLectura.getValor() - ultimaLecturaFacturada.getValor();
                List<Preu> preuList= preuRepository.findByIniciGreaterThanAndFiLessThan(consum,consum);
                Preu preu = preuList.get(0);
                Double preuKWh = preu.getValor();
                Double total = consum * preuKWh;

                Factura factura = new Factura();
                factura.setClient(comptador.getClient());
                factura.setComptador(comptador);
                factura.setLecturaInicial(ultimaLecturaFacturada.getValor());
                factura.setLecturaFinal(maxLectura.getValor());
                factura.setConsum(consum);
                factura.setTotal(total);
                factura.setDataEmissio(LocalDate.now());
                facturaRepository.save(factura);
                comptador.setultimaLecturaFacturadaId(maxLectura.getId());
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
