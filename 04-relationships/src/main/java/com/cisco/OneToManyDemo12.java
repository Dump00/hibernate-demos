package com.cisco;

import com.cisco.entity.Customer2;
import com.cisco.entity.Order2;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyDemo12 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            

            session.getTransaction().commit();
        }
    }
}
