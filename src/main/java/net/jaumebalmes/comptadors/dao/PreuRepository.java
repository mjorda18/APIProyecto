package net.jaumebalmes.comptadors.dao;

import net.jaumebalmes.comptadors.model.Preu;
import org.springframework.data.repository.CrudRepository;

public interface PreuRepository extends CrudRepository<Preu,Long> {
}
