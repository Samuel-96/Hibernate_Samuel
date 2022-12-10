package com.samuel.herencia;

import jakarta.persistence.*;

import java.io.Serializable;
/**
 * DIRECCIONALIDAD: NINGUNA, ES UNA RELACION DE HERENCIA ENTRE Medico y Cirujano
 * CARDINALIDAD: NINGUNA
 * EXPLICACION RELACION: HERENCIA
 * TIPO DE HERENCIA: SINGLE TABLE
 */
@Entity
@Table(name = "medicos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //no es necesaria esta anotacion porque hibernate la pone por defecto
@DiscriminatorColumn(name = "tipo_medico", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Medico")
public class Medico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;
    @Column
    protected String nombre;

    public Medico() {
    }

    public Medico(String nombre) {
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
        return "Medico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
