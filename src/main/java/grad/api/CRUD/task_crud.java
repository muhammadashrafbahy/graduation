/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grad.api.CRUD;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
//import java.util.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import grad.api.Entities.task;

/**
 *
 * @author MUHAMMAD ASHRAF BAHY
 */
public class task_crud {
    
    public task add_task(task tsk){
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        task tsknew = tsk;
        try {
            tr = se.beginTransaction();
            
            se.save(tsknew);
            System.out.println("added the task");
            tr.commit();
       } catch (Exception e) {
    if(tr!= null){
    tr.rollback();
    }
         e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
        }
    return tsknew;
    }
    
    public task delete_task(int id){
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        task tsknew =new task();
        try {
            tr = se.beginTransaction();
            Criteria q = se.createCriteria(task.class);
            List<task> list = new ArrayList<task>();
            list = q.add(Restrictions.eq("task_id", id)).list();
            if (list.size() !=0) {
                tsknew= list.get(0);
                se.delete(tsknew);
          System.out.println("deleted the task");  }else{
            System.out.println("can not found  the task");}
            tr.commit();
       } catch (Exception e) {
    if(tr!= null){
    tr.rollback();
    }
         e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
        }
    return tsknew;
    }
    

    public task update_task(int id , task task){
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        task tsknew =new task();
        try {
            tr = se.beginTransaction();
            Criteria q = se.createCriteria(task.class);
            List<task> list = new ArrayList<task>();
            list = q.add(Restrictions.eq("task_id", id)).list();
            if (list.size() !=0) {
                tsknew= list.get(0);
                tsknew.setExp_date(task.getExp_date());
               
                tsknew.setStart_date(task.getStart_date());
                tsknew.setTask_city(task.getTask_city());
                tsknew.setTask_country(task.getTask_country());
                tsknew.setTask_descript(task.getTask_descript());
                tsknew.setTask_dist(task.getTask_dist());
                tsknew.setTask_name(task.getTask_name());
                tsknew.setTask_lat(task.getTask_lat());
                tsknew.setTask_long(task.getTask_long());
                tsknew.setClient_name(task.getClient_name());
                tsknew.setState(task.getState());
                tsknew.setEmp_id(task.getEmp_id());
                tsknew.setTask_id(id);
                se.update(tsknew);
          System.out.println("updated the task");  }else{
            System.out.println("can not found  the task");}
            tr.commit();
       } catch (Exception e) {
    if(tr!= null){
    tr.rollback();
    }
         e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
       
    return tsknew;
    }}
  

    public task repeat_task(int id , task task){
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        task tsknew =new task();
        try {
            tr = se.beginTransaction();
            Criteria q = se.createCriteria(task.class);
            List<task> list = new ArrayList<task>();
            list = q.add(Restrictions.eq("task_id", id)).list();
            if (list.size() !=0) {
                tsknew= list.get(0);
                tsknew.setExp_date(task.getExp_date());
               
                tsknew.setStart_date(task.getStart_date());
      
                tsknew.setState("notDone");
                tsknew.setEmp_id(task.getEmp_id());
                tsknew.setTask_id(id);
                se.update(tsknew);
          System.out.println("repeated the task");  }else{
            System.out.println("can not found  the task");}
            tr.commit();
       } catch (Exception e) {
    if(tr!= null){
    tr.rollback();
    }
         e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
       
    return tsknew;
    }}
  

    public task assign_task(int id , task task , int emp_id){
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        task tsknew =new task();
        try {
            tr = se.beginTransaction();
            Criteria q = se.createCriteria(task.class);
            List<task> list = new ArrayList<task>();
            list = q.add(Restrictions.eq("task_id", id)).list();
            if (list.size() !=0) {
                tsknew= list.get(0);
                
                employee_crud emcr = new employee_crud();
               
                
                tsknew.setExp_date(task.getExp_date());
               
                tsknew.setStart_date(task.getStart_date());
                tsknew.setTask_city(task.getTask_city());
                tsknew.setTask_country(task.getTask_country());
                tsknew.setTask_descript(task.getTask_descript());
                tsknew.setTask_dist(task.getTask_dist());
                tsknew.setTask_name(task.getTask_name());
                tsknew.setTask_lat(task.getTask_lat());
                tsknew.setTask_long(task.getTask_long());
                tsknew.setClient_name(task.getClient_name());
                tsknew.setState(task.getState());
                tsknew.setEmp_id(emp_id);
                tsknew.setTask_id(id);
                emcr.task_empl(emp_id, tsknew);
                se.update(tsknew);
          System.out.println("asssigned the task");  }else{
            System.out.println("can not found  the task");}
            tr.commit();
       } catch (Exception e) {
    if(tr!= null){
    tr.rollback();
    }
         e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
       
    return tsknew;
    }}
    
    public List<task> get_taskByname(task  tasks){
 
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        task tsknew =new task();
        List<task> list = new ArrayList<task>();
        try {
            tr = se.beginTransaction();
            Criteria q = se.createCriteria(task.class);
            
            list = q.add(Restrictions.eq("client_name", tasks.getClient_name())).list();
            if (list.size() !=0) {
            System.out.println("found the task "+list.size()); 
            return list;
              
          
            }else{   	System.out.println("here in task name search");
            System.out.println("can not found  the task");}
            tr.commit();
       } catch (Exception e) {
    if(tr!= null){
    tr.rollback();
    }
         e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
       
    return list;
    }}
    public List<task> get_taskBystatue(task  tasks){
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        task tsknew =new task();
        List<task> list = new ArrayList<task>();
        try {
            tr = se.beginTransaction();
            Criteria q = se.createCriteria(task.class);
            
            list = q.add(Restrictions.eq("state", tasks.getState())).list();
            if (list.size() !=0) {
            System.out.println("found the task "+list.size()); 
            return list;
              
          
            }else{
            System.out.println("can not found  the task");}
            tr.commit();
       } catch (Exception e) {
    if(tr!= null){
    tr.rollback();
    }
         e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
       
    return list;
    }}
    public List<task> get_taskBydate(task tasks) {
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        task tsknew =new task();
        List<task> list = new ArrayList<task>();
        Date  from = tasks.getStart_date();
        Date  to = tasks.getExp_date();
        try {
            tr = se.beginTransaction();
            Criteria q = se.createCriteria(task.class);
            
            list = q.add(Restrictions.between("start_date", from, to)).list();
            if (list.size() !=0) {
            System.out.println("found the task "+list.size()); 
            return list;
              
          
            }else{
            System.out.println("can not found  the task");}
            tr.commit();
       } catch (Exception e) {
    if(tr!= null){
    tr.rollback();
    }
         e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
       
    return list;
    }}
    
  
    public List<task> public_search (task tsk){
    	task_crud tcr = new task_crud();
    	if (tsk.getClient_name()!=null) {
	       return 		tcr.get_taskByname(tsk);
		} 
    	
    	
    	if (tsk.getStart_date()!=null|| tsk.getExp_date()!=null) {
 	       return 		tcr.get_taskBydate(tsk);
 		} 
    	
    	return tcr.get_taskBystatue(tsk);
    }
    
   
    
    
    public task get_task(int id ){
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        task tsknew =new task();
        try {
            tr = se.beginTransaction();
            Criteria q = se.createCriteria(task.class);
            List<task> list = new ArrayList<task>();
            list = q.add(Restrictions.eq("task_id", id)).list();
            if (list.size() !=0) {
                tsknew= list.get(0);
               
          System.out.println("found the task");  }else{
            System.out.println("can not found  the task");}
            tr.commit();
       } catch (Exception e) {
    if(tr!= null){
    tr.rollback();
    }
         e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
       
    return tsknew;
    }}
  
    
    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
///        Date d1= c.getTime();
        
        Date d1= new Date(2020, 12, 31);
        Date d2 = new Date(2024, 12, 31);
       
        task tsk = new task( "new","notDone",2,1.0, 2.0, d1, d2,  "desc", "taskat ya bahy", "cairo", "egypt", "kafr");
        task_crud cr = new task_crud();
//        cr.add_task(tsk);
       cr.delete_task(9);
//        cr.update_task(1, tsk);
        
   Date ds1= new Date(2016, 2, 13);
        Date ds2 = new Date(2019, 2, 13);
        task search = new task();

//        search.setStart_date(d1);
//        search.setExp_date(d2);
        search.setTask_name("new");
//        List<task> list = cr.public_search(search);
////
//        for (int i = 0; i < list.size(); i++) {
//            task elem = list.get(i);
//              System.out.println("here U R  = "+elem.getTask_id());
//        }
//
//        
        
        
        
//        cr.get_task(8);
        
        
        
    }
}
