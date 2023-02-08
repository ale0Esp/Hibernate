package dao;

import domain.Asignacion;
import java.util.List;
import javax.persistence.*;

public class AsignacionDao extends GenericDao {
    
    public AsignacionDao(){
    }
    
       public List<Asignacion> listar() {
        String hql = "SELECT c FROM Asignacion c";
        eM = getEntityManager();
        Query qy = eM.createQuery(hql);
        return qy.getResultList();
    }

    public void insertar(Asignacion a) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.persist(a);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }

    public void actualizar(Asignacion a) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.merge(a);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }

    public void eliminar(Asignacion a) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.remove(eM.merge(a));
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }

    public Asignacion BuscarById(Asignacion a) {
        eM = getEntityManager();
        return eM.find(Asignacion.class, a.getIdAsignacion());
    }
}
