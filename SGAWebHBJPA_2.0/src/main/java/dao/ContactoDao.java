package dao;

import java.util.List;
import domain.Contacto;
import javax.persistence.*;

public class ContactoDao extends GenericDao {

    public ContactoDao() {
    }

    public List<Contacto> listar() {
        String hql = "SELECT c FROM Contacto c";
        eM = getEntityManager();
        Query qy = eM.createQuery(hql);
        return qy.getResultList();
    }

    public void insertar(Contacto con) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.persist(con);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }

    public void actualizar(Contacto con) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.merge(con);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }

    public void eliminar(Contacto con) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.remove(eM.merge(con));
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }

    public Contacto BuscarById(Contacto con) {
        eM = getEntityManager();
        return eM.find(Contacto.class, con.getContacto());
    }
}
