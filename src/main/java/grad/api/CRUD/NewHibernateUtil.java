/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grad.api.CRUD;

import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;


public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
//            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            sessionFactory = new Configuration().configure("/grad/api/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
