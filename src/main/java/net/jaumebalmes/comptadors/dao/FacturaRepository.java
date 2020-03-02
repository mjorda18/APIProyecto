package net.jaumebalmes.comptadors.dao;

import org.springframework.data.repository.CrudRepository;
import net.jaumebalmes.comptadors.model.Factura;

public interface FacturaRepository extends CrudRepository<Factura,Long> {
}
