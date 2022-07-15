package com.cisco;

import com.cisco.entity.Customer;
import com.cisco.entity.Order;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo02 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Order od001 = session.get(Order.class, "OD001");
            System.out.println(od001);

            session.getTransaction().commit();
        }
    }
}
