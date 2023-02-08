package test;

import dao.AlumnoDao;
import dao.AsignacionDao;
import dao.ContactoDao;
import dao.CursoDao;
import dao.DomicilioDao;
import java.util.List;

public class TestDaos {
    
    public static void main(String[] args) {
        AlumnoDao alumnoDao = new AlumnoDao();
        System.out.println("alumnoDao = " + alumnoDao);
       // imprimir(alumnoDao.listar());
        
        DomicilioDao domDao = new DomicilioDao();
       // imprimir(domDao.listar());
        
        ContactoDao comDao = new ContactoDao();
        imprimir(comDao.listar());
        
        CursoDao cD = new CursoDao();
        imprimir(cD.listar());
        
        AsignacionDao aD = new AsignacionDao();
        imprimir(aD.listar());

    }
    
    private static void imprimir(List coleccion){
        for(Object o: coleccion){
            System.out.println(o);
        }
    }
}
