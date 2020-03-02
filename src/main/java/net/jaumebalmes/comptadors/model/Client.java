package net.jaumebalmes.comptadors.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nom;
    String cognoms;
    String dni;

    @OneToMany(mappedBy = "client")
    List<Comptador> comptadors;

}
