package com.samuel.manytomany;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DIRECCIONALIDAD: BIDIRECCIONAL Libro <---> Autor
 * CARDINALIDAD: N-N
 * EXPLICACION RELACION: Uno o varios libros participan son escritos por uno o varios autores
 * PROPIETARIO RELACIÓN: Libro, lo elijo yo puesto que es una relación N-N
 */
@Entity
@Table(name = "libros")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String titulo;
    @Column
    private double precio;
    @Column(name = "año_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable (
                name = "libros_autores",
                joinColumns = {@JoinColumn(name = "fk_libro",referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "fk_autor",referencedColumnName = "id")}
                )
    private List<Autor> autores;

    public Libro() {
    }

    public Libro(String titulo, double precio, Date fecha, List<Autor> autores) {
        this.titulo = titulo;
        this.precio = precio;
        this.fecha = fecha;
        this.autores = autores;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", fecha=" + fecha +
                ", autores=" + autores +
                '}';
    }
}
