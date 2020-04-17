package net.jaumebalmes.comptadors.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comptador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;



    String adreca;
    String codi;


    @OneToMany(mappedBy = "comptador")
    List<Lectura> lectures;

    @ManyToOne
    Client client;

    @OneToOne
    Lectura ultimaLecturaFacturada;

    public List<Lectura> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lectura> lectures) {
        this.lectures = lectures;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Lectura getUltimaLecturaFacturada() {
        return ultimaLecturaFacturada;
    }

    public void setUltimaLecturaFacturada(Lectura ultimaLecturaFacturadaId) {
        this.ultimaLecturaFacturada = ultimaLecturaFacturadaId;
    }

    public Comptador() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    @Override
    public String toString() {
        return "Comptador{" +
                "id=" + id +
                ", adreca='" + adreca + '\'' +
                ", codi='" + codi + '\'' +
                ", client=" + client +
                '}';
    }
}
