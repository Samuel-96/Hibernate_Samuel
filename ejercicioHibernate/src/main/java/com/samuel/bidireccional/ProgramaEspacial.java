package com.samuel.bidireccional;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * DIRECCIONALIDAD: BIDIRECCIONAL Astronauta <---> ProgramaEspacial
 * CARDINALIDAD: 1-N
 * EXPLICACION RELACION: Uno o varios astronautas participan en un programa espacial, y un programa espacial tiene a uno o varios astronautas
 * PROPIETARIO RELACIÓN: Astronauta, porque es la parte de N de la relacion
 */
@Entity
@Table(name = "programas_espaciales")
public class ProgramaEspacial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @Column
    private double presupuesto;
    @OneToMany(mappedBy = "programaEspacial",cascade = CascadeType.PERSIST)
    private List<Astronauta> astronautas;

    public ProgramaEspacial() {
    }

    public ProgramaEspacial(String nombre, double presupuesto, List<Astronauta> astronautas) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.astronautas = astronautas;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Astronauta> getAstronautas() {
        return astronautas;
    }

    public void setAstronautas(List<Astronauta> astronautas) {
        this.astronautas = astronautas;
    }

    @Override
    public String toString() {
        return "ProgramaEspacial{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                '}';
    }
}
