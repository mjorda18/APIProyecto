package net.jaumebalmes.comptadors.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lectura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    Comptador comptador;

    Date data;
    Double valor;

}
