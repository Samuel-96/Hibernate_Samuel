package com.samuel;

import com.samuel.bidireccional.Astronauta;
import com.samuel.bidireccional.ProgramaEspacial;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * FUNCIONAMIENTO: CLASE MAIN ENCARGADA DE INSTANCIAR OBJETOS ASTRONAUTA y PROGRAMA ESPACIAL
 * CLASES QUE INTERVIENEN: Astronauta y ProgramaEspacial del paquete bidireccional
 * RESULTADO: CREACIÓN DE LA TABLA astronautas y tabla programas_espaciales EN LA BASE DE DATOS
 * RELACIÓN: UNO A MUCHOS BIDIRECCIONAL
 */
public class AppBidirecOneToMany {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        //CREO LOS OBJETOS ASTRONAUTA, QUE ES EL PROPIETARIO DE LA RELACION
        Astronauta a1 = new Astronauta("Buzz Aldrin","Piloto",null);
        Astronauta a2 = new Astronauta("Neil Armstrong","Ingeniero aeronáutico",null);
        Astronauta a3 = new Astronauta("Valentina Tereshkova","Bióloga",null);
        Astronauta a4 = new Astronauta("Pedro Duque","Físico",null);
        List<Astronauta> astronautas1 = new ArrayList<>();
        astronautas1.add(a1);astronautas1.add(a2);astronautas1.add(a3);astronautas1.add(a4);

        Astronauta a5 = new Astronauta("Shannon Lucid","Piloto",null);
        Astronauta a6 = new Astronauta("Johnny Kim","Ingeniero aeroespacial",null);
        Astronauta a7 = new Astronauta("Matthew Dominick","Bióloga",null);
        Astronauta a8 = new Astronauta("Alan Shepard","Químico",null);
        List<Astronauta> astronautas2 = new ArrayList<>();
        astronautas2.add(a5);astronautas2.add(a6);astronautas2.add(a7);astronautas2.add(a8);

        //CREO LOS OBJETOS PROGRAMA_ESPACIAL
        ProgramaEspacial pe1 = new ProgramaEspacial("Sputnik 7",275000000, astronautas1);
        for (Astronauta au : astronautas1)
            au.setProgramaEspacial(pe1);

        ProgramaEspacial pe2 = new ProgramaEspacial("Discovery",550000000, astronautas2);
        for (Astronauta au2 : astronautas2)
            au2.setProgramaEspacial(pe2);

        //PUEDO PERSISTIR EL OBJETO PROGRAMA ESPACIAL Y CON ELLO SE PERSISTIRÍAN TODOS LOS OBJETOS ASTRONAUTA DEBIDO
        //AL CASCADE TYPE.PERSIST
        session.persist(pe1);
        session.persist(pe2);

        /*AUNQUE REALMENTE LO CORRECTO SERÍA PERSISTIR EL OBJETO ASTRONAUTA QUE ES EL DUEÑO DE LA RELACIÓN
          MEDIANTE UN FOREACH QUE VAYA PERSISTIENDO CADA OBJETO, ASÍ;
            for(Astronauta astronauta : astronautas1)
                session.persist(astronauta);*/
        tr.commit();
        session.close();
        System.out.println("\nSe han creado las tablas astronautas y programas_espaciales en la base de datos");
    }
}
