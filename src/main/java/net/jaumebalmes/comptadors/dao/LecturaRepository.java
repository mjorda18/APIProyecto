package net.jaumebalmes.comptadors.dao;

import net.jaumebalmes.comptadors.model.Comptador;
import net.jaumebalmes.comptadors.model.Lectura;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface LecturaRepository extends CrudRepository<Lectura,Long> {

    List<Lectura> findByComptadorAndDataBefore(Comptador comptador, Date dataUltimaLecturaFacturada);
}
