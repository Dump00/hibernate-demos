package com.cisco;


import com.cisco.entity.Student;
import com.cisco.entity.Teacher;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemoThree {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            // transient/new state => exception
            Teacher dinusha = new Teacher("Dinusha", "0111234568");
            session.refresh(dinusha);
            session.getTransaction().commit();
        }
    }
}
