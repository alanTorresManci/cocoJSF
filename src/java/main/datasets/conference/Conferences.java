/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.conference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import main.datasets.manager.Managers;

/**
 *
 * @author germanamz
 */
@Entity
@Table(name = "conferences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conferences.findAll", query = "SELECT c FROM Conferences c"),
    @NamedQuery(name = "Conferences.findById", query = "SELECT c FROM Conferences c WHERE c.id = :id"),
    @NamedQuery(name = "Conferences.findByManager", query = "SELECT c FROM Conferences c WHERE c.manager = :manager"),
    @NamedQuery(name = "Conferences.findByName", query = "SELECT c FROM Conferences c WHERE c.name = :name"),
    @NamedQuery(name = "Conferences.findByExhibitor", query = "SELECT c FROM Conferences c WHERE c.exhibitor = :exhibitor"),
    @NamedQuery(name = "Conferences.findByCapacity", query = "SELECT c FROM Conferences c WHERE c.capacity = :capacity"),
    @NamedQuery(name = "Conferences.findByDate", query = "SELECT c FROM Conferences c WHERE c.date = :date"),
    @NamedQuery(name = "Conferences.findByImage", query = "SELECT c FROM Conferences c WHERE c.image = :image"),
    @NamedQuery(name = "Conferences.findByCost", query = "SELECT c FROM Conferences c WHERE c.cost = :cost"),
    @NamedQuery(name = "Conferences.findByRoom", query = "SELECT c FROM Conferences c WHERE c.room = :room")})
public class Conferences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manager")
    private int manager;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "exhibitor")
    private String exhibitor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacity")
    private int capacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "synopsis")
    private String synopsis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private int cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "room")
    private String room;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Managers managers;

    public Conferences() {
    }

    public Conferences(Integer id) {
        this.id = id;
    }

    public Conferences(Integer id, int manager, String name, String exhibitor, int capacity, Date date, String image, String synopsis, int cost, String room) {
        this.id = id;
        this.manager = manager;
        this.name = name;
        this.exhibitor = exhibitor;
        this.capacity = capacity;
        this.date = date;
        this.image = image;
        this.synopsis = synopsis;
        this.cost = cost;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExhibitor() {
        return exhibitor;
    }

    public void setExhibitor(String exhibitor) {
        this.exhibitor = exhibitor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Managers getManagers() {
        return managers;
    }

    public void setManagers(Managers managers) {
        this.managers = managers;
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
        if (!(object instanceof Conferences)) {
            return false;
        }
        Conferences other = (Conferences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.datasets.conference.Conferences[ id=" + id + " ]";
    }
    
    public List<Conferences> getAll(EntityManager em) {
        TypedQuery<Conferences> q = em.createNamedQuery("Conferences.findAll", Conferences.class);
        return q.getResultList();
    }
    
}
