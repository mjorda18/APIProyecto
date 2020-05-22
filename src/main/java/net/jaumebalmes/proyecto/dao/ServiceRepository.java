package net.jaumebalmes.proyecto.dao;

import net.jaumebalmes.proyecto.model.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service,Long> {

}
