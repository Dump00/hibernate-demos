package com.cisco;


import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadDemo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Student student = session.load(Student.class, 1);
            System.out.println(student);
            session.getTransaction().commit();
        }
    }
}
