package com.samuel.herencia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

/**
 * DIRECCIONALIDAD: NINGUNA, ES UNA RELACION DE HERENCIA ENTRE Soldado y SoldadoInfanteria
 * CARDINALIDAD: NINGUNA
 * EXPLICACION RELACION: HERENCIA
 * TIPO DE HERENCIA: SINGLE TABLE
 */
@Entity
@PrimaryKeyJoinColumn(name = "soldado_infanteria_id") //anotacion para cambiar el nombre de la columna
public class SoldadoInfanteria extends Soldado{
    @Column
    private String unidadMilitar;

    public SoldadoInfanteria() {
    }

    public SoldadoInfanteria(String unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }

    public SoldadoInfanteria(String nombre, String unidadMilitar) {
        super(nombre);
        this.unidadMilitar = unidadMilitar;
    }

    public String getUnidadMilitar() {
        return unidadMilitar;
    }

    public void setUnidadMilitar(String peloton) {
        this.unidadMilitar = peloton;
    }

    @Override
    public String toString() {
        return "SoldadoInfanteria{" +
                "peloton='" + unidadMilitar + '\'' +
                "} " + super.toString();
    }
}
