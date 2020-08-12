/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author george
 * 
 */

public class UserRepository {
    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    private EntityManager em;
    
    
    public  List findAll() {
         Query q = em.createNamedQuery("User.findAll");
            List users = q.getResultList();     
            
            return users;
//         TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
//         List<User> results = query.getResultList();
//         return results;
    }

    public List find(Integer id) {
        Query q = em.createNamedQuery("User.findById");
        q.setParameter("id", id);
        
        List users = q.getResultList();     
            
        return users;
    }
    
    
}
