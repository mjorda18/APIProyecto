package net.jaumebalmes.comptadors.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Integer inici;
    public Integer fi;
    public Double valor;

}
