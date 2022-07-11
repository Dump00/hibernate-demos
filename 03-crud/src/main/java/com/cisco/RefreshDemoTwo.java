package com.cisco;


import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemoTwo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            // If we specify a PRIMARY KEY, Hibernate initially guess this record resides in the DB and treat this as a
            // entity in a detached state.
            //Student student = new Student(3, "Aruni", "Matara", "0111234567");
            Student student = session.get(Student.class, 2);
            session.evict(student);
            System.out.println("Student has been detached");
            System.out.println("In Context: " + session.contains(student));
            session.refresh(student);
            System.out.println("In Context: " + session.contains(student));
            session.getTransaction().commit();
        }
    }
}
