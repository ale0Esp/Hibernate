package test.ciclovida;

import domain.Contacto;
import javax.persistence.*;

public class EstadoCuatroEliminarObjeto {

    public static void main(String[] args) {
        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager eM = eMF.createEntityManager();

        //Definir var
        Contacto cont = null;

        //Recuperara objeto
        //1. transitivo
        cont = eM.find(Contacto.class, 3);
        eM.getTransaction().begin();

        //3. remove
        eM.remove(eM.merge(cont));
        eM.getTransaction().commit();

        //3. transitivo
        System.out.println(cont);//no esta en la bd solo en memoria 
    }
}
