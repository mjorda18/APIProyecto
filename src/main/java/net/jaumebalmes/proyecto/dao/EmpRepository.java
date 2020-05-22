package net.jaumebalmes.proyecto.dao;

import net.jaumebalmes.proyecto.model.Emp;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Emp,Long> {
}
