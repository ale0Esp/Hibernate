package dao;

import domain.Domicilio;
import java.util.List;
import javax.persistence.*;

public class DomicilioDao extends GenericDao {

    public DomicilioDao() {
    }

    public List<Domicilio> listar() {
        String hql = "SELECT d FROM Domicilio d";
        eM = getEntityManager();
        Query qy = eM.createQuery(hql);
        return qy.getResultList();
    }

    public void insertar(Domicilio dom) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.persist(dom);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }
    
        public void actualizar(Domicilio dom) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.merge(dom);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }
        
    public void eliminar(Domicilio dom) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.remove(eM.merge(dom));
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }
    
    public Domicilio BuscarById(Domicilio dom){
        eM = getEntityManager();
        return eM.find(Domicilio.class, dom.getIdDomicilio());
    }

}
