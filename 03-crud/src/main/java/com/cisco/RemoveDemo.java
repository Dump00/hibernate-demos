package com.cisco;


import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RemoveDemo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Student pathum = session.get(Student.class, 2);
            System.out.println("In Context: " + session.contains(pathum));
            session.remove(pathum);
            //session.delete(pathum);
            System.out.println("In Context: " + session.contains(pathum));
            session.getTransaction().commit();
        }
    }
}
