package net.jaumebalmes.comptadors.dao;

import net.jaumebalmes.comptadors.model.Preu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PreuRepository extends CrudRepository<Preu,Long> {
    List<Preu> findByIniciAfterAndFiBefore(Double consum, Double consum1);
}
