/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.conference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author germanamz
 */
@ManagedBean(name = "Conference")
@ApplicationScoped
public class Conference implements Serializable {

    private int id;
    private String name;
    private String exhibitor;
    private int capacity;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String image;
    private String synopsis;
    private int value;
    private String room;
    
    public EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("CocoPU");
    public EntityManager em = emf.createEntityManager();
    
    public Conference() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRoom() {
        return room;
    }
    
    public List<Conferences> getConferences()
    {
        Conferences conferences = new Conferences();
        return conferences.getAll(em);
    }
    
    public void setRoom(String room) {
        this.room = room;
    }
    
    
    
}
