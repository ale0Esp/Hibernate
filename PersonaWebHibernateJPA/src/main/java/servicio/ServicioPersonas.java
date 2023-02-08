package servicio;

import dao.PersonaDAO;
import domain.Persona;
import java.util.List;

public class ServicioPersonas {
    
    private PersonaDAO pDao;

    public ServicioPersonas( ){
        this.pDao = new PersonaDAO();
    }
    
    public List<Persona> listarPersonas(){
        return this.pDao.listar();
    }
}
