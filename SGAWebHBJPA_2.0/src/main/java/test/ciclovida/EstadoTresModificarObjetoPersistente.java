package test.ciclovida;

import domain.Contacto;
import javax.persistence.*;

public class EstadoTresModificarObjetoPersistente {
    public static void main(String[] args) {
         EntityManagerFactory eMF = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager eM = eMF.createEntityManager();

        //Definir var
        Contacto cont = null;
        
        //Recuperara objeto
        //1. transitivo
        cont =eM.find(Contacto.class, 3);
        
        // modificamos objeto
        cont.setEmail("al@mail.com");
        eM.getTransaction().begin();
        
        //2. persistente
        //eM.persist(cont); ejecuto update
        eM.merge(cont);
        eM.getTransaction().commit();
        
        //3. detached
        System.out.println(cont);
    }
}
