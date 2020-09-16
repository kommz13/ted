/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers.listing;

import com.goldencompany.airbnb.dto.input.ListingUpdateDTO;
import com.goldencompany.airbnb.entity.Amenity;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Rule;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.AmenityMapper;
import com.goldencompany.airbnb.mappers.ListingMapper;
import com.goldencompany.airbnb.mappers.RoleMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.mappers.RuleMapper;
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

//        public List<Listing> findInactiveByUserId(Integer id) {
//        Query q = em.createNamedQuery("Listing.findByUserId");
//        q.setParameter("x", id);
//        List<Listing> listing = q.getResultList();
//        return listing;
//    }
//
//    public List retrieveUsersByStatus(int registrationStatus) {
//        List<User> users = userRepository.findApproved(registrationStatus);
//
//        List dtos = userMapper.toDTO(users);
//
//        return dtos;
//    }
//
//    public List approveUser(Integer id) throws UserValidationException {
//        List<User> users = userRepository.find(id);
//        List errors = new ArrayList();
//
//        if (users.isEmpty()) {
//            errors.add("user does not exist");
//            throw new UserValidationException(errors);
//        }
//        User thisUser = users.get(0);
//
//        if (thisUser.getRegistrationStatus() == UserConstants.PENDING) {
//            thisUser.setRegistrationStatus(UserConstants.APPROVED);
//
//            users = userRepository.update(thisUser);
//
//            List dtos = userMapper.toDTO(users);
//
//            return dtos;
//        } else {
//            errors.add("user is approved or rejected");
//            throw new UserValidationException(errors);
//        }
//    }
//
//    public List unapproveUser(Integer id) throws UserValidationException {
//        List<User> users = userRepository.find(id);
//        List errors = new ArrayList();
//
//        if (users.isEmpty()) {
//            errors.add("user does not exist");
//            throw new UserValidationException(errors);
//        }
//        User thisUser = users.get(0);
//
//        if (thisUser.getRegistrationStatus() == UserConstants.PENDING) {
//            thisUser.setRegistrationStatus(UserConstants.REJECTED);
//
//            users = userRepository.update(thisUser);
//
//            List dtos = userMapper.toDTO(users);
//
//            return dtos;
//        } else {
//            errors.add("user is approved or already rejected"); // exei nohma na kanome reject kapoion p einai approved?
//            throw new UserValidationException(errors);
//        }
//    }
//
//    public List unapproveApprovedUser(Integer id) throws UserValidationException {
//        List<User> users = userRepository.find(id);
//        List errors = new ArrayList();
//
//        if (users.isEmpty()) {
//            errors.add("user does not exist");
//            throw new UserValidationException(errors);
//        }
//        User thisUser = users.get(0);
//
//        if (thisUser.getRegistrationStatus() == UserConstants.APPROVED) {
//            thisUser.setRegistrationStatus(UserConstants.REJECTED);
//
//            users = userRepository.update(thisUser);
//
//            List dtos = userMapper.toDTO(users);
//
//            return dtos;
//        } else {
//            errors.add("this user is already rejected or pending"); // exei nohma na kanome reject kapoion p einai approved?
//            throw new UserValidationException(errors);
//        }
//    }
//
//    public List approveUnapprovedUser(Integer id) throws UserValidationException {
//        List<User> users = userRepository.find(id);
//        List errors = new ArrayList();
//
//        if (users.isEmpty()) {
//            errors.add("user does not exist");
//            throw new UserValidationException(errors);
//        }
//        User thisUser = users.get(0);
//
//        if (thisUser.getRegistrationStatus() == UserConstants.REJECTED) {
//            thisUser.setRegistrationStatus(UserConstants.APPROVED);
//
//            users = userRepository.update(thisUser);
//
//            List dtos = userMapper.toDTO(users);
//
//            return dtos;
//        } else {
//            errors.add("this user is already Approved or pending"); // exei nohma na kanome reject kapoion p einai approved?
//            throw new UserValidationException(errors);
//        }
//    }
    public List findactiveByUserId(Integer id) {
        List<Listing> listing = listingRepository.findActiveByUserId(id);

        List dtos = listingMapper.toDTO(listing);

        return dtos;
    }

    public List updateListing(Integer id, ListingUpdateDTO input)  throws UserValidationException {
        List <ListingUpdateDTO> listing = Arrays.asList(input);
        
        List errors = new ArrayList();
        
        List<Listing> listings = listingRepository.findByListingId(id);
        if(listings.isEmpty()){
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
       
       List <Amenity> amenities= amenityMapper.toEntities(input);
       
       thisListing.setAmenityList(amenities);
       
       List <Rule> rules = ruleMapper.toEntities(input);
       
       thisListing.setRuleList(rules);
       
        listings = listingRepository.update(thisListing);

        List dtos = listingMapper.toDTO(listings);

       
       //edw 8a prepei na dw pws 8a ftia3w tis listes me ta amenities kai ta rules
       
//
//        if (messages.isEmpty()) {
//            errors.add("message does not exist");
//            throw new UserValidationException(errors);
//        }
//        Message thisMessage = messages.get(0);
//
//        if (thisMessage.getActive() == 0) {
//            thisMessage.setActive(1);
//
//            thisMessage = messageRepository.update(thisMessage);
//
//            List dtos = messageMapper.toDTO(messages);
//            MessageDTO returnMessage = (MessageDTO) dtos.get(0);
//
////            MessageDTO dtos = messageMapper.toDTO(thisMessage);
//            return returnMessage;
//        } else {
//            errors.add("this message is not deleted so it cannot be undeleted");
//            throw new UserValidationException(errors);
//        }
//    }

        return dtos;
    }

}
