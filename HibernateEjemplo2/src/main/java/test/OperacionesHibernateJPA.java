package test;

import dao.PersonaDAO;
import domain.Persona;

public class OperacionesHibernateJPA {
    public static void main(String[] args) {
        PersonaDAO pdao = new PersonaDAO();
        pdao.listar();
        
        Persona p = new Persona();
        p.setIdPersona(3);
        
        p = pdao.buscarPersonabyID(p);
        System.out.println("p = " + p);
        
//        p.setNombre("ale");
//        p.setApellido("esp");
//        p.setEmail("aEsp@mail.com");
//        p.setTelefono("565656556");

//        pdao.insertar(p);
//        pdao.modificar(p);
//        pdao.eliminar(p);
        pdao.listar();
    }
    
}
