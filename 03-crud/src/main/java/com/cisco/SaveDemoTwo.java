package com.cisco;


import com.cisco.entity.Student;
import com.cisco.entity.Teacher;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class SaveDemoTwo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();

//            Teacher chandima = new Teacher("Chandima", "0771234569");
//            Serializable id1 = session.save(chandima);
//            System.out.println(chandima);
//            System.out.println(id1);
//            System.out.println("In Context: " + session.contains(chandima));

            Teacher sovis = new Teacher("Sovis", "0771234569");
            session.persist(sovis);
            System.out.println(sovis);
            System.out.println("In Context: " + session.contains(sovis));

            session.getTransaction().commit();
        }
    }
}
