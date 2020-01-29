/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.hibernate.service;

/**
 *
 * @author Mohamed Ramadan
 */
import com.hibernate.dao.DepartmentDAO;
import com.hibernate.dao.EmployeeDAO;
import java.util.List;
import com.hibernate.model.Address;
import com.hibernate.model.Department;
import com.hibernate.model.Employee;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateService {
    public static void main(String[] args) {
        empTest();
        //insertTest();
        /*EmployeeDAO dao = new EmployeeDAO();
        Employee emp = dao.getEmployeeById(110);
        deleteEmployee(emp);*/
    }
    public static void getEmployees(){
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.getEmployeeList();
        for (Employee employee : employees) {
            System.out.println( employee.toString());
        }
    }
   public static void getEmployeesById(int id){
        EmployeeDAO dao = new EmployeeDAO();
        Employee employee = dao.getEmployeeById(id);
        System.out.println(employee.toString());
    }
   
   public static void insertEmployee(Employee emp){
        EmployeeDAO dao = new EmployeeDAO();
        dao.insertEmployee(emp);
    }
   public static void insertDepartment(Department dep){
        DepartmentDAO dao = new DepartmentDAO();
        dao.insertDepartment(dep);
    }
   public static void deleteEmployee(Employee emp){
        EmployeeDAO dao = new EmployeeDAO();
        dao.deleteEmployee(emp);
    }
    
    public static void empTest(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try { 
        txn.begin();
        Address address = new Address("25 st", "cairo","Egypt" );
         Address address2 = new Address("50 st", "nasr","Egypt" );
        Department department = new Department(0, "IT", "Information Tech");
        Department department2 = new Department(0, "CS", "Computer Science");
        Employee employee1 = new Employee(0, "Mohamed",department,address);
        Employee employee2 = new Employee(0, "Ahmed",department,address2);
      //  department.getEmployees().add(employee1);
       // department.getEmployees().add(employee2);
        session.persist(department);
        session.persist(department2);
        session.persist(employee1);
        session.persist(employee2);
        txn.commit();
        System.exit(0);
        } catch(Exception e) { if(txn != null) { txn.rollback(); }
        e.printStackTrace();
        } finally {
            if(session != null) { session.close(); }
        }
    }
    
   static void  insertTest(){
        Department dep = new Department(0, "Sl", "Sales");
        Address address = new Address("25 Street", "ML Sity", "USA");
        Employee emp = new Employee(0,"Ahmed" , dep, address);
        insertDepartment(dep);
        insertEmployee(emp);
    }
}
