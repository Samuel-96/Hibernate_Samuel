package com.samuel;

import com.samuel.manytomany.Autor;
import com.samuel.manytomany.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FUNCIONAMIENTO: CLASE MAIN ENCARGADA DE INSTANCIAR OBJETOS Libro y Autor
 * CLASES QUE INTERVIENEN: Libro y Autor del paquete manytomany
 * RESULTADO: CREACIÓN DE LA TABLA libros, autores y libros_autores EN LA BASE DE DATOS
 * RELACIÓN: MUCHOS A MUCHOS BIDIRECCIONAL
 */
public class AppManyToMany {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        //COMO HE DECIDIDO PROBAR LOS CAMPOS DE TIPO DATE LOS CONFIGURO AQUI
        Date date;
        String fecha = "26-06-2012";

        //CREACION DE LOS OBJETOS LIBRO Y LOS AÑADO A UN LIST
        date = creaFecha(fecha);
        Libro l1 = new Libro("El despertar del leviatán",14.95,date,null);
        fecha = "04-06-2013";
        date = creaFecha(fecha);
        Libro l2 = new Libro("La guerra de Calibán",14.95,date,null);
        fecha = "05-06-2014";
        date = creaFecha(fecha);
        Libro l3 = new Libro("La puerta de Abadón",24.95,date,null);
        fecha = "15-06-2015";
        date = creaFecha(fecha);
        Libro l4 = new Libro("La quema de Cíbola",24.95,date,null);
        fecha = "22-06-2016";
        date = creaFecha(fecha);
        Libro l5 = new Libro("Los juegos de Némesis",27.95,date,null);
        fecha = "29-06-2017";
        date = creaFecha(fecha);
        Libro l6 = new Libro("Las cenizas de Babilonia",27.95,date,null);
        fecha = "04-06-2018";
        date = creaFecha(fecha);
        Libro l7 = new Libro("El alzamiento de Persépolis",29.95,date,null);
        List<Libro> libros = new ArrayList<>();
        libros.add(l1);libros.add(l2);libros.add(l3);libros.add(l4);libros.add(l5);libros.add(l6);libros.add(l7);

        //CREACION DE LOS OBJETOS AUTOR Y LOS AÑADO A UN LIST
        Autor a1 = new Autor("Daniel Abraham","Estados Unidos",libros);
        Autor a2 = new Autor("Ty Franck","Estados Unidos",libros);
        List<Autor> autoresExpanse = new ArrayList<>();
        autoresExpanse.add(a1); autoresExpanse.add(a2);

        //SETEO LOS AUTORES A LOS LIBROS
        for (Libro l : libros)
            l.setAutores(autoresExpanse);

        session.persist(a1);
        tr.commit();
        session.close();
        System.out.println("Se han creado las tablas autores, libros y libros_autores en la Base de datos");
    }

    //METODO PARA INSTANCIAR CON COMODIDAD LA FECHA PARA CADA LIBRO
    public static Date creaFecha(String fecha)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            return date = formatter.parse(fecha);
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
