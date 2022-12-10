package com.samuel.consultas;

import com.samuel.HibernateUtil;
import com.samuel.single.Bicicleta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * CLASE MAIN ENCARGADA DE EJECUTAR DIFERENTES OPERACIONES CON LAS CLÁUSULAS UPDATE, DELETE E INSERT INTO
 */
public class AppConsultas2 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        //COMMIT NECESARIO PUESTO QUE ESTAMOS MODIFICANDO LA ESTRUCTURA DE LA BASE DE DATOS
        Transaction tr = session.beginTransaction();

        //EJEMPLOS CON LA CLÁUSULA UPDATE
        String marca = "Nice";
        Query q1 = session.createQuery("UPDATE Bicicleta B SET B.marca = :marca WHERE LOWER(B.marca) LIKE 'niceyy'");
        q1.setParameter("marca",marca);
        q1.executeUpdate();

        //MODIFICO EL PRECIO DE LOS LIBROS QUE CUESTAN MAS DE 20 EUROS A LA MITAD
        Query q2 = session.createQuery("UPDATE Libro L SET L.precio = L.precio*0.5 WHERE L.precio > 20");
        q2.executeUpdate();

        //EJEMPLOS CON LA CLÁUSULA DELETE
        int idBici = 2;
        Query q3 = session.createQuery("DELETE FROM Bicicleta B WHERE B.id = :id");
        q3.setParameter("id",idBici);
        q3.executeUpdate();


        //EJEMPLOS CON LA CLÁUSULA INSERT INTO
        Query q4 = session.createQuery("INSERT INTO Bicicleta (marca,nRuedas) SELECT :marca, :nRuedas FROM Bicicleta WHERE id = 1");
        q4.setParameter("marca","Decathlon");
        q4.setParameter("nRuedas",4);
        q4.executeUpdate();

        //commit para confirmar todas las operaciones
        tr.commit();
        System.out.println("Nombre de la marca de bicicleta Niceyy cambiado a Nice");
        System.out.println("Todos los libros cuyo precio es superior a 20 euros han sido actualizados, ahora cuestan la mitad");
        System.out.println("Eliminada la bicicleta de marca Xich Lo");
        System.out.println("Insertada una nueva bicicleta ");
        session.close();
    }
}
