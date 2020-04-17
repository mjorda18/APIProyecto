package net.jaumebalmes.comptadors.dao;

import net.jaumebalmes.comptadors.model.Client;
import net.jaumebalmes.comptadors.model.Comptador;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
