/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.output;

import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author george
 */
public class BookingDTO {
    private Integer id;
    private Date checkIn;
    private Date checkOut;
    private int bookingStatus;
    private int howManyPeople;

//prosoxh , isws xreiazetai
//    private ListingDTO listingId;
//prosoxh , isws xreiazetai    

//    private List <User> userId;
    private UserDTO userId;
//    private List <Message> messageId;
//    this.id = id;
//        this.checkin = checkin;
//        this.checkout = checkout;
//        this.bookingStatus = bookingStatus;
//        this.howManyPeople = howManyPeople;

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(int bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getHowManyPeople() {
        return howManyPeople;
    }

    public void setHowManyPeople(int howManyPeople) {
        this.howManyPeople = howManyPeople;
    }

//    public ListingDTO getListingId() {
//        return listingId;
//    }
//
//    public void setListingId(ListingDTO listingId) {
//        this.listingId = listingId;
//    }

    public UserDTO getUserId() {
        return userId;
    }

    public void setUserId(UserDTO userId) {
        this.userId = userId;
    }

    
//    public Listing getListingId() {
//        return listingId;
//    }
//
//    public void setListingId(Listing listingId) {
//        this.listingId = listingId;
//    }

//    public List<User> getUserId() {
//        return userId;
//    }
//
//    public void setUserId(List<User> userId) {
//        this.userId = userId;
//    }

//    public User getUserId() {
//        return userId;
//    }
//
//    public void setUserId(User userId) {
//        this.userId = userId;
//    }
    

//    public List<Message> getMessageId() {
//        return messageId;
//    }
//
//    public void setMessageId(List<Message> messageId) {
//        this.messageId = messageId;
//    }

    public BookingDTO() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

 
    
    
    
}
