/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.conference;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    private String date;
    private String image;
    private String synopsis;
    private int cost;
    private String room;
    
    public EntityManagerFactory emf;
    public EntityManager em;
    
    public Conference() {
    }
    
    @PostConstruct
    public void init() {
        emf = Persistence.createEntityManagerFactory("cocoJSF");
        em = emf.createEntityManager();
    }
    
    public void storeConference(){
        Conferences conferences = new Conferences();
        conferences.store(em, name, exhibitor, capacity, date, synopsis, cost, room);
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
    public List<Conferences> getConferences()
    {
        Conferences conferences = new Conferences();
        return conferences.getAll(em);
    }
    
}
