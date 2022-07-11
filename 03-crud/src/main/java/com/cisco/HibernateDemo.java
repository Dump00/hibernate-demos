package com.cisco;


import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateDemo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Student cisco = new Student(1, "Cisco", "Mt Lavinia", "0771234567");
            session.save(cisco);
            session.getTransaction().commit();
        }
    }
}
