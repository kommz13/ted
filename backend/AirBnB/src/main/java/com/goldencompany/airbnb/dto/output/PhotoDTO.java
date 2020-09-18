/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.output;

import com.goldencompany.airbnb.entity.Listing;
import java.util.Date;

/**
 *
 * @author george
 */
public class PhotoDTO {

    private Integer id;
    private String photoUrl;
    private int active;
    private Date uploadDate;
    private short default1;
//    private ListingDTO listingId;
    
    public PhotoDTO() {
    }
    

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    
    public String getPhotoUrl(){
        return this.photoUrl;
    }
    
    
//    Date uploadDate
            
    public Date getDate(){
        return uploadDate;
    }
    
    public void setDate(Date uploadDate){
        this.uploadDate=uploadDate;
    }
    
    public short getDefault(){
        return default1;
    }
    public void setDefault(short default1){
        this.default1=default1;
    }
    
//    public Listing getListingId(){
//        return listingId;
//    }
//    
//    public void setListingId(Listing listingId){
//        this.listingId=listingId;
//    }

//    public ListingDTO getListingId() {
//        return listingId;
//    }
//
//    public void setListingId(ListingDTO listingId) {
//        this.listingId = listingId;
//    }
}
