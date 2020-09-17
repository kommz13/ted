/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "user_views_listing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserViewsListing.findAll", query = "SELECT u FROM UserViewsListing u"),
    @NamedQuery(name = "UserViewsListing.findByUserId", query = "SELECT u FROM UserViewsListing u WHERE u.userViewsListingPK.userId = :userId"),
    @NamedQuery(name = "UserViewsListing.findByListingId", query = "SELECT u FROM UserViewsListing u WHERE u.userViewsListingPK.listingId = :listingId"),
    @NamedQuery(name = "UserViewsListing.findByCounter", query = "SELECT u FROM UserViewsListing u WHERE u.counter = :counter")})
public class UserViewsListing implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserViewsListingPK userViewsListingPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "counter")
    private int counter;
    @JoinColumn(name = "listing_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Listing listing;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public UserViewsListing() {
    }

    public UserViewsListing(UserViewsListingPK userViewsListingPK) {
        this.userViewsListingPK = userViewsListingPK;
    }

    public UserViewsListing(UserViewsListingPK userViewsListingPK, int counter) {
        this.userViewsListingPK = userViewsListingPK;
        this.counter = counter;
    }

    public UserViewsListing(int userId, int listingId) {
        this.userViewsListingPK = new UserViewsListingPK(userId, listingId);
    }

    public UserViewsListingPK getUserViewsListingPK() {
        return userViewsListingPK;
    }

    public void setUserViewsListingPK(UserViewsListingPK userViewsListingPK) {
        this.userViewsListingPK = userViewsListingPK;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userViewsListingPK != null ? userViewsListingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserViewsListing)) {
            return false;
        }
        UserViewsListing other = (UserViewsListing) object;
        if ((this.userViewsListingPK == null && other.userViewsListingPK != null) || (this.userViewsListingPK != null && !this.userViewsListingPK.equals(other.userViewsListingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goldencompany.airbnb.entity.UserViewsListing[ userViewsListingPK=" + userViewsListingPK + " ]";
    }
    
}
