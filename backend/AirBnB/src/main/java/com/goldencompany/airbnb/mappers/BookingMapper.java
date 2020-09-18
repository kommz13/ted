/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.entity.Booking;
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
public class BookingMapper {

    @Inject
    UserMapper userMapper;

    public BookingDTO toDTO(Booking entity) {
        BookingDTO dto = new BookingDTO();

        dto.setId(entity.getId());
        dto.setCheckIn(entity.getCheckin());
        dto.setCheckOut(entity.getCheckout());
        dto.setBookingStatus(entity.getBookingStatus());
        dto.setHowManyPeople(entity.getHowManyPeople());

//        User bookingUser = entity.getUserId();
//        Listing listing = entity.getListingId();
        
        
        User user =entity.getUserId();
        
//        Listing listing = entity.getListingId();
        
        UserDTO userDTO= userMapper.toDTO(user);
//        ListingDTO listingDTO=listingMapper.toDTO(listing);
        
        
        dto.setUser(userDTO);
//        dto.setListingId(listingDTO);


        return dto;
    }

    public List toDTO(List<Booking> entities) {
        List list = new ArrayList();

        for (Booking entity : entities) {
            BookingDTO booking = toDTO(entity);
            list.add(booking);
        }

        return list;
    }
}
