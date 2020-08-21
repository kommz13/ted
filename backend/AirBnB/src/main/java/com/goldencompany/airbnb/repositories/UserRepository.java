/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import com.goldencompany.airbnb.entity.Role;
import com.goldencompany.airbnb.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author george
 * 
 */
@Stateless
public class UserRepository {
    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    private EntityManager em;
    
    
    public List<User> findAll() {
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

    public List<User> findActive() {
         Query q = em.createNamedQuery("User.findByActive");
        q.setParameter("active", 1);
        
        List users = q.getResultList();     
            
        return users;
    }

    public List<User> findInactive() {
        Query q = em.createNamedQuery("User.findByActive");
        q.setParameter("active", 0);
        
        List users = q.getResultList();     
            
        return users;
    }

    public void create(User entity) {
        em.persist(entity);//insert
        
//        for (Role r : entity.getRoleList()) {
//            
//        }
//        em.persist(entity.getRoleList());

// ####
    }

    public List<User> findByUserName(String username) {
        Query q = em.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);
        
        List users = q.getResultList();     
            
        return users;
    }

    public List<User> findByPhone(String phone) {
        Query q = em.createNamedQuery("User.findByPhone");
        q.setParameter("phone", phone);
                
        List users = q.getResultList();     
            
        return users;
    }    
    
}
