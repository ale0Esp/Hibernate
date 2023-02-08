package test.ciclovida;

import domain.Contacto;
import javax.persistence.*;

public class EstadoUnoPersistido {
    public static void main(String[] args) {
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager eM = eMF.createEntityManager();
        
        //1. estado transitivo
        Contacto con = new Contacto();
        con.setEmail("ale@mail.com");
        con.setTelefono("56177111");
        
        //2. estado Persistente
        eM.getTransaction().begin();
        eM.persist(con);
        //eM.flush();//Sincroniza lo pendiente en la BD, no hace commit
        eM.getTransaction().commit();
        
        //3. estado ditached
        System.out.println(con);
        
    }
}
