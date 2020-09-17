/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author alex
 */
@Embeddable
public class UserViewsListingPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "listing_id")
    private int listingId;

    public UserViewsListingPK() {
    }

    public UserViewsListingPK(int userId, int listingId) {
        this.userId = userId;
        this.listingId = listingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) listingId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserViewsListingPK)) {
            return false;
        }
        UserViewsListingPK other = (UserViewsListingPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.listingId != other.listingId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goldencompany.airbnb.entity.UserViewsListingPK[ userId=" + userId + ", listingId=" + listingId + " ]";
    }
    
}
