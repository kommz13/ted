/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.entity.Amenity;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.Rule;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class ListingMapper {

    @Inject
    AmenityMapper amenityMapper;

    @Inject
    RuleMapper ruleMapper;

    @Inject
    TypeMapper typeMapper;

    public ListingDTO toDTO(Listing entity) {
        ListingDTO dto = new ListingDTO();

        dto.setId(entity.getId());
        dto.setGeolocation_lat(entity.getGeolocationLatitude());
        dto.setGeolocation_long(entity.getGeolocationLongitude());
        dto.setCountry(entity.getCountry());
        dto.setCity(entity.getCity());
        dto.setBedroom_num(entity.getBedroomNumber());
        dto.setDistrict(entity.getDistrict());
        dto.setFloor(entity.getFloor());
        dto.setMaxPeople(entity.getMaxPeople());
        dto.setBedNum(entity.getBedNumber());
        dto.setBathroomNum(entity.getBathroomNumber());
        dto.setDescription(entity.getDescription());
        dto.setMinDays(entity.getMinimumDays());
        dto.setActive(entity.getActive());
        dto.setSubmittedDate(entity.getSubmittedDate());
        dto.setExtraCostPerPerson(entity.getExtraCostPerPerson());
        dto.setFriendlyName(entity.getFriendlyName());

//        User from = entity.getUserIdFrom();
//        User to = entity.getUserIdTo();
//        List<User> entities = new ArrayList<>();
//        
//        entities.add(from);
//        entities.add(to);
//        
//        List dtos = userMapper.toDTO(entities);
//        
//        UserDTO fromdto = (UserDTO) dtos.get(0);
//        UserDTO todto = (UserDTO) dtos.get(1);
//        
//        dto.setSender(fromdto);
//        dto.setReceiver(todto);
        return dto;
    }

    public List toDTO(List<Listing> entities) {
        List list = new ArrayList();

        for (Listing entity : entities) {
            ListingDTO listing = toDTO(entity);
            list.add(listing);
            for (Amenity a : entity.getAmenityList()) {
                listing.getAmenities().add(amenityMapper.toDTO(a));
            }

            listing.setType(typeMapper.toDTO(entity.getTypeId()));

            for (Rule r : entity.getRuleList()) {
                listing.getRules().add(ruleMapper.toDTO(r));
//                        .getRule().add(rule);
            }
        }

        return list;
    }
}
