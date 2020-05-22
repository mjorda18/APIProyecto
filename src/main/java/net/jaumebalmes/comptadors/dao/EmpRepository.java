package net.jaumebalmes.comptadors.dao;

import net.jaumebalmes.comptadors.model.Emp;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Emp,Long> {
}
