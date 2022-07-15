package com.cisco;

import com.cisco.entity.Customer;
import com.cisco.entity.Order;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo03 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer c002 = new Customer("C002", "Sovis", "Dehiwala");
            Order od003 = new Order("OD003", Date.valueOf("2022-07-23"), c002);

            session.save(od003);
            session.getTransaction().commit();
        }
    }
}
