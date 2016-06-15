/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.admin;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 *
 * 
 * 
 * @author germanamz
 */
@ManagedBean(name = "Admin")
@SessionScoped
public class Admin implements Serializable {
    
    private int id;
    private String username;
    private String password;
    
    public EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("cocoJSF");
    public EntityManager em = emf.createEntityManager();
    
    public Admin() {
        
    }

    /*
    Getters & Setters
    */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /*
    Pubic functions
    */
    public Object[] administradores(){
        Admins admins = new Admins();
        return admins.admin(em);
    }
            
    public String login() {
        Admins admins = new Admins();
        
        int result = admins.findByAll(this.username, this.password, em);
        if(result == 1)
        {
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
        else
            System.out.println("no");
        return "";
    }
    
}
