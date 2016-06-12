/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alantorres
 */
@SessionScoped
@ManagedBean(name = "eventos")
@Entity
@Table(name = "eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM eventos e"),
    @NamedQuery(name = "Evento.findById", query = "SELECT e FROM eventos e WHERE e.id = :id"),
    @NamedQuery(name = "Evento.findByConferencia", query = "SELECT e FROM eventos e WHERE e.conferencia = :conferencia"),
    @NamedQuery(name = "Evento.findByExpositor", query = "SELECT e FROM eventos e WHERE e.expositor = :expositor"),
    @NamedQuery(name = "Evento.findByCapacidad", query = "SELECT e FROM eventos e WHERE e.capacidad = :capacidad"),
    @NamedQuery(name = "Evento.findByActual", query = "SELECT e FROM eventos e WHERE e.actual = :actual"),
    @NamedQuery(name = "Evento.findByFecha", query = "SELECT e FROM eventos e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Evento.findBySinopsis", query = "SELECT e FROM eventos e WHERE e.sinopsis = :sinopsis"),
    @NamedQuery(name = "Evento.findByImagen", query = "SELECT e FROM eventos e WHERE e.imagen = :imagen"),
    @NamedQuery(name = "Evento.findByLugar", query = "SELECT e FROM eventos e WHERE e.lugar = :lugar")})
public class Evento implements Serializable {
    // EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eventos");
    // EntityManager em = emf.createEntityManager();
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "conferencia")
    private String conferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "expositor")
    private String expositor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private int capacidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actual")
    private int actual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sinopsis")
    private String sinopsis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lugar")
    private String lugar;
   
    private static final String PERSISTENCE_UNIT_NAME = "CocoPU";
EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = emf.createEntityManager();
   
    public Evento(){
        
    }
    
    public String getValue(){
        return "hola";
    }
    
    public String getEventos(){
        
        return "";
    }
    
    
    public Evento(Integer id) {
        this.id = id;
    }

    public Evento(Integer id, String conferencia, String expositor, int capacidad, int actual, Date fecha, String sinopsis, String imagen, String lugar) {
        this.id = id;
        this.conferencia = conferencia;
        this.expositor = expositor;
        this.capacidad = capacidad;
        this.actual = actual;
        this.fecha = fecha;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
        this.lugar = lugar;
    }

    public Integer getId() {
        return id;
    }
    public void texto(){
        System.out.println("hola");
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public String getExpositor() {
        return expositor;
    }

    public void setExpositor(String expositor) {
        this.expositor = expositor;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "package1.Evento[ id=" + id + " ]";
    }
    
}
