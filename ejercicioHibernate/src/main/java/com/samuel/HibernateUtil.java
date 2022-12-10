package com.samuel;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    //ATRIBUTO ESTÁTICO DE SF
    private static SessionFactory sf;
    //CONSTRUCTOR SIN PARÁMETROS PRIVADO PARA EVITAR QUE SE INSTANCIE LA CLASE
    private HibernateUtil(){

    }
    //GETTER DEL ATRIBUTO SESSIONFACTORY
    public static SessionFactory getSessionFactory()
    {
        //SI NO HAY UN SESSIONFACTORY, LO CREO
        if (sf == null)
        {
            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        }
        //SI HAY UN SESSIONFACTORY LO DEVUELVO
        return sf;
    }

}
