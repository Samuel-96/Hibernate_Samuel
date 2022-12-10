package com.samuel.single;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * DIRECCIONALIDAD: ninguna ya que se trata de una relación SINGLE
 * CARDINALIDAD: ninguna
 * EXPLICACION RELACION: Clase instanciable Bicicleta para el ejemplo de relacion single
 */
@Entity
@Table(name = "bicicletas")
public class Bicicleta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column //anotación no obligatoria puesto que Hibernate lo hace por sí mismo pero la añado por legibilidad
    private String marca;
    @Column(name = "número_ruedas")
    private int nRuedas;
    @Transient //uso de anotacion transient porque no quiero persistir el atributo detalles
    private String detalles;

    public Bicicleta() {
    }

    public Bicicleta(String marca, int nRuedas, String detalles) {
        this.marca = marca;
        this.nRuedas = nRuedas;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    //NO NOS INTERESA QUE EL SETTER DE ID SEA MODIFICABLE
    /*public void setId(int id) {
        this.id = id;
    }*/

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getnRuedas() {
        return nRuedas;
    }

    public void setnRuedas(int nRuedas) {
        this.nRuedas = nRuedas;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", nRuedas=" + nRuedas +
                ", detalles='" + detalles + '\'' +
                '}';
    }
}
