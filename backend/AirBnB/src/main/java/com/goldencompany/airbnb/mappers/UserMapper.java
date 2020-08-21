/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.RegisterDTO;
import com.goldencompany.airbnb.dto.output.RoleDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.entity.Role;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
import java.util.Date;
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
    
    public User toEntity(RegisterDTO dto) {
        User entity = new User();
        
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setUsername(dto.getUsername());
        entity.setPhotoUrl(dto.getPhotoUrl());
        entity.setRegistrationDate(new Date());
        entity.setBirthdate(dto.getBirthdate());
        entity.setActive(1);
        entity.setRegistrationStatus(0);
        
        List<Role> roleList = new ArrayList();
        
        if (dto.isIs_host()) {
            Role r = new Role();
            r.setId(1);
            roleList.add(r);
        }
        
        
        if (dto.isIs_customer()) {
            Role r = new Role();
            r.setId(2);
            roleList.add(r);
        }
        
        entity.setRoleList(roleList);
        
        
        
        return entity;
    }
}
