/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.output.CriticDTO;
import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Critic;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class CriticMapper {

    @Inject
    UserMapper userMapper;

//    @Inject
//    ListingMapper listingMapper;
//    
    
    

    public CriticDTO toDTO(Critic entity) {
        CriticDTO dto = new CriticDTO();

        dto.setId(entity.getId());
        dto.setText(entity.getText());
        dto.setRating(entity.getRating());
        dto.setDate(entity.getDate());
        

//        User bookingUser = entity.getUserId();
//        Listing listing = entity.getListingId();
        
        
        User user =entity.getUserId();
        
//        Listing listing = entity.getListingId();
        
        UserDTO userDTO= userMapper.toDTO(user);
//        ListingDTO listingDTO=listingMapper.toDTO(listing);
        
        
        dto.setUserId(userDTO);
//        dto.setListingId(listingDTO);


        return dto;
    }

    public List toDTO(List<Critic> entities) {
        List list = new ArrayList();

        for (Critic entity : entities) {
            CriticDTO critic = toDTO(entity);
            list.add(critic);
        }

        return list;
    }
}
