package com.samuel.unidireccional;

import jakarta.persistence.*;

import java.io.Serializable;
/**
 * DIRECCIONALIDAD: UNIDIRECCIONAL Capitan ---> BARCO
 * CARDINALIDAD: 1-1
 * EXPLICACION RELACION: Un capitán tiene un barco y un barco es pilotado por un único capitán
 * PROPIETARIO RELACIÓN: Capitán, lo elijo así porque la relación es 1-1
 */
@Entity
@Table(name = "barcos")
public class Barco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column (name = "nombre_barco")
    private String nomBarco;
    @Column (name = "año_fabricacion")
    private int annoFabricacion;
    @Column
    private int capacidad;

    public Barco() {
    }

    public Barco(String nomBarco, int annoFabricacion, int capacidad) {
        this.nomBarco = nomBarco;
        this.annoFabricacion = annoFabricacion;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public String getNomBarco() {
        return nomBarco;
    }

    public void setNomBarco(String nomBarco) {
        this.nomBarco = nomBarco;
    }

    public int getAnnoFabricacion() {
        return annoFabricacion;
    }

    public void setAnnoFabricacion(int annoFabricacion) {
        this.annoFabricacion = annoFabricacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Barco{" +
                "id=" + id +
                ", nomBarco='" + nomBarco + '\'' +
                ", annoFabricacion=" + annoFabricacion +
                ", capacidad=" + capacidad +
                '}';
    }
}
