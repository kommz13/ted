/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers.admin;

import com.goldencompany.airbnb.dto.RoleDTO;
import com.goldencompany.airbnb.dto.UserDTO;
import com.goldencompany.airbnb.entity.Role;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.mappers.RoleMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.ArrayList;
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
    
    @Inject
    UserMapper userMapper;
    
    @Inject
    RoleMapper roleMapper;
    
     
    public List retrieveUsers() {
        List<User> users = userRepository.findAll();
        
        List dtos = userMapper.toDTO(users);
        
        return dtos;
    }

    public List retrieveUserByID(Integer id) {
        List<User> users = userRepository.find(id);
        
        List dtos = userMapper.toDTO(users);
        
        return dtos;        
    }

    public List retrieveActiveUsers() {
        List<User> users = userRepository.findActive();
        
        List dtos = userMapper.toDTO(users);
        
        return dtos;
    }

    public List retrieveInactiveUsers() {
        List<User> users = userRepository.findInactive();
        
        List dtos = userMapper.toDTO(users);
        
        return dtos;
    }
    
}
