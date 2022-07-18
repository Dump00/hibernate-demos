package com.cisco;

import com.cisco.entity.Actor;
import com.cisco.entity.Movie;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo04 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();



            session.getTransaction().commit();
        }
    }
}
