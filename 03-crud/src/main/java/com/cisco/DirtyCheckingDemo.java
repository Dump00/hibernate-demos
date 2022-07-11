package com.cisco;


import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DirtyCheckingDemo {

    /**
        * Dirty Checking for updating
     */

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Student pathum = session.get(Student.class, 2);
            pathum.setContactNumber("0711234568");
            session.getTransaction().commit();
        }
    }
}
