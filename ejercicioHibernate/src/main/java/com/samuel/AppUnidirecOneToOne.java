package com.samuel;

import com.samuel.HibernateUtil;
import com.samuel.unidireccional.Barco;
import com.samuel.unidireccional.Capitan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * FUNCIONAMIENTO: CLASE MAIN ENCARGADA DE INSTANCIAR OBJETO CAPITAN Y BARCO
 * CLASES QUE INTERVIENEN: Capitan y Barco del paquete unidireccional
 * RELACIÓN: UNO A UNO UNIDIRECCIONAL
 * RESULTADO: CREACIÓN DE LA TABLA capitanes y tabla barcos EN LA BASE DE DATOS
 */
public class AppUnidirecOneToOne {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        //CREACIÓN DE OBJETO CAPITAN, DUEÑO DE LA RELACION
        Capitan c1 = new Capitan("Kennit Ludoventura",null);
        Capitan c2 = new Capitan("Althea Vestrit",null);
        Capitan c3 = new Capitan("Brashen Trell",null);
        Capitan c4 = new Capitan("Rojo",null);

        //CREACION DE LOS OBJETOS BARCO Y LOS PERTIENTES SETTERS
        Barco b1 = new Barco("Marietta",1650,38);
        Barco b2 = new Barco("Vivacia",1628,35);
        Barco b3 = new Barco("Dechado",1690,29);
        Barco b4 = new Barco("Multicolora",1710,40);
        c1.setBarco(b1);c2.setBarco(b2);c3.setBarco(b3);c4.setBarco(b4);

        //OPERACIONES NECESARIAS PARA PERSISTIR EN LA BD. PERSISTO AL CAPITAN PUESTO QUE ES DUEÑO DE RELACION
        session.persist(c1);
        session.persist(c2);
        session.persist(c3);
        session.persist(c4);

        tr.commit();
        session.close();

        System.out.println("\nSe han creado las tablas capitanes y barcos en la BD");
    }
}
