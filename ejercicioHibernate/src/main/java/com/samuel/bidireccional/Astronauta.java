package com.samuel.bidireccional;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * DIRECCIONALIDAD: BIDIRECCIONAL Astronauta <---> ProgramaEspacial
 * CARDINALIDAD: 1-N
 * EXPLICACION RELACION: Uno o varios astronautas participan en un programa espacial, y un programa espacial tiene a uno o varios astronautas
 * PROPIETARIO RELACIÓN: Astronauta, porque es la parte de N de la relacion
 */
@Entity
@Table(name = "astronautas")
public class Astronauta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @Column
    private String especialidad;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_programa_espacial",referencedColumnName = "id")
    private ProgramaEspacial programaEspacial;

    public Astronauta() {
    }

    public Astronauta(String nombre, String especialidad, ProgramaEspacial programaEspacial) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.programaEspacial = programaEspacial;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ProgramaEspacial getProgramaEspacial() {
        return programaEspacial;
    }

    public void setProgramaEspacial(ProgramaEspacial programaEspacial) {
        this.programaEspacial = programaEspacial;
    }

    @Override
    public String toString() {
        return "Astronauta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", programaEspacial=" + programaEspacial +
                '}';
    }
}
