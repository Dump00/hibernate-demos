package com.cisco;

import com.cisco.entity.Customer2;
import com.cisco.entity.Order2;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo08 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Order2 od003 = session.get(Order2.class, "OD003");
            System.out.println(od003.getCustomer2());
            od003.setCustomer2(null);

            session.getTransaction().commit();
        }
    }
}
