/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.output.RoleDTO;
import com.goldencompany.airbnb.entity.Role;

/**
 *
 * @author george
 */
public class RoleMapper {
     public RoleDTO toDTO(Role entity){
         RoleDTO dto = new RoleDTO();
         
         dto.setId(entity.getId());
         dto.setName(entity.getName());
         
         return dto;
     }
}
