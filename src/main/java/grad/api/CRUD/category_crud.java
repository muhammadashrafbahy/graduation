package grad.api.CRUD;

import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import grad.api.Entities.*;

public class category_crud {
	
	public category add_cat(category cat) {
		
		Session se = NewHibernateUtil.getSessionFactory().openSession();
		Transaction tr= null;
	try {
	tr = se.beginTransaction();
		se.save(cat);
	
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
		
	return cat;
	}

	
	
	public category delete_cat(int  id) {
		
		Session se = NewHibernateUtil.getSessionFactory().openSession();
		Transaction tr= null;
		category cat = new category();
	try {
		tr = se.beginTransaction();
		Criteria q = se.createCriteria(category.class);
		cat=(category) q.add(Restrictions.eq("categ_id", id)).list().get(0);
	
		
		se.delete(cat);
	
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
		
		
		return cat;
		
	}
	
	
public category update_cat(int id, category cat) {
		
	Session se = NewHibernateUtil.getSessionFactory().openSession();
	Transaction tr= null;
category nc ;
try {
	tr = se.beginTransaction();
	Criteria q = se.createCriteria(category.class);
	nc=(category) q.add(Restrictions.eq("categ_id", id)).list().get(0);
nc.setCateg_type(cat.getCateg_type());
	se.update(nc);
     
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
	
	
	return cat;
	}
	
public List<category>  get_allCat (){
	
	Session se = NewHibernateUtil.getSessionFactory().openSession();
	Transaction tr= null;
	List <category> cat = new ArrayList< category>();
try {
	tr = se.beginTransaction();
	Criteria q = se.createCriteria(category.class);
	cat= q.add(Restrictions.gt("categ_id", 0)).list();

	
	

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
	
	
	return cat;
	
	
}



public category get_cat(int id) {
	Session se = NewHibernateUtil.getSessionFactory().openSession();
	Transaction tr= null;
	category cat = new category();
try {tr = se.beginTransaction();

	Criteria q = se.createCriteria(category.class);
	cat=(category) q.add(Restrictions.eq("categ_id", id)).list().get(0);

	
	

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
	
	
	return cat;
	
}



public category cl_cat(int  id , clients cl) {
	
	Session se = NewHibernateUtil.getSessionFactory().openSession();
	Transaction tr= null;
	category cat = new category();
	List<clients > cl_list = new ArrayList<clients>();
cl_list.add(cl);
	try {
		tr = se.beginTransaction();
	Criteria q = se.createCriteria(category.class);
	cat=(category) q.add(Restrictions.eq("categ_id", id)).list().get(0);

	cat.setClient_list(cl_list);
	se.update(cat);

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
	
	
	return cat;
	
}


public static void  main(String args[]) {

	category c = new category( "damn");
	
	category_crud cr = new category_crud();
	
//	cr.add_cat(c);
	
	cr.update_cat(11, c);
	
//	cr.delete_cat(0);
}
}
