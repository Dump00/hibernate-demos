package com.cisco;


import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersistDemo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Student pathum = new Student(2, "Pathum", "Matara", "0771234568");
            session.persist(pathum);
            session.getTransaction().commit();
        }
    }
}
