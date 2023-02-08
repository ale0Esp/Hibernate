package dao;

import domain.Persona;
import javax.persistence.*;
import java.util.List;

public class PersonaDAO {

    private EntityManagerFactory emf;
    private EntityManager eM;

    public PersonaDAO() {
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        eM = emf.createEntityManager();
    }

    public List<Persona> listar() {
        String hql = "SELECT p FROM Persona p";
        Query qy = eM.createQuery(hql);
        List<Persona> personas = qy.getResultList();
//        for (Persona p : personas) {
//            System.out.println("personas = " + p);
//        }
        return personas;
    }
    
    public void insertar(Persona persona){
        try{
        eM.getTransaction().begin();
        eM.persist(persona);//persiste
        eM.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            eM.getTransaction().rollback();
        }finally{
            if(eM != null)
                eM.close();
        }
    }
    
    public Persona buscarPersonabyID(Persona p){
        return eM.find(Persona.class, p.getIdPersona());
    }
    
    public void modificar(Persona persona){
        try{
        eM.getTransaction().begin();
        eM.merge(persona);//actualiza
        eM.getTransaction().commit();
            System.out.println("modificar");
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            eM.getTransaction().rollback();
        }
//        finally{
//            if(eM != null)
//                eM.close();
//        }
    }
    
    public void eliminar(Persona p){
        try{
        eM.getTransaction().begin();
        eM.remove(eM.merge(p));// sincroniza y elimina
        eM.getTransaction().commit();
            System.out.println("modificar");
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            eM.getTransaction().rollback();
        }
    }
    
}
