/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alantorres
 */
@Entity
@Table(name = "eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e"),
    @NamedQuery(name = "Eventos.findById", query = "SELECT e FROM Eventos e WHERE e.id = :id"),
    @NamedQuery(name = "Eventos.findByConferencia", query = "SELECT e FROM Eventos e WHERE e.conferencia = :conferencia"),
    @NamedQuery(name = "Eventos.findByExpositor", query = "SELECT e FROM Eventos e WHERE e.expositor = :expositor"),
    @NamedQuery(name = "Eventos.findByCapacidad", query = "SELECT e FROM Eventos e WHERE e.capacidad = :capacidad"),
    @NamedQuery(name = "Eventos.findByActual", query = "SELECT e FROM Eventos e WHERE e.actual = :actual"),
    @NamedQuery(name = "Eventos.findByFecha", query = "SELECT e FROM Eventos e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Eventos.findBySinopsis", query = "SELECT e FROM Eventos e WHERE e.sinopsis = :sinopsis"),
    @NamedQuery(name = "Eventos.findByImagen", query = "SELECT e FROM Eventos e WHERE e.imagen = :imagen"),
    @NamedQuery(name = "Eventos.findByLugar", query = "SELECT e FROM Eventos e WHERE e.lugar = :lugar")})
public class Eventos implements Serializable {

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

    public Eventos() {
    }

    public Eventos(Integer id) {
        this.id = id;
    }

    public Eventos(Integer id, String conferencia, String expositor, int capacidad, int actual, Date fecha, String sinopsis, String imagen, String lugar) {
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
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "package1.Eventos[ id=" + id + " ]";
    }
    
}
