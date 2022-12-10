package com.samuel;

import com.samuel.HibernateUtil;
import com.samuel.herencia.Soldado;
import com.samuel.herencia.SoldadoInfanteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 * FUNCIONAMIENTO: CLASE MAIN ENCARGADA DE INSTANCIAR OBJETOS SoldadoInfanteria que hereda de Soldado
 * CLASES QUE INTERVIENEN: Soldado y Cirujano del paquete herencia
 * RESULTADO: CREACIÓN DE LAS TABLAS soldadoinfanteria y soldado
 * RELACIÓN: HERENCIA
 */
public class AppHerenciaJoin {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Soldado s = new Soldado("Hugh dowding");
        SoldadoInfanteria s1 = new SoldadoInfanteria("Erwin rommel","Primera división");

        session.persist(s);
        session.persist(s1);
        tr.commit();
        session.close();

    }
}
