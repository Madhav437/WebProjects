/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.hwmvc.dao;

import edu.neu.hwmvc.model.Customer;
import edu.neu.hwmvc.model.Orders;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;


public class CustomerDao extends BaseDao {
    
    public List<Customer> getTodos() {
        List<Customer> todos = new ArrayList<>();
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Customer", Customer.class);
            todos = q.list();
        } catch (HibernateException e) {
            rollbackTransaction();
        } finally {
            close();
        }
        return todos;
    }
    
    public Customer getTodo(Integer todoId) {
        Customer todo = null;
        try {
            beginTransaction();
            todo = getSession().find(Customer.class, todoId);
            commit();
        } catch (HibernateException e) {
            getSession().getTransaction().rollback();
        } finally {
            getSession().close();
        }       
        return todo;
    }
    
    public int addTodo(Customer ord) {
         int result = 0;
         try {
        	 beginTransaction();
        	 getSession().save(ord);
        	 commit();
        	 result = 1;
        	 
         } catch (HibernateException e) {
        	 getSession().getTransaction().rollback();
        	 
        	 
         }finally {
        	 getSession().close();
         }
         return result;
    }
    
    public int deleteTodo(Integer todoId) {
    	 int result = 0;
         try {
        	 beginTransaction();
        	 Customer todo = getSession().find(Customer.class, todoId);
        	 getSession().delete(todoId);
        	 commit();
        	 result = 1;
        	 
         } catch (HibernateException e) {
        	 getSession().getTransaction().rollback();
        	 
        	 
         }finally {
        	 getSession().close();
         }
         return result;
    }
    
    public int updateTodo(Integer todoId, String name) {
    	int result = 0;
        try {
       	 beginTransaction();
       	 Customer todo = getSession().find(Customer.class, todoId);
       	// todo.setCarName(name);
       	 getSession().update(todoId);
       	 commit();
       	 result = 1;
       	 
        } catch (HibernateException e) {
       	 getSession().getTransaction().rollback();
       	 
       	 
        }finally {
       	 getSession().close();
        }
        return result;
   }
    
    @SuppressWarnings("deprecation")
	public Customer getUser(String email, String password) { 
    	
    	Customer cus = null;
       
        try {
            beginTransaction();
            Query q = getSession().createQuery("FROM Customer C WHERE C.userEmail =: email and "
            		+ "C.userPassword =: cpass");
          
            q.setParameter("email", email);
            q.setParameter("cpass", password);
            cus = (Customer)q.uniqueResult();
           
           
        } catch (HibernateException e) {
            rollbackTransaction();
        } finally {
            close();
        }
        
        return cus;   
        
    }
    
    
    public int updateUser(Integer todoId, Customer cusparm) {
    	int result = 0;
        try {
       	 beginTransaction();
       	 Customer custodo = getSession().find(Customer.class, todoId);
       	 custodo.setFirstName(cusparm.getFirstName());
       	 custodo.setLastName(cusparm.getLastName());
       	 custodo.setAddress(cusparm.getAddress());
       	 custodo.setPhone(cusparm.getPhone());
       	 custodo.setZipCode(cusparm.getZipCode());
       	
       	 getSession().update(custodo);
       	 commit();
       	 result = 1;
       	 
        } catch (HibernateException e) {
       	 getSession().getTransaction().rollback();
       	 
       	 
        }finally {
       	 getSession().close();
        }
        return result;
   }
    
    
public Customer getUserWithName(String email) { 
    	
    	Customer cus = null;
       
        try {
            beginTransaction();
            Query q = getSession().createQuery("FROM Customer C WHERE C.userEmail =: email");
          
            q.setParameter("email", email);
           
            cus = (Customer)q.uniqueResult();
           
           
        } catch (HibernateException e) {
            rollbackTransaction();
        } finally {
            close();
        }
        
        return cus;   
        
    }
    
 
}
    

