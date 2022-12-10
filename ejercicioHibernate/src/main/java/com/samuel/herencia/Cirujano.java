package com.samuel.herencia;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
/**
 * DIRECCIONALIDAD: NINGUNA, ES UNA RELACION DE HERENCIA ENTRE Medico y Cirujano
 * CARDINALIDAD: NINGUNA
 * EXPLICACION RELACION: HERENCIA
 * TIPO DE HERENCIA: SINGLE TABLE
 */
@Entity
@DiscriminatorValue("Cirujano")
public class Cirujano extends Medico{
    @Column
    private String especialidad;

    public Cirujano() {
    }

    public Cirujano(String nombre, String especialidad) {
        super(nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Cirujano{" +
                "especialidad='" + especialidad + '\'' +
                "} " + super.toString();
    }
}
