package net.jaumebalmes.comptadors.dao;

import net.jaumebalmes.comptadors.model.Comptador;
import org.springframework.data.repository.CrudRepository;

public interface ComptadorRepository extends CrudRepository<Comptador,Long> {
}
