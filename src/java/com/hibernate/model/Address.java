/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.model;

import javax.persistence.Embeddable;

/**
 *
 * @author Mohamed Ramadan
 */
@Embeddable
public class Address {
    String street;
    String city;
    String country;
    public Address(){}

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Egypt: "+this.country+" ,City: "+this.city+" ,street: "+this.street; //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
