/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.output.TypeDTO;
import com.goldencompany.airbnb.entity.Type;

/**
 *
 * @author george
 */
public class TypeMapper {
     public TypeDTO toDTO(Type entity){
         TypeDTO dto = new TypeDTO();
         
         dto.setId(entity.getId());
         dto.setName(entity.getName());
         
         return dto;
     }
}
