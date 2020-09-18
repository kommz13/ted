/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers.listing;

import com.goldencompany.airbnb.dto.input.ListingCreationDTO;
import com.goldencompany.airbnb.dto.input.ListingUpdateDTO;
import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.entity.Amenity;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Photo;
import com.goldencompany.airbnb.entity.Rule;
import com.goldencompany.airbnb.entity.Type;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.exceptions.BaseValidationException;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.AmenityMapper;
import com.goldencompany.airbnb.mappers.ListingMapper;
import com.goldencompany.airbnb.mappers.PhotoMapper;
import com.goldencompany.airbnb.mappers.RoleMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.mappers.RuleMapper;
import com.goldencompany.airbnb.mappers.TypeMapper;
import com.goldencompany.airbnb.repositories.ListingRepository;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class ListingManagementController {

    @Inject
    ListingRepository listingRepository;

//    @Inject
//    ListingQueryHolder listingQueries;
    @Inject
    ListingMapper listingMapper;

    @Inject
    AmenityMapper amenityMapper;

    @Inject
    RuleMapper ruleMapper;
    
    @Inject
    TypeMapper typeMapper;
    
    @Inject
    PhotoMapper photoMapper;

//    @Inject
//    RoleMapper roleMapper;
    public List retrieveListings() {
        List<Listing> listing = listingRepository.findAll();

        List dtos = listingMapper.toDTO(listing);

        return dtos;
    }

    public List retrieveListingByID(Integer id) {
        List<Listing> listing = listingRepository.find(id);

        List dtos = listingMapper.toDTO(listing);
        return dtos;
    }
//

    public List retrieveActiveListings() {
        List<Listing> listing = listingRepository.findActive();

        List dtos = listingMapper.toDTO(listing);

        return dtos;
    }
//

    public List retrieveInactiveListings() {
        List<Listing> listing = listingRepository.findInactive();

        List dtos = listingMapper.toDTO(listing);

        return dtos;
    }

    public List findInactiveByUserId(Integer id) {
        List<Listing> listing = listingRepository.findInactiveByUserId(id);

        List dtos = listingMapper.toDTO(listing);

        return dtos;
    }

    public List findactiveByUserId(Integer id) {
        List<Listing> listing = listingRepository.findActiveByUserId(id);

        List dtos = listingMapper.toDTO(listing);

        return dtos;
    }

    public List updateListing(Integer id, ListingUpdateDTO input) throws UserValidationException {
        List<ListingUpdateDTO> listing = Arrays.asList(input);

        List errors = new ArrayList();

        List<Listing> listings = listingRepository.findByListingId(id);
        if (listings.isEmpty()) {
            errors.add("There's no such listing");
            throw new UserValidationException(errors);
        }

        Listing thisListing = listings.get(0);

        thisListing.setBedroomNumber(input.getBedroom_num());
        thisListing.setMaxPeople(input.getMaxPeople());
        thisListing.setBedNumber(input.getBedNum());
        thisListing.setDescription(input.getDescription());
        thisListing.setMinimumDays(input.getMinDays());
        thisListing.setActive(input.getActive());
        thisListing.setExtraCostPerPerson(input.getExtraCostPerPerson());

        List<Amenity> amenities = amenityMapper.toEntities(input);

        thisListing.setAmenityList(amenities);

        List<Rule> rules = ruleMapper.toEntities(input);

        thisListing.setRuleList(rules);

        listings = listingRepository.update(thisListing);

        List dtos = listingMapper.toDTO(listings);

        //edw 8a prepei na dw pws 8a ftia3w tis listes me ta amenities kai ta rules
//
        return dtos;
    }

    public List createListing(ListingCreationDTO input) throws BaseValidationException {
        Listing listing = listingMapper.toEntity(input);

        List<Amenity> amenities = amenityMapper.toEntities(input);

        List<Rule> rules = ruleMapper.toEntities(input);
        
        List<Photo> photos = photoMapper.toEntities(input);
                

        List<Listing> listings = listingRepository.create(listing, input.getUserId(), input.getTypeId(), amenities, photos, rules);

        List dtos = listingMapper.toDTO(listings);

        return dtos;
    }

}
