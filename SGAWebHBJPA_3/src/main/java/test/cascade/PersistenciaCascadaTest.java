package test.cascade;

import domain.*;
import javax.persistence.*;

public class PersistenciaCascadaTest {
    public static void main(String[] args) {
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager eM = eMF.createEntityManager();
        Domicilio dom = new Domicilio();
        dom.setCalle("emiliano");
        dom.setNumCalle("8");
        dom.setPais("Mexico");
        Contacto cont = new Contacto();
        cont.setEmail("ale_12@mail.com");
        cont.setTelefono("56565656");
        Alumno al = new Alumno();
        al.setNombre("Aleandro");
        al.setApellido("Espino");
        al.setContacto(cont);
        al.setDomicilio(dom);
        
        eM.getTransaction().begin();
        eM.persist(al);
        eM.getTransaction().commit();
        
        System.out.println(al);
    }
}
