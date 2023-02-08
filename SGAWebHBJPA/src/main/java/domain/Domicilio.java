package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Domicilio implements Serializable {
    public static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//BD se encarga de la pk
    @Column(name="id_domicilio")
    private Integer idDomicilio;
    private String calle;
    @Column(name="num_calle")
    private String numCalle;
    private String pais;
    public Domicilio() {
    }
    
    public Domicilio(Integer id) {
        this.idDomicilio = id;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumCalle() {
        return numCalle;
    }

    public void setNumCalle(String numCalle) {
        this.numCalle = numCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", numCalle=" + numCalle + ", pais=" + pais + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idDomicilio);
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
        final Domicilio other = (Domicilio) obj;
        return Objects.equals(this.idDomicilio, other.idDomicilio);
    }
    
    
    
}
