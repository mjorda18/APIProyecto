package net.jaumebalmes.proyecto.dao;

import net.jaumebalmes.proyecto.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
