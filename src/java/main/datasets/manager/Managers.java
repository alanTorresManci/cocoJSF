/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.manager;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author germanamz
 */
@Entity
@Table(name = "managers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Managers.findAll", query = "SELECT m FROM Managers m"),
    @NamedQuery(name = "Managers.findById", query = "SELECT m FROM Managers m WHERE m.id = :id"),
    @NamedQuery(name = "Managers.findByName", query = "SELECT m FROM Managers m WHERE m.name = :name")})
public class Managers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private int name;

    public Managers() {
    }

    public Managers(Integer id) {
        this.id = id;
    }

    public Managers(Integer id, int name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
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
        if (!(object instanceof Managers)) {
            return false;
        }
        Managers other = (Managers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.datasets.manager.Managers[ id=" + id + " ]";
    }
    
    public Object[] getAll(EntityManager em) {
        TypedQuery<Managers> query =
            em.createNamedQuery("Admins.findAll", Managers.class);
        
        return query.getResultList().toArray();
    }
    
}
