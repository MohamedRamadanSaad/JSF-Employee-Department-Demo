/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.beans;

import com.hibernate.model.Address;
import com.hibernate.model.Department;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Mohamed Ramadan
 */
@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {
    
    private int id;
    private String name;
    private String city ;
    private String street;
    private String country;
    private Address address = new Address();
    private String departmentName;
    private Department department = new Department();

    public EmployeeBean() {
    }

    public EmployeeBean(int id, String name, String city, String street, String country, Address address) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.country = country;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        
        return  city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
     public String test(){
        System.out.println("com.jsf.controller.EmployeeData.test()  "+this.name);
        return "true";
    }
}
