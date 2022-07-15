package com.cisco;

import com.cisco.entity.Customer;
import com.cisco.entity.Order;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo04 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            /* try this with a customer who has more than one order */
            Order od003 = session.get(Order.class, "OD003");
            session.remove(od003);

            session.getTransaction().commit();
        }
    }
}
