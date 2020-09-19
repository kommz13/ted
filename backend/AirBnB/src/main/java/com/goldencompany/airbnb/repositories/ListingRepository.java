/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import com.goldencompany.airbnb.entity.Amenity;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Photo;
import com.goldencompany.airbnb.entity.Role;
import com.goldencompany.airbnb.entity.Rule;
import com.goldencompany.airbnb.entity.Type;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.exceptions.BaseValidationException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author george
 *
 */
@Stateless
public class ListingRepository {

    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    private EntityManager em;

    public List<Listing> findAll() {
        Query q = em.createNamedQuery("Listing.findAll");
        List listing = q.getResultList();
        return listing;
//         TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
//         List<User> results = query.getResultList();
//         return results;

    }

    public List find(Integer id) {
        Query q = em.createNamedQuery("Listing.findById");
        q.setParameter("id", id);

        List users = q.getResultList();

        return users;
    }
//

    public List<Listing> findActive() {
        Query q = em.createNamedQuery("Listing.findByActive");
        q.setParameter("active", 1);

        List listing = q.getResultList();

        return listing;
    }
//

    public List<Listing> findInactive() {
        Query q = em.createNamedQuery("Listing.findByActive");
        q.setParameter("active", 0);

        List listings = q.getResultList();

        return listings;
    }
//
//    public void create(User entity, List<Role> roles) {
//        em.persist(entity);//insert
//        
//        entity.setRoleList(new ArrayList<>());
//        
//        for (Role unmanaged : roles) {
//            Role managed = em.find(Role.class, unmanaged.getId());
//            entity.getRoleList().add(managed);     
//            managed.getUserList().add(entity);
//        }
//    }
//
//    public List<User> findByUserName(String username) {
//        Query q = em.createNamedQuery("User.findByUsername");
//        q.setParameter("username", username);
//        
//        List users = q.getResultList();     
//            
//        return users;
//    }
//
//    public List<User> findByPhone(String phone) {
//        Query q = em.createNamedQuery("User.findByPhone");
//        q.setParameter("phone", phone);
//                
//        List users = q.getResultList();     
//            
//        return users;
//    }    
//
////    public List<User> findApproved(String registrationStatus) {
////
////    }
//
//    public List<User> findApproved(int registrationStatus) {
//        Query q = em.createNamedQuery("User.findByRegistrationStatus");
//        q.setParameter("registrationStatus", registrationStatus);
//                
//        List users = q.getResultList();     
//            
//        return users;    
//    }
//
//    public List<User> update(User thisUser) {
//        em.merge(thisUser);
//        
//        List users = new ArrayList();
//        
//        users.add(thisUser);
//        
//        return users;        
//    }

    public List<Listing> export() {
        Query q = em.createNamedQuery("Listing.findAll");
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findInactiveByUserId(Integer id) {
        Query q = em.createNamedQuery("Listing.findByUserId");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findActiveByUserId(Integer id) {
        Query q = em.createNamedQuery("Listing.findActiveByUserId");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findByListingId(Integer id) {
        Query q = em.createNamedQuery("Listing.findById");
        q.setParameter("id", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> update(Listing thisListing) {
        em.merge(thisListing);

        List listings = new ArrayList();

        listings.add(thisListing);

        return listings;
    }

    
    public List<Listing> create(Listing listing, int userId, int typeId, List<Amenity> amenities, Photo photo, List<Rule> rules) throws BaseValidationException {
        Type type = em.find(Type.class,typeId);
        
        if (type == null) {
            throw new BaseValidationException("Type id is  invalid");
        }
        
        User user = em.find(User.class, userId);
        
        if (user == null) {
            throw new BaseValidationException("User id is  invalid");
        }
        
        listing.setTypeId(type);
        
        listing.setUserId(user);
        
        listing.setAmenityList(amenities);
        
        listing.setRuleList(rules);
        
        listing.setPhotoList(new ArrayList<>());
        
        listing.getPhotoList().add(photo);
        
        photo.setListingId(listing);
                                                
        em.persist(listing);
        
        List listings = new ArrayList();

        listings.add(listing);

        return listings;
    }

}
