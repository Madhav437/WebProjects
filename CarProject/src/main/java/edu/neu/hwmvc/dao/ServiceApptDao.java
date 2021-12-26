/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.hwmvc.dao;

import edu.neu.hwmvc.model.Orders;
import edu.neu.hwmvc.model.Serviceapt;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;


public class ServiceApptDao extends BaseDao {
    
    public List<Serviceapt> getTodos() {
        List<Serviceapt> todos = new ArrayList<>();
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Serviceapt", Serviceapt.class);
            todos = q.list();
        } catch (HibernateException e) {
            rollbackTransaction();
        } finally {
            close();
        }
        return todos;
    }
    
    public Serviceapt getTodo(Integer todoId) {
    	Serviceapt todo = null;
        try {
            beginTransaction();
            todo = getSession().find(Serviceapt.class, todoId);
            commit();
        } catch (HibernateException e) {
            getSession().getTransaction().rollback();
        } finally {
            getSession().close();
        }       
        return todo;
    }
    
    public int addTodo(Serviceapt serv) {
         int result = 0;
         try {
        	 beginTransaction();
        	 getSession().save(serv);
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
        	 Serviceapt todo = getSession().find(Serviceapt.class, todoId);
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
       	 Serviceapt todo = getSession().find(Serviceapt.class, todoId);
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
    
    public List<Serviceapt> getServApt(int custprmId) {
        List<Serviceapt> todos = new ArrayList<>();
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Serviceapt s where s.customer.custId =: custprmId" );
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

