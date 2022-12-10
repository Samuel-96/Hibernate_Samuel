package com.samuel.herencia;

import jakarta.persistence.*;

import java.io.Serializable;
/**
 * DIRECCIONALIDAD: NINGUNA, ES UNA RELACION DE HERENCIA ENTRE Soldado y SoldadoInfanteria
 * CARDINALIDAD: NINGUNA
 * EXPLICACION RELACION: HERENCIA
 * TIPO DE HERENCIA: SINGLE TABLE
 */
@Entity
@Table(name = "soldados")
@Inheritance(strategy = InheritanceType.JOINED)

public class Soldado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;

    public Soldado() {

    }

    public Soldado(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Soldado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
