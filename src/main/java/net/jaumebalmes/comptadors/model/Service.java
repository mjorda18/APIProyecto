package net.jaumebalmes.comptadors.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String type;
    String Descripcio;

    @ManyToOne
    Emp empresa;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", Descripcio='" + Descripcio + '\'' +
                ", empresa=" + empresa +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public void setDescripcio(String descripcio) {
        Descripcio = descripcio;
    }

    public Emp getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Emp empresa) {
        this.empresa = empresa;
    }
}
