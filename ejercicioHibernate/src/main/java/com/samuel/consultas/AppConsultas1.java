package com.samuel.consultas;

import com.samuel.HibernateUtil;
import com.samuel.manytomany.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * CLASE MAIN ENCARGADA DE EJECUTAR DIFERENTES CONSULTAS
 */
public class AppConsultas1
{
    public static void main(String[] args)
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        //1. CONSULTA EN LA QUE ME QUEDO CON TODA LA INFORMACION DE TODOS LOS LIBROS ADEMÁS DE LOS AUTORES QUE LOS HAN ESCRITO
        Query<Libro> q1 = session.createQuery("FROM Libro",Libro.class);
        List<Libro> libros = q1.list();
        System.out.println("\nInformación de todos los libros: ");
        for(Libro l : libros)
        {
            System.out.println();
            System.out.println("ID: " + l.getId() + "\nTitulo: " + l.getTitulo() + "\nPrecio: " + l.getPrecio() + "\nFecha: " + l.getFecha() + "\nAutores: " + l.getAutores().get(0).getNombre() + " y " + l.getAutores().get(1).getNombre());
        }
        System.out.println("----------------------------------------------------------------------------------");

        //2. CONSULTA QUE ME DIGA EL TITULO DE LOS LIBROS CUYO PRECIO SUPERA LOS 25 EUROS
        Query<String> q2 = session.createQuery("SELECT L.titulo FROM Libro L WHERE L.precio > 25",String.class);
        List<String> titulos = q2.list();
        System.out.println("\nLibros cuyo precio supera los 25 euros: ");
        for(String titulo : titulos)
            System.out.println(titulo);
        System.out.println("----------------------------------------------------------------------------------");

        //3. CONSULTA QUE ME DIGA ÚNICAMENTE LAS BICICLETAS QUE TIENEN UN CARACTER 'a' EN SU MARCA
        Query<String> q3 = session.createQuery("SELECT B.marca FROM Bicicleta B WHERE B.marca LIKE '%a%'",String.class);
        List<String> marcas = q3.list();
        System.out.println("\nBicicletas con el caracter 'a' en la marca: ");
        for(String marca : marcas)
            System.out.println(marca);

        System.out.println("----------------------------------------------------------------------------------");
        //4. CONSULTA QUE ME DIGA EL NUMERO DE ASTRONATUAS QUE PARTICIPARON EN EL PROYECTO ESPACIAL 2 (Discovery)
        Query<Long> q4 = session.createQuery("SELECT COUNT(A.id) FROM Astronauta A, ProgramaEspacial P WHERE A.programaEspacial.id = 2 AND P.id = 2",Long.class);
        long resultado = q4.uniqueResult();
        System.out.println("Número de astronautas que participaron en el programa espacial Discovery: " + resultado);
    }
}
