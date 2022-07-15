package com.cisco;

import com.cisco.entity.Customer;
import com.cisco.entity.Order;
import com.cisco.entity.Vehicle2;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo01 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer c001 = new Customer("C001", "Pathum", "Galle");

            Order od001 = new Order("OD001", Date.valueOf("2022-07-12"), c001);
            Order od002 = new Order("OD002", Date.valueOf("2022-07-15"), c001);

            session.save(c001);
            session.save(od001);
            session.save(od002);

            session.getTransaction().commit();
        }
    }
}
