/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.output;

import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author george
 */
public class CriticDTO {
    private Integer id;
    private Date checkIn;
    private Date checkOut;
    private int bookingStatus;
    private int howManyPeople;
    private Listing listingId;
//    private List <User> userId;
    private User userId;
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

    public Listing getListingId() {
        return listingId;
    }

    public void setListingId(Listing listingId) {
        this.listingId = listingId;
    }

//    public List<User> getUserId() {
//        return userId;
//    }
//
//    public void setUserId(List<User> userId) {
//        this.userId = userId;
//    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
    

   

    public CriticDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

 
    
    
    
}
