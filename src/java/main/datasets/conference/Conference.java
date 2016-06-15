/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.conference;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import main.datasets.assistant.Assistants;

/**
 *
 * @author germanamz
 */
@ManagedBean(name = "Conference")
@ApplicationScoped
public class Conference implements Serializable {

    private int id;
    private int manager;
    private String name;
    private String exhibitor;
    private int capacity;
    private Date date;
    private String image;
    private String synopsis;
    private int cost;
    private String room;
    
    private Conferences current;
    
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("cocoPU");
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRoom() {
        return room;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }
    
    public void storeConference(){
        Conferences conferences = new Conferences();
        conferences.store(em, manager, name, exhibitor, capacity, date, synopsis, cost, room);
        ExternalContext ec = FacesContext.getCurrentInstance()
                    .getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath()
                        + "/faces/index.xhtml");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
    
    public List<Conferences> getConferences() {
        Conferences conferences = new Conferences();
        return conferences.getAll(em);
    }
    
    public void setRoom(String room) {
        this.room = room;
    }

    public Conferences getCurrent() {
        return current;
    }

    public void setCurrent(Conferences current) {
        this.current = current;
    }
    
    public List<Assistants> getCurrentAssistants() {
        return current.getAssistants(em);
    }
    
}
