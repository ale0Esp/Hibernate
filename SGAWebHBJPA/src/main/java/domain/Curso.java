package domain;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Curso implements Serializable{
    public static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//BD se encarga de la pk
    @Column(name="id_curso")
    private Integer idcurso;
    private String nombre;
    private Double precio;

    @OneToMany(mappedBy = "curso")
    private List<Asignacion> asignaciones;
     
    public Curso() {
    }

    public Curso(Integer curso) {
        this.idcurso = curso;
    }

    public Integer getCurso() {
        return idcurso;
    }

    public void setCurso(Integer curso) {
        this.idcurso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
    

    @Override
    public String toString() {
        return "Curso{" + "curso=" + idcurso + ", nombre=" + nombre + ", precio=" + precio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idcurso);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        return Objects.equals(this.idcurso, other.idcurso);
    }
    
    
}
