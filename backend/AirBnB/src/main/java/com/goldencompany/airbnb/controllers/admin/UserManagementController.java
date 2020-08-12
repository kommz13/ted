/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers.admin;

import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author george
 */
public class UserManagementController {

    @Inject
    UserRepository userRepository;
     
    public List retrieveUsers() {
        return userRepository.findAll();
    }

    public List retrieveUserByID(Integer id) {
        return userRepository.find(id);
    }
    
}
