package com.cisco;


import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();

            Student student = session.get(Student.class, 2);
            session.detach(student);
            System.out.println("In Context: " + session.contains(student));
            Student cloned = (Student) session.merge(student);
            student.setAddress("Galle");
            System.out.println(student);
            System.out.println("In Context: " + session.contains(student));
            System.out.println("====");
            cloned.setAddress("Panadura");
            System.out.println(cloned);
            System.out.println("In Context: " + session.contains(cloned));

            session.getTransaction().commit();
        }
    }
}
