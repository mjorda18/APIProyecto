package net.jaumebalmes.comptadors.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comptador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;



    String adreca;
    String propietari;
    String codi;


    @OneToMany(mappedBy = "comptador")
    List<Lectura> lectures;

    @ManyToOne
    Client client;

    Long ultimaLecturaFacturadaId;

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

    public Long getUltimaLecturaFacturadaId() {
        return ultimaLecturaFacturadaId;
    }

    public void setUltimaLecturaFacturadaId(Long ultimaLecturaFacturadaId) {
        this.ultimaLecturaFacturadaId = ultimaLecturaFacturadaId;
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

    public String getPropietari() {
        return propietari;
    }

    public void setPropietari(String propietari) {
        this.propietari = propietari;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }
}
