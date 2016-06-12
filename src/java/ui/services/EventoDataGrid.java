/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.services;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import package1.Evento;

/**
 *
 * @author germanamz
 */
@ManagedBean
@ViewScoped
public class EventoDataGrid implements Serializable {

    private List<Evento> eventos;
    
    private Evento selected;
    
    @ManagedProperty("#{Evento}")
    private Evento service;
    
    @PostConstruct
    private void init() {
        eventos = service.getEventos();
    }
    
    /**
     * Creates a new instance of EventosDataGrid
     */
    public EventoDataGrid() {
    }
    
     
    
}
