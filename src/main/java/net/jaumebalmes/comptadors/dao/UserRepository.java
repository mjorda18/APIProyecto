package net.jaumebalmes.comptadors.dao;

import net.jaumebalmes.comptadors.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
