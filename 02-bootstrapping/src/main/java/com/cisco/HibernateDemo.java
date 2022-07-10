package com.cisco;


import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateDemo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){
            System.out.println(session);
        }
    }
}
