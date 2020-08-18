/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.RoleDTO;
import com.goldencompany.airbnb.dto.UserDTO;
import com.goldencompany.airbnb.entity.Role;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
                                       

public class UserMapper {
    @Inject
    RoleMapper roleMapper;
    
    public UserDTO toDTO(User entity){
        UserDTO dto = new UserDTO();
        
        dto.setId(entity.getId());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setUsername(entity.getUsername());
        dto.setPhotoUrl(entity.getPhotoUrl());
        dto.setRegistrationDate(entity.getRegistrationDate());
        dto.setBirthdate(entity.getBirthdate());
        if (entity.getRegistrationStatus()== 0){
            dto.setRegistrationStatus("inactive");
        }else{
            dto.setRegistrationStatus("active");
        }
        dto.setActive(entity.getActive());
                        
        return dto;
    }
    
    public List toDTO(List<User> entities) {
        List list = new ArrayList();
        
        for (User entity : entities) {
            UserDTO userdto = toDTO(entity);                        
            
            for (Role roleEntity : entity.getRoleList()) {
                RoleDTO roledto = roleMapper.toDTO(roleEntity);
                userdto.getRoles().add(roledto);
            }
                                    
            list.add(userdto);
        }        
     
        return list;
    }
    
}
