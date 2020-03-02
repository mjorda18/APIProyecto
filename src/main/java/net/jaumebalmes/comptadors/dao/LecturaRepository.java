package net.jaumebalmes.comptadors.dao;

import net.jaumebalmes.comptadors.model.Lectura;
import org.springframework.data.repository.CrudRepository;

public interface LecturaRepository extends CrudRepository<Lectura,Long> {
}
