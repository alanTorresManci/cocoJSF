/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.datasets.admin;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author germanamz
 */
@ManagedBean(name = "Admin")
@SessionScoped
public class Admin implements Serializable {

    private String username;
    private String password;
    
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
    
    public String login() {
        return "";
    }
    
}
