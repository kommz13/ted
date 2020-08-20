/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import com.goldencompany.airbnb.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author george
 * 
 */

public class MessageRepository {
    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    private EntityManager em;
    

    public List findByUserID(Integer id) {
        Query q = em.createNamedQuery("Message.findByUserId");
        q.setParameter("x", id);
        q.setParameter("y", id);
        
        List users = q.getResultList();     
            
        return users;
    }

    
    
    public List findReceivedByUserID(Integer id) {
        Query q = em.createNamedQuery("Message.findReceivedByUserId");
        q.setParameter("x", id);
        
        List users = q.getResultList();     
            
        return users;
    }
    
}
