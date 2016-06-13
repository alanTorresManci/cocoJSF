/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package package1;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author alantorres
 */
@SessionScoped
@ManagedBean(name = "eventos")
public class EventosController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CocoPU");
    //public EntityManager em = emf.createEntityManager();

    public EventosController() {
    }
    
    //public Collection<Evento> getEventos(){
        //Query query = em.createQuery("SELECT e FROM eventos e");
        //return (Collection<Evento>) query.getResultList();
    //}
    public String getValue(){
        return "data";
        
    }
}

