/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers;

import com.goldencompany.airbnb.dto.input.BookingCreationDTO;
import com.goldencompany.airbnb.dto.input.CriticCreationDTO;
import com.goldencompany.airbnb.dto.input.MessageCreationDTO;
import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Critic;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.constants.UserConstants;
import com.goldencompany.airbnb.exceptions.BaseValidationException;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.BookingMapper;
import com.goldencompany.airbnb.mappers.CriticMapper;
import com.goldencompany.airbnb.mappers.ListingMapper;
import com.goldencompany.airbnb.mappers.MessageMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.repositories.BookingRepository;
import com.goldencompany.airbnb.repositories.CriticRepository;
import com.goldencompany.airbnb.repositories.ListingRepository;
import com.goldencompany.airbnb.repositories.MessageRepository;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class CriticManagementController {

    @Inject
    UserRepository userRepository;

//    @Inject
//    UserMapper userMapper;
//
//    @Inject
//    BookingRepository bookingRepository;
//
//    @Inject
//    BookingMapper bookingMapper;
//
//    @Inject
//    ListingMapper listingMapper;
//
    @Inject
    ListingRepository listingRepository;
    @Inject
    CriticMapper criticMapper;

    @Inject
    CriticRepository criticRepository;

    public List retrieveAllCritics() {
        List<Critic> critics = criticRepository.retrieveAllCritics();

        List dtos = criticMapper.toDTO(critics);

        return dtos;
    }

    public List retrieveCriticsByCriticId(Integer id) throws BaseValidationException {
        List<Critic> critics = criticRepository.retrieveCriticsByCriticId(id);
        List errors = new ArrayList();

        if (critics.isEmpty()) {
            errors.add("Critic with such id does not exist");
            throw new BaseValidationException(errors);
        }

        List dtos = criticMapper.toDTO(critics);

        return dtos;
    }

    public List retrieveCriticsByUserId(Integer id) throws BaseValidationException {
        
        List<User> users = userRepository.find(id);

        List errors = new ArrayList();
        if (users.isEmpty()) {
            errors.add("retrieveCriticsByUserId : User with such id does not exist ");
            throw new BaseValidationException(errors);
        }
        
        
        List<Critic> critics = criticRepository.retrieveCriticsByUserId(id);
        if (critics.isEmpty()) {
            errors.add("User hasn't made any critic(s) yet");
            throw new BaseValidationException(errors);
        }

        List dtos = criticMapper.toDTO(critics);

        return dtos;
    }
    
    
        public List retrieveCriticsByListingId(Integer id) throws BaseValidationException {
         List<Listing> listings = listingRepository.find(id);

        List errors = new ArrayList();
        if (listings.isEmpty()) {
            errors.add("retrieveCriticsByUserId : listing with such id does not exist ");
            throw new BaseValidationException(errors);
        }
        
        
        List<Critic> critics = criticRepository.retrieveCriticsByListingId(id);
        if (critics.isEmpty()) {
            errors.add("This Listing doesn't have any critic(s) yet");
            throw new BaseValidationException(errors);
        }

        List dtos = criticMapper.toDTO(critics);

        return dtos;
    }

//    public List retrieveBookingsByUserID(Integer id) {
//        List<Booking> bookings = criticRepository.retrieveAllBookingsByUserId(id);
//
//        List dtos = criticMapper.toDTO(bookings);
//
//        return dtos;
//    }
//
//    public BookingCreationDTO createBooking(BookingCreationDTO input) {
//        List<User> users = userRepository.find(input.getUserId());
//        List<Listing> listings = listingRepository.find(input.getListingId());
//        Booking thisBooking = bookingMapper.toEntity(input, users.get(0), listings.get(0));
//
//        bookingRepository.create(thisBooking);
//
//        return input;
//
//    }
//
//    public List retrieveBookingsByListingId(Integer id) {
//        List<Booking> bookings = bookingRepository.retrieveAllBookingsByListingId(id);
//
//        List dtos = bookingMapper.toDTO(bookings);
//
//        return dtos;
//    }
//
//    public BookingDTO acceptPendingBooking(Integer id) throws UserValidationException {
//        List<Booking> bookings = bookingRepository.findByBookingID(id);
//        Booking thisBooking = new Booking();
//        List errors = new ArrayList();
//
//        if (!bookings.isEmpty()) {
//            thisBooking = bookings.get(0);
//        } else {
//            //throw error message 
//            errors.add("This Booking does not exist");
////            return new BookingDTO();
//            throw new UserValidationException(errors);
//        }
//
//        if (thisBooking.getBookingStatus() != 0) {
//            errors.add("Booking exists but is already accepted or rejected");
//            throw new UserValidationException(errors);
//        }
//
//        thisBooking.setBookingStatus(1);
//        bookingRepository.update(thisBooking);
//        BookingDTO returnBooking = bookingMapper.toDTO(thisBooking);
//        return returnBooking;
//    }
//
//    public BookingDTO rejectPendingBooking(Integer id) throws UserValidationException {
//        List<Booking> bookings = bookingRepository.findByBookingID(id);
//        List errors = new ArrayList();
//
//        Booking thisBooking = new Booking();
//        if (!bookings.isEmpty()) {
//            thisBooking = bookings.get(0);
//        } else {
//            //throw error message 
//            errors.add("This Booking does not exist");
////            return new BookingDTO();
//            throw new UserValidationException(errors);
//        }
//
//        if (thisBooking.getBookingStatus() != 0) {
//            errors.add("Booking exists but is already accepted or rejected");
//            throw new UserValidationException(errors);
//        }
//
//        thisBooking.setBookingStatus(2);
//        bookingRepository.update(thisBooking);
//        BookingDTO returnBooking = bookingMapper.toDTO(thisBooking);
//        return returnBooking;
//    }
//
//    public BookingDTO makeBookingPending(Integer id) throws UserValidationException {
//        List<Booking> bookings = bookingRepository.findByBookingID(id);
//        List errors = new ArrayList();
//
//        Booking thisBooking = new Booking();
//        if (!bookings.isEmpty()) {
//            thisBooking = bookings.get(0);
//        } else {
//            //throw error message 
//            errors.add("make Booking Pending :This Booking does not exist");
////            return new BookingDTO();
//            throw new UserValidationException(errors);
//        }
//
//        if (thisBooking.getBookingStatus() == 0) {
//            errors.add("make Booking Pending : Booking exists but is already pending");
//            throw new UserValidationException(errors);
//        }
//
//        thisBooking.setBookingStatus(0);
//        bookingRepository.update(thisBooking);
//        BookingDTO returnBooking = bookingMapper.toDTO(thisBooking);
//        return returnBooking;
//    }
//    public List retrieveAllCritics() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public CriticCreationDTO createCritic(CriticCreationDTO input)throws BaseValidationException {
//        throw new BaseValidationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return input;
    }


}
