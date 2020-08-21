/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.exceptions;

import java.util.List;

/**
 *
 * @author george
 */
public class UserValidationException extends Exception {
    private List errors;

    public UserValidationException(List errors) {
        this.errors = errors;
    }

    public List getErrors() {
        return errors;
    }

    public void setErrors(List errors) {
        this.errors = errors;
    }
    
    
    
    
    
}
