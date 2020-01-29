/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.model;

import javax.persistence.*;

/**
 *
 * @author Mohamed Ramadan
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    //
    @Embedded
    private Address address;
    //
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "departmentid")
    private Department department = new Department();

    public Employee() {
    }

    public Employee(int id, String name, Department department, Address address) {
        this.id = id;
        this.name = name;
        this.department = department;
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

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
	public String toString(){
		return String.format("Employee [employeeID = %d, Name = %s , department_ID= %d", id, name,  department.getId());
	}
}
