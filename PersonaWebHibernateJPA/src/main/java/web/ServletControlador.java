package web;

import domain.Persona;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import servicio.ServicioPersonas;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp){
        ServicioPersonas sP= new ServicioPersonas();
        
        List<Persona> personas = sP.listarPersonas();
        
        rq.setAttribute("personas", personas);
        
        try {
            rq.getRequestDispatcher("/WEB-INF/listado.jsp").forward(rq, rp);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
