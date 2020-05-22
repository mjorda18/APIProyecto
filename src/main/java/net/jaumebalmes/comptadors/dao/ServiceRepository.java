package net.jaumebalmes.comptadors.dao;

import net.jaumebalmes.comptadors.model.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ServiceRepository extends CrudRepository<Service,Long> {

}
