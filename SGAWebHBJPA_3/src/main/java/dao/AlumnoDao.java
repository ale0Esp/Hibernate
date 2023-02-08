package dao;

import domain.Alumno;
import java.util.List;
import javax.persistence.*;

public class AlumnoDao extends GenericDao {
    
    public AlumnoDao(){
    }
    
      public List<Alumno> listar() {
        String hql = "SELECT c FROM Alumno c";
        eM = getEntityManager();
        Query qy = eM.createQuery(hql);
        return qy.getResultList();
    }

    public void insertar(Alumno a) {
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

    public void actualizar(Alumno a) {
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

    public void eliminar(Alumno a) {
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

    public Alumno BuscarById(Alumno a) {
        eM = getEntityManager();
        return eM.find(Alumno.class, a.getIdAlumno());
    }
}
