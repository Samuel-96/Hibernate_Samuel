package com.samuel;

import com.samuel.single.Bicicleta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * FUNCIONAMIENTO: CLASE MAIN ENCARGADA DE INSTANCIAR EL OBJETO BICICLETA Y PERSISTIRLO EN LA BASE DE DATOS
 * CLASES QUE INTERVIENEN:
 * RESULTADO: CREACIÓN DE LA TABLA BICICLETAS EN LA BASE DE DATOS
 */
public class AppSingle {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        //siempre crea una nueva sesion con el metodo openSession, getCurrentSession sólo crea una nueva si no hay ninguna en el contexto actual
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        //INSTANCIO VARIOS OBJETOS BICILETA, EL ÚLTIMO PARÁMETRO DE DETALLES NO APARECERÁ EN LA BD
        Bicicleta b1 = new Bicicleta("Orbea",2,"Bicicleta preparada para su uso en montaña");
        Bicicleta b2 = new Bicicleta("Xich Lo",4,"Bicicleta de cuatro ruedas");
        Bicicleta b3 = new Bicicleta("Anakon",2,"");
        Bicicleta b4 = new Bicicleta("Kaibrite",2,"Bicicleta infantil");
        Bicicleta b5 = new Bicicleta("Niceyy",3,"Triciclo");

        //LOS DEJO EN EL ÁREA DE PERSISTENCIA MEDIANTE PERSIST
        session.persist(b1); session.persist(b2); session.persist(b3); session.persist(b4); session.persist(b5);
        //CONFIRMO LOS CAMBIOS Y LOS COMMITEO EN LA BASE DE DATOS
        tr.commit();
        //Y CIERRO LA SESION
        session.close();
        System.out.println("\nSe ha creado la tabla bicicletas en la base de datos");
    }
}
