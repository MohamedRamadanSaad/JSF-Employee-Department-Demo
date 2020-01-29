/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Mohamed Ramadan
 */
@Entity
public class Department {
    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id; 
    private String name;
    private String description ;
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        
        this.description = description;
    }

    public Department(){}
    public Department(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String toString() {
        return this.name; 
    }
    
    
}
