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
@Table(name = "capitanes")
public class Capitan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_barco",referencedColumnName = "id")
    private Barco barco;

    public Capitan() {
    }

    public Capitan(String nombre, Barco barco) {
        this.nombre = nombre;
        this.barco = barco;
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

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String toString() {
        return "Capitan{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", barco=" + barco +
                '}';
    }
}
