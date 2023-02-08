package test.ciclovida;

import domain.Contacto;
import javax.persistence.*;

public class EstadoDosRecuperarObjetoPersistente {

    public static void main(String[] args) {

        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager eM = eMF.createEntityManager();

        //Definir var
        Contacto cont = null;
        eM.getTransaction().begin();
        
        //Recuperara objeto
        cont =eM.find(Contacto.class, 3);
        eM.getTransaction().commit();
        
        //detached
        System.out.println(cont);
    }
}
