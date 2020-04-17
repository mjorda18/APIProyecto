package net.jaumebalmes.comptadors.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lectura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    Date data;
    Double valor;

    @ManyToOne
    Comptador comptador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comptador getComptador() {
        return comptador;
    }

    public void setComptador(Comptador comptador) {
        this.comptador = comptador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Lectura{" +
                "id=" + id +
                ", data=" + data +
                ", valor=" + valor +
                '}';
    }
}
