/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.assistant;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import main.datasets.conference.Conferences;

/**
 *
 * @author germanamz
 */
@Entity
@Table(name = "assistants")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assistants.findAll", query = "SELECT a FROM Assistants a"),
    @NamedQuery(name = "Assistants.findById", query = "SELECT a FROM Assistants a WHERE a.id = :id"),
    @NamedQuery(name = "Assistants.findByConference", query = "SELECT a FROM Assistants a WHERE a.conference = :conference"),
    @NamedQuery(name = "Assistants.findByName", query = "SELECT a FROM Assistants a WHERE a.name = :name")})
public class Assistants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conference")
    private int conference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;

    public Assistants() {
    }

    public Assistants(Integer id) {
        this.id = id;
    }

    public Assistants(Integer id, int conference, String name) {
        this.id = id;
        this.conference = conference;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getConference() {
        return conference;
    }

    public void setConference(int conference) {
        this.conference = conference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        if (!(object instanceof Assistants)) {
            return false;
        }
        Assistants other = (Assistants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.datasets.assistant.Assistants[ id=" + id + " ]";
    }
    
    /**
     *
     * @param em
     * @param conf
     * @return
     */
    public List<Assistants> ofConference(EntityManager em, Conferences conf){
        TypedQuery<Assistants> q = em.createNamedQuery("Assistants.findByConference", Assistants.class);
        q.setParameter("conference", conf.getId());
        List<Assistants> o = q.getResultList();
        System.out.println(o);
        return o;
    }
    
}
