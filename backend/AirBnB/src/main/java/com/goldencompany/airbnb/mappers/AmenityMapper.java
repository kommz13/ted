/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.RegisterDTO;
import com.goldencompany.airbnb.dto.output.AmenityDTO;
import com.goldencompany.airbnb.entity.Amenity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class AmenityMapper {
     public AmenityDTO toDTO(Amenity entity){
         AmenityDTO dto = new AmenityDTO();
         
         dto.setId(entity.getId());
         dto.setName(entity.getName());
         
         return dto;
     }

    public List<Amenity> toEntities(RegisterDTO dto) {
         List<Amenity> amenityList = new ArrayList();
        
        if (dto.isIs_host()) {
            Amenity r = new Amenity();
            r.setId(1);
            amenityList.add(r);
        }
        
        
        if (dto.isIs_customer()) {
            Amenity r = new Amenity();
            r.setId(2);
            amenityList.add(r);
        }
        
        return amenityList;
        
    }
}
