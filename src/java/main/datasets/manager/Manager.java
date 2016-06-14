/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.manager;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author germanamz
 */
@ManagedBean(name = "Manager")
@ApplicationScoped
public class Manager implements Serializable {

    private Object[] managerList;
    
    public EntityManagerFactory emf;
    public EntityManager em;
    
    public Manager() {}
    
    @PostConstruct
    public void init() {
        emf = Persistence.createEntityManagerFactory("cocoJSF");
        em = emf.createEntityManager();
        Managers m = new Managers();
        this.managerList = m.getAll(em);
    }

    public Object[] getManagerList() {
        return managerList;
    }
    
}
