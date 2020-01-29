/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.dao;

import com.hibernate.model.Department;
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
public class DepartmentDAO {
     public void insertDepartment(Department dep) {
 
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(dep);
            System.out.println("inserted department: "+dep.getName());
            transaction.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
            if(transaction != null) transaction.rollback();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
    }
      public List<Department> getDepartmentList() {

        Session session = null;
        ArrayList<Department> departmentList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String queryStr = "select dep from Department dep";
            Query query = session.createQuery(queryStr);
            departmentList = (ArrayList<Department>) query.list();
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
        return departmentList;
    }
      public Department getDepartmentById(int depId){
 
        Session session = null;
        Department dep = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String queryStr = "select dep from Department dep";
            dep = (Department) session.get(Department.class, depId);
 
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return dep;
    }
}
