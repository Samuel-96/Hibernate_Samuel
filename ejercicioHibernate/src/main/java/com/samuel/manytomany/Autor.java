package com.samuel.manytomany;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
/**
 * DIRECCIONALIDAD: BIDIRECCIONAL Libro <---> Autor
 * CARDINALIDAD: N-N
 * EXPLICACION RELACION: Uno o varios libros participan son escritos por uno o varios autores
 * PROPIETARIO RELACIÓN: Libro, lo elijo yo puesto que es una relación N-N
 */
@Entity
@Table(name = "autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @Column
    private String nacionalidad;
    @ManyToMany(mappedBy = "autores",cascade = CascadeType.PERSIST)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(String nombre, String nacionalidad, List<Libro> libros) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libros = libros;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
