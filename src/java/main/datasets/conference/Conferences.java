/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.conference;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author germanamz
 */
@Entity
@Table(name = "conferences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conferences.findAll", query = "SELECT c FROM Conferences c"),
    @NamedQuery(name = "Conferences.findById", query = "SELECT c FROM Conferences c WHERE c.id = :id"),
    @NamedQuery(name = "Conferences.findByName", query = "SELECT c FROM Conferences c WHERE c.name = :name"),
    @NamedQuery(name = "Conferences.findByExhibitor", query = "SELECT c FROM Conferences c WHERE c.exhibitor = :exhibitor"),
    @NamedQuery(name = "Conferences.findByCapacity", query = "SELECT c FROM Conferences c WHERE c.capacity = :capacity"),
    @NamedQuery(name = "Conferences.findByDate", query = "SELECT c FROM Conferences c WHERE c.date = :date"),
    @NamedQuery(name = "Conferences.findByImage", query = "SELECT c FROM Conferences c WHERE c.image = :image"),
    @NamedQuery(name = "Conferences.findByValue", query = "SELECT c FROM Conferences c WHERE c.value = :value"),
    @NamedQuery(name = "Conferences.findByRoom", query = "SELECT c FROM Conferences c WHERE c.room = :room")})
public class Conferences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "image")
    private int image;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "synopsis")
    private String synopsis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private int value;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "room")
    private String room;

    public Conferences() {
    }

    public Conferences(Long id) {
        this.id = id;
    }

    public Conferences(Long id, String name, String exhibitor, int capacity, Date date, int image, String synopsis, int value, String room) {
        this.id = id;
        this.name = name;
        this.exhibitor = exhibitor;
        this.capacity = capacity;
        this.date = date;
        this.image = image;
        this.synopsis = synopsis;
        this.value = value;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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
    
}
