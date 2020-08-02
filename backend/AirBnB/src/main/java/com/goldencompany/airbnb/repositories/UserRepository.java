/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import com.goldencompany.airbnb.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author george
 * 
 */

public class UserRepository {
    private final String SQL_FIND_USER_BY_USERNAME = "SELECT u FROM User u WHERE u.username = ?";
    
    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    EntityManager em;
    
    public User findByUsername(String username) {
        User user = null;
        Query query = em.createQuery(SQL_FIND_USER_BY_USERNAME);
        query.setParameter(1, username);
        List<User> users = query.getResultList();
        
        if (users != null && users.size() > 0) {
            user = users.get(0);
        }
        
        return user;

//        User u =  new User();
//        u.setFirstname("Bob");
//        u.setLastname("bobious");
//        u.setIduser(1);
//        return u;
    }
}
