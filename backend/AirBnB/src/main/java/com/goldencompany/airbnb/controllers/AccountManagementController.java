/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers;

import com.goldencompany.airbnb.controllers.admin.*;
import com.goldencompany.airbnb.dto.input.RegisterDTO;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.RoleMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;

/**
 *
 * @author george
 */
public class AccountManagementController {

    @Inject
    UserRepository userRepository;
    
     @Inject
    UserMapper userMapper;
    

    public List createUser(RegisterDTO dto) throws UserValidationException {
        
        List errors = new ArrayList();
        
        User entity = userMapper.toEntity(dto);
        
        if (!userRepository.findByUserName(entity.getUsername()).isEmpty()) {
            errors.add("username already exists");
        }
        
        if (!userRepository.findByPhone(entity.getPhone()).isEmpty()) {
            errors.add("phone already exists");
        }
        
        if (!errors.isEmpty()) {
            throw new UserValidationException(errors);            
        } else {                                                
            userRepository.create(entity);

            List l = new ArrayList();
            l.add(entity);

            return l;
        }
    }           
}
