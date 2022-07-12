package com.cisco;

import com.cisco.entity.Employee;
import com.cisco.entity.Spouse;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo04 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();



            session.getTransaction().commit();
        }
    }
}
