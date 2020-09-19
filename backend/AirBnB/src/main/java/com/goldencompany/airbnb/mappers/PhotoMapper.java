/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.ListingCreationDTO;
import com.goldencompany.airbnb.dto.output.PhotoDTO;
import com.goldencompany.airbnb.entity.Photo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class PhotoMapper {

    public PhotoDTO toDTO(Photo entity) {
        PhotoDTO dto = new PhotoDTO();

        dto.setId(entity.getId());
        dto.setPhotoUrl(entity.getPhotoUrl());
        dto.setActive(entity.getActive());
        dto.setUploadDate(entity.getUploadDate());
        dto.setActive(entity.getActive());

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

    public Photo toEntity(String photo_url, int listingId) {
        Photo thisPhoto = new Photo();
        thisPhoto.setActive(1);
        thisPhoto.setPhotoUrl(photo_url);
        thisPhoto.setDefaultUrl((short) 1);
        thisPhoto.setUploadDate(new Date());

//        this.active = active;
//        this.uploadDate = uploadDate;
//        this.defaultUrl = defaultUrl;
//          return new Photo();
        return thisPhoto;
    }

    public Photo toEntity(String photo_url) {
        Photo thisPhoto = new Photo();
        thisPhoto.setActive(1);
        thisPhoto.setPhotoUrl(photo_url);
        thisPhoto.setDefaultUrl((short) 1);
        thisPhoto.setUploadDate(new Date());

//        this.active = active;
//        this.uploadDate = uploadDate;
//        this.defaultUrl = defaultUrl;
//          return new Photo();
        return thisPhoto;
    }

    public List<Photo> toEntities(ListingCreationDTO input) {
        return new ArrayList<>();
//        List<Photo> photos= new ArrayList();
//        
//          for () {
//            PhotoDTO photo = toDTO(entity);
//            list.add(photo);
//        }
//
//        return list;

    }

    public List<Photo> toEntities(List<String> input) {
        return new ArrayList<>();
//        List<Photo> photos= new ArrayList();
////        
//          for (String photo : input) {
//              Photo photoEnt= toEntity(photo);
////            PhotoDTO photo = toDTO(entity);
////            list.add(photo);
//        }
////
//        return list;

    }
}
