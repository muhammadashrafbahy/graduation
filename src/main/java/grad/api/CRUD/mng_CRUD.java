/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grad.api.CRUD;

import grad.api.CRUD.*;
import grad.api.Entities.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

/**
 *
 * @author MUHAMMAD ASHRAF BAHY
 */
@Service
public class mng_CRUD {
	
	
	
	
	public void insert_login(login login) {
		Session se = NewHibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;
		
		try {
			
			tr =se.beginTransaction();
			se.save(login);
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

		
	}
	
	public manager update_mng (int id , manager mng ) {

		Session se = NewHibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;
		List<manager> res = new ArrayList<manager>();
		manager n_mng = new manager();
		    try {
		        tr=se.beginTransaction();
		        Criteria q = se.createCriteria(manager.class);
		        
		      
		        
//		        LogicalExpression and = Restrictions.and(c1, c2);
		        
		        res=  q.add(Restrictions.eq("id", id)).list();
		        
		        if (res.size() >0) {
		        	mng.setId(id);
		        	se.update(mng);
				}
		     
		        
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

		return mng;
		
		
		
	}
	
	
	public manager tsk_mng (int id , task tsk ) {

		Session se = NewHibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;
		List<task> res = new ArrayList<task>();
		manager n_mng = new manager();
		List<manager> mg = new ArrayList<manager>();
		    try {
		        tr=se.beginTransaction();
		        Criteria q = se.createCriteria(manager.class);
		        
		      
		        
//		        LogicalExpression and = Restrictions.and(c1, c2);
		        mg =q.add(Restrictions.eq("id", id)).list();
		        if (mg.size()>0) {
					
				System.out.println("founddddd mnaager");
		        n_mng= (manager) mg.get(0);
                res =n_mng.getTsk_list();
		        res.add(tsk);


		         n_mng.setTsk_list(res);
		       se.update(n_mng);
		        }
		        else {System.out.println("noooooooooot found");}
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

		return n_mng;
		
		
		
	}
   

	public manager cl_mng (int id , clients cl ) {

		Session se = NewHibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;
		List<clients> res = new ArrayList<clients>();
		manager n_mng = new manager();
		List<manager> mg = new ArrayList<manager>();
		    try {
		        tr=se.beginTransaction();
		        Criteria q = se.createCriteria(manager.class);
		        
		      
		        
//		        LogicalExpression and = Restrictions.and(c1, c2);
		        mg =q.add(Restrictions.eq("id", id)).list();
		        if (mg.size()>0) {
					
				System.out.println("founddddd mnaager");
		        n_mng= (manager) mg.get(0);
		        res=n_mng.getCl_list();
		        res.add(cl);
		         n_mng.setCl_list(res);
		       se.update(n_mng);
		        }
		        else {System.out.println("noooooooooot found");}
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

		return n_mng;
		
		
		
	}
   
	public manager emp_mng (int id , employee emp ) {

		Session se = NewHibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;
		List<employee> res = new ArrayList<employee>();
		manager n_mng = new manager();
		List<manager> mg = new ArrayList<manager>();
		    try {
		        tr=se.beginTransaction();
		        Criteria q = se.createCriteria(manager.class);
		        
		      
		        
//		        LogicalExpression and = Restrictions.and(c1, c2);
		        mg =q.add(Restrictions.eq("id", id)).list();
		        if (mg.size()>0) {
					
				System.out.println("founddddd mnaager");
		        n_mng= (manager) mg.get(0);
		        res=n_mng.getEmpl_list();
		        res.add(emp);
		         n_mng.setEmpl_list((res));
		       se.update(n_mng);
		        }
		        else {System.out.println("noooooooooot found");}
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

		return n_mng;
		
		
		
	}
   
	
	
	
	
	public manager add_mng(manager mng){
    Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        manager manager =mng;
        try {
            tr = se.beginTransaction();

            se.save(manager);
            tr.commit();

        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            System.out.println(e.getMessage() + "herererer");
        } finally {
            se.flush();
            se.close();
        }
        return manager;
	}   

public manager login(String email , String passwd){
Session se = NewHibernateUtil.getSessionFactory().openSession();
Transaction tr = null;
manager res = new manager(); ;
    try {
        tr=se.beginTransaction();
        Criteria q = se.createCriteria(manager.class);
        
        Criterion c1 = Restrictions.eq("comp_email", email);
        Criterion c2 = Restrictions.eq("comp_passwd", passwd);
        
        LogicalExpression and = Restrictions.and(c1, c2);
        
        q.add(and);
        
        if  (q.list().size() != 0) {
            System.out.println("success login");
        res = (manager) q.list().get(0);        
        
        }else {
            System.out.println("success failed");
        }
        
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

return res;
} 

public List<manager> all_comp(){
Session se = NewHibernateUtil.getSessionFactory().openSession();
Transaction tr = null;
List<manager> res = new ArrayList<manager>();
    try {
        tr=se.beginTransaction();
        Criteria q = se.createCriteria(manager.class);
        
      
        
//        LogicalExpression and = Restrictions.and(c1, c2);
        
        res= q.add(Restrictions.gt("id", 0)).list();
        
        if  (res.size()!= 0) {
            System.out.println("success get");
       
        
        }else {
            System.out.println(" failed get");
        }
        
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

return res;
} 


public manager get_info (int id) {
	Session se = NewHibernateUtil.getSessionFactory().openSession();
	Transaction tr = null;
	manager res = new manager();
	    try {
	        tr=se.beginTransaction();
	        Criteria q = se.createCriteria(manager.class);
	        
	      
	        
//	        LogicalExpression and = Restrictions.and(c1, c2);
	        
	        res= (manager) q.add(Restrictions.eq("id", id)).list().get(0);
	        
	     
	        
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

	return res;
	
	
	
}




public List<employee> get_allEmp(int id) {
	
	
	Session se = NewHibernateUtil.getSessionFactory().openSession();
	Transaction tr = null;
	List <employee> res = new ArrayList<employee>();
	manager mg = new manager();
	    try {
	        tr=se.beginTransaction();
	        Criteria q = se.createCriteria(manager.class);
	        
	      
	        
//	        LogicalExpression and = Restrictions.and(c1, c2);
	        
	        mg= (manager) q.add(Restrictions.eq("id", id)).list().get(0);
	           
	        res =mg.getEmpl_list();
	     for (employee emps : res) {
			System.out.println("empl name => "+emps.getEmp_username());
		}
	        
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

	return res;
	
	
	
}




public List<clients> get_allClients(int id) {
	
	
	Session se = NewHibernateUtil.getSessionFactory().openSession();
	Transaction tr = null;
	List <clients> res = new ArrayList<clients>();
	manager mg = new manager();
	    try {
	        tr=se.beginTransaction();
	        Criteria q = se.createCriteria(manager.class);
	        
	      
	        
//	        LogicalExpression and = Restrictions.and(c1, c2);
	        
	        mg= (manager) q.add(Restrictions.eq("id", id)).list().get(0);
	           
	        res =mg.getCl_list();
	     for (clients clients : res) {
			System.out.println("client name => "+clients.getClient_fname());
		}
	        
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

	return res;
	
	
	
}





public List<task> get_allTasks(int id) {
	
	
	Session se = NewHibernateUtil.getSessionFactory().openSession();
	Transaction tr = null;
	List <task> res = new ArrayList<task>();
	manager mg = new manager();
	    try {
	        tr=se.beginTransaction();
	        Criteria q = se.createCriteria(manager.class);
	        
	      
	        
//	        LogicalExpression and = Restrictions.and(c1, c2);
	        
	        mg= (manager) q.add(Restrictions.eq("id", id)).list().get(0);
	           
	        res =mg.getTsk_list();
	     for (task tsks : res) {
			System.out.println("tasks name => "+tsks.getTask_name());
		}
	        
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

	return res;
	
	
	
}








public login check_login (String email ) {
	Session se = NewHibernateUtil.getSessionFactory().openSession();
	Transaction tr = null;
	
	List<login> list= new ArrayList<login>();
	    try {
	        tr=se.beginTransaction();
	        Criteria q = se.createCriteria(login.class);
	        
	      Criterion c1 = Restrictions.eq("username", email);

//	        LogicalExpression and = Restrictions.and(c1, c2);
	        

	       list=  q.add(c1).list();
	     if (list.size()>0) {
	    	 System.out.println("Login successsssss");
			return list.get(0);
		}
	        
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

	return null;
	
	
	
}








    public static void main(String[] args) {
        
      
        manager mng = new manager("bahy", "passwd1", "@yahoo", "www.com", "ball", "alex", "alex", "heleopilis", 0.0, 0.0, "01009126166");
        mng_CRUD cr = new mng_CRUD();
//        cr.add_mng(mng);
        
        
//        
//        Date d1= new Date(2020, 12, 31);
//        Date d2 = new Date(2024, 12, 31);
//        task tsk = new task( "bahy",false,1,1.0, 2.0, d1, d2,  "desc", "taskat ya bahy", "cairo", "egypt", "kafr" );
//        tsk.setTask_id(2);
//        cr.tsk_mng(1 , tsk);

        
//        clients cl = new clients(1, 1, "abed", "hamad", "01285684022", "egypt", "alex", "bishr");
//       client_crud ccr = new client_crud();
//             cr.cl_mng(1, ccr.add_client(cl))   ;
       

        
//        cr.get_allClients(1);
        
//        cr.get_allEmp(1);
        
//        cr.get_allTasks(1);
        
        
mng= cr.login("@yahoo","passwd1");
//        List<manager> list= cr.all_comp();
//        for (int i = 0; i < list.size(); i++) {
//            manager elem = list.get(i);
//            System.out.println("info ---->"+elem.getComp_name());
//        }
    }
}
