package dao;

import domain.Curso;
import java.util.List;
import javax.persistence.*;

public class CursoDao extends GenericDao{
    
    
    public CursoDao(){
    }
    
    public List<Curso> listar() {
        String hql = "SELECT c FROM Curso c";
        eM = getEntityManager();
        Query qy = eM.createQuery(hql);
        return qy.getResultList();
    }

    public void insertar(Curso c) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.persist(c);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }
    
        public void actualizar(Curso c) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.merge(c);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }
        
    public void eliminar(Curso c) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.remove(eM.merge(c));
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            eM.close();
        }
    }
    
    public Curso BuscarById(Curso c){
        eM = getEntityManager();
        return eM.find(Curso.class, c.getCurso());
    }
    
}
