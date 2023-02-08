package test;

import domain.Persona;
import jakarta.persistence.*;
import java.util.List;

public class HelloWorldHibernate {
    public static void main(String[] args) {
        //ejecuta querys por medio dee hibernate query languaje
        String hql="SELECT p FROM Persona p";
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager eM = fabrica.createEntityManager();
        
        Query q = eM.createQuery(hql);
        List<Persona> personas = q.getResultList();
        for(Persona p: personas){
            System.out.println("Persoha" + p);
        }
    }
    
}
