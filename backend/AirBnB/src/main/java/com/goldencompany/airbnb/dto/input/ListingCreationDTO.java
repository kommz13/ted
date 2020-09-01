/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.input;

import com.goldencompany.airbnb.dto.output.AmenityDTO;
import com.goldencompany.airbnb.dto.output.RuleDTO;
import com.goldencompany.airbnb.dto.output.TypeDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class ListingCreationDTO {
   
    private Integer id;
    private double geolocation_lat;
    private double geolocation_long;
    private String country;
    private int bedroom_num;
    private String city;
    private String district;
    private int floor;
    private int maxPeople;
    
    
    
   
    private int bedNum;
    private int bathroomNum;
    private String description;
    
    private int minDays;
    private int active;
    private int extraCostPerPerson;
    private TypeDTO type;
    
    private UserDTO user ;
    private List<AmenityDTO> amenities = new ArrayList<>();
    private List<RuleDTO> rules = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getGeolocation_lat() {
        return geolocation_lat;
    }

    public void setGeolocation_lat(double geolocation_lat) {
        this.geolocation_lat = geolocation_lat;
    }

    public double getGeolocation_long() {
        return geolocation_long;
    }

    public void setGeolocation_long(double geolocation_long) {
        this.geolocation_long = geolocation_long;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBedroom_num() {
        return bedroom_num;
    }

    public void setBedroom_num(int bedroom_num) {
        this.bedroom_num = bedroom_num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    public int getBathroomNum() {
        return bathroomNum;
    }

    public void setBathroomNum(int bathroomNum) {
        this.bathroomNum = bathroomNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinDays() {
        return minDays;
    }

    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getExtraCostPerPerson() {
        return extraCostPerPerson;
    }

    public void setExtraCostPerPerson(int extraCostPerPerson) {
        this.extraCostPerPerson = extraCostPerPerson;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public List<AmenityDTO> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<AmenityDTO> amenities) {
        this.amenities = amenities;
    }

    public List<RuleDTO> getRules() {
        return rules;
    }

    public void setRules(List<RuleDTO> rules) {
        this.rules = rules;
    }

    
    
    

}
