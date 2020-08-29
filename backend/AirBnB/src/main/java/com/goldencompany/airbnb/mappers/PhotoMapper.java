/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.output.PhotoDTO;
import com.goldencompany.airbnb.entity.Photo;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class PhotoMapper {

//    @Inject
//    UserMapper userMapper;
//    
    @Inject 
    ListingMapper listingMapper;

    public PhotoDTO toDTO(Photo entity) {
        PhotoDTO dto = new PhotoDTO();

        dto.setId(entity.getId());
        dto.setPhotoUrl(entity.getPhotoUrl());
        dto.setActive(entity.getActive());
        dto.setDate(entity.getUploadDate());
        dto.setActive(entity.getActive());
//        dto.setListingId(entity.getListingId());
        
        
//        User from = entity.getUserIdFrom();
//        User to = entity.getUserIdTo();
        
//        List<User> entities = new ArrayList<>();
//        
//        entities.add(from);
//        entities.add(to);
        
//        List dtos = userMapper.toDTO(entities);
        
//        UserDTO fromdto = (UserDTO) dtos.get(0);
//        UserDTO todto = (UserDTO) dtos.get(1);
        
//        dto.setSender(fromdto);
//        dto.setReceiver(todto);

        return dto;
    }

    public List toDTO(List<Photo> entities) {
        List list = new ArrayList();

        for (Photo entity : entities) {
            PhotoDTO photo = toDTO(entity);
            list.add(photo);
        }

        return list;
    }
}
