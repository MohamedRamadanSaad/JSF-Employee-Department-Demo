/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.dao;


import com.hibernate.model.Employee;
import com.hibernate.service.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mohamed Ramadan
 */
public class EmployeeDAO {

    public ArrayList<Employee> getEmployeeList() {

        Session session = null;
        ArrayList<Employee> empList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String queryStr = "select emp from Employee emp";
            Query query = session.createQuery(queryStr);
            empList = (ArrayList<Employee>) query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            // handle exception here
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex) {
            }
        }
        return empList;
    }
    
    public Employee getEmployeeById(int empId){
 
        Session session = null;
        Employee emp = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String queryStr = "select emp from Employee emp";
            emp = (Employee) session.get(Employee.class, empId);
 
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return emp;
    }
    
     public void insertEmployee(Employee emp) {
 
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(emp);
            System.out.println("inserted employee: "+emp.getName());
            transaction.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
            if(transaction != null) transaction.rollback();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
    }
     
      public void deleteEmployee(Employee emp) {
 
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(emp);
            transaction.commit();
            System.out.println("deleted employee: "+emp.getName());
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
            if(transaction != null) transaction.rollback();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
    }
      public void updateEmployee(Employee emp) {
 
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(emp);
            System.out.println("Updated employee: "+emp.getName());
            transaction.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
            if(transaction != null) transaction.rollback();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
    }
}
