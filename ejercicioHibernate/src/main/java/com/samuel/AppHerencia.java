package com.samuel;

import com.samuel.herencia.Cirujano;
import com.samuel.herencia.Medico;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * FUNCIONAMIENTO: CLASE MAIN ENCARGADA DE INSTANCIAR OBJETOS Cirujano que heredan de Medico
 * CLASES QUE INTERVIENEN: Cirujano y Medico del paquete herencia
 * RESULTADO: CREACIÓN DE LA TABLA ÚNICA medicos
 * RELACIÓN: HERENCIA
 */
public class AppHerencia {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Medico m1 = new Medico("Jesus San Miguel");
        Cirujano c1 = new Cirujano("Juan Luis Morales","cirujano");
        session.persist(m1);
        session.persist(c1);
        tr.commit();
        session.close();
    }
}
