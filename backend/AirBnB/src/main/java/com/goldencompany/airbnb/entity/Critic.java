/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author george
 */
@Entity
@Table(name = "critic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Critic.findAll", query = "SELECT c FROM Critic c"),
    @NamedQuery(name = "Critic.findById", query = "SELECT c FROM Critic c WHERE c.criticPK.id = :id"),
    @NamedQuery(name = "Critic.findByListingId", query = "SELECT c FROM Critic c WHERE c.criticPK.listingId = :listingId"),
    @NamedQuery(name = "Critic.findByUserId", query = "SELECT c FROM Critic c WHERE c.criticPK.userId = :userId"),
    @NamedQuery(name = "Critic.findByRating", query = "SELECT c FROM Critic c WHERE c.rating = :rating"),
    @NamedQuery(name = "Critic.findByDate", query = "SELECT c FROM Critic c WHERE c.date = :date")})
public class Critic implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriticPK criticPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "listing_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Listing listing;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public Critic() {
    }

    public Critic(CriticPK criticPK) {
        this.criticPK = criticPK;
    }

    public Critic(CriticPK criticPK, String text, int rating) {
        this.criticPK = criticPK;
        this.text = text;
        this.rating = rating;
    }

    public Critic(int id, int listingId, int userId) {
        this.criticPK = new CriticPK(id, listingId, userId);
    }

    public CriticPK getCriticPK() {
        return criticPK;
    }

    public void setCriticPK(CriticPK criticPK) {
        this.criticPK = criticPK;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        hash += (criticPK != null ? criticPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Critic)) {
            return false;
        }
        Critic other = (Critic) object;
        if ((this.criticPK == null && other.criticPK != null) || (this.criticPK != null && !this.criticPK.equals(other.criticPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goldencompany.airbnb.entity.Critic[ criticPK=" + criticPK + " ]";
    }
    
}
