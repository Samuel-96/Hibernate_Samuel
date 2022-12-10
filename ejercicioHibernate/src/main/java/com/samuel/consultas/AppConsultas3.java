package com.samuel.consultas;

import com.samuel.HibernateUtil;
import com.samuel.unidireccional.Barco;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * CLASE MAIN ENCARGADA DE EJECUTAR DIFERENTES CONSULTAS CON LA CLASE CRITERIA BUILDER
 */
public class AppConsultas3 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        int capacidad = 40;
        CriteriaBuilder cb = session.getCriteriaBuilder(); //creo el criteria builder
        CriteriaQuery<Barco> cq = cb.createQuery(Barco.class); //establezco los criterios de la consulta, primero la clase
        Root<Barco> r = cq.from(Barco.class); //root establezco de donde
        cq.where(cb.equal(r.get("capacidad"),capacidad));
        Query <Barco> q = session.createQuery(cq);
        String resultado = q.uniqueResult().getNomBarco();
        System.out.println("El barco con capacidad para 40 marineros es: " + resultado);
    }
}
