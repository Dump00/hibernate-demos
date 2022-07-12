package com.cisco;


import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveOrUpdateDemo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();

            Student student1 = new Student(2, "Pathum", "Galle", "0111234567");
            Student student2 = new Student(3, "Manoj", "Colombo", "0111234568");

            session.saveOrUpdate(student1);
            System.out.println("Student1 has been saved!");
            session.saveOrUpdate(student2);
            System.out.println("Student2 has been saved!");

            session.getTransaction().commit();
        }
    }
}
