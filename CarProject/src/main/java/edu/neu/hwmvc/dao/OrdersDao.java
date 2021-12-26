/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.hwmvc.dao;

import edu.neu.hwmvc.model.Orders;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;


public class OrdersDao extends BaseDao {
    
    public List<Orders> getTodos() {
        List<Orders> todos = new ArrayList<>();
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Orders", Orders.class);
            todos = q.list();
        } catch (HibernateException e) {
            rollbackTransaction();
        } finally {
            close();
        }
        return todos;
    }
    
    public Orders getTodo(Integer todoId) {
        Orders todo = null;
        try {
            beginTransaction();
            todo = getSession().find(Orders.class, todoId);
            commit();
        } catch (HibernateException e) {
            getSession().getTransaction().rollback();
        } finally {
            getSession().close();
        }       
        return todo;
    }
    
    public int addTodo(Orders ord) {
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
        	 Orders todo = getSession().find(Orders.class, todoId);
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
    
    
    // Select Orders based on Customer
    
    
    public Orders getCustTodo(Integer todoId) {
        Orders todo = null;
        try {
            beginTransaction();
            todo = getSession().find(Orders.class, todoId);
            commit();
        } catch (HibernateException e) {
            getSession().getTransaction().rollback();
        } finally {
            getSession().close();
        }       
        return todo;
    }
    
    public int updateTodo(Integer todoId, String name) {
    	int result = 0;
        try {
       	 beginTransaction();
       	 Orders todo = getSession().find(Orders.class, todoId);
       	 todo.setCarName(name);
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
    
    public List<Orders> getCustOrd(int custprmId) {
        List<Orders> todos = new ArrayList<>();
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Orders o where o.customer.custId =: custprmId" );
            q.setParameter("custprmId", custprmId);
            todos = q.list();
        } catch (HibernateException e) {
            rollbackTransaction();
        } finally {
            close();
        }
        return todos;
    }
    
   
    
    }

