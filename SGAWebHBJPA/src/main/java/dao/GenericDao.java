package dao;

import javax.persistence.*;

public abstract class GenericDao {
    
    protected static EntityManager eM;
    private static EntityManagerFactory eMF;
    private static final String PU="HibernateJpaPU";
    
    public GenericDao(){
        if(eMF == null)
            eMF = Persistence.createEntityManagerFactory(PU);
    }
    
    protected EntityManager getEntityManager(){
        if(eM == null)
            eM = eMF.createEntityManager();
        return eM;
    }
    
}
