/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.controller;

import com.hibernate.dao.DepartmentDAO;
import com.hibernate.dao.EmployeeDAO;
import com.hibernate.model.Address;
import com.hibernate.model.Department;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.hibernate.model.Employee;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Mohamed Ramadan
 */
@ManagedBean(name = "employeeData", eager = true)
@SessionScoped
public class EmployeeData {

    
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Department> departments = new ArrayList<>();
    private Address address = new Address();
    private String street , city , country , name ;
    private int departmentID;
    
    

    public ArrayList<Employee> getEmployees() {
        EmployeeDAO dao = new EmployeeDAO();
        employees = dao.getEmployeeList();
        return employees;
    }

    public String deleteEmployee(Employee employee) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.deleteEmployee(employee);
        return null;
    }
    public void onRowEdit(RowEditEvent event) {
        System.out.println("com.jsf.controller.EmployeeData.onRowEdit()");
        Employee emp = (Employee)event.getObject();
        DepartmentDAO dao = new DepartmentDAO();
        String st = departmentMenuMap.get(departmentForMenu);
        int id = Integer.parseInt(st);
        Department department = dao.getDepartmentById(id);
         Address address = new Address(street, city, country);
        emp.setAddress(address);
        emp.setDepartment(department);
        EmployeeDAO daoE = new EmployeeDAO();
        daoE.updateEmployee(emp);
 //       FacesMessage msg = new FacesMessage("Employee Edited", ((Employee) event.getObject()).getId());
    //    FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        System.out.println("com.jsf.controller.EmployeeData.onRowCancel()");
//        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
      //  FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   
    public String reset(){
        this.name = null;
        this.city = null;
        this.street = null;
        this.country = null;
        return null;
    }
    //--------------------------------------
   
    public String insertEmployee(){
        Address address = new Address(street, city, country);
        DepartmentDAO dao = new DepartmentDAO();
        String st = departmentMenuMap.get(departmentForMenu);
        int id = Integer.parseInt(st);
        Department department = dao.getDepartmentById(id);
        Employee employee = new Employee(0, name, department, address);
        System.out.println("com.jsf.controller.EmployeeData.insertEmployee()"+department+" id ="+id);
        EmployeeDAO daoE = new EmployeeDAO();
        daoE.insertEmployee(employee);
        info();
        reset();
        
        return null;
    }
    
    //--------------------------------
    private String departmentForMenu;  
    private Map<String,String> departmentMenuMap =  new HashMap<String, String>(); ;
    
     public String getdepartmentForMenu() {
        return departmentForMenu;
    }
    public void setdepartmentForMenu(String departmentForMenu) {
        this.departmentForMenu = departmentForMenu;
    }
     public Map<String, String> getdepartmentMenuMap() {
        return departmentMenuMap;
    }
     @PostConstruct
    public void init() {
         DepartmentDAO dao = new DepartmentDAO();
        List<Department> departments = dao.getDepartmentList();
        for (Department department : departments) {
            departmentMenuMap.put(department.getName(), ""+department.getId());
    }
    }
    //-----------------
     public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", this.name +" Added successfully"));
    }
    //---------------------------
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
    
}
