package com.cisco;


import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemoOne {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Student student = session.get(Student.class, 2);
            student.setContactNumber("0711234568");
            System.out.println(student);
            session.refresh(student);
            System.out.println(student);
            session.getTransaction().commit();
        }
    }
}
