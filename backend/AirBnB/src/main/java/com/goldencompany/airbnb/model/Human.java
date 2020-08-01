/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.model;

/**
 *
 * @author george
 */
public class Human {
    private String firstname;
    private String lastname;

    public Human(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Human() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    
}
