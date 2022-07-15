package com.cisco;

import com.cisco.entity.Customer2;
import com.cisco.entity.Order2;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo07 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer2 c001 = new Customer2("C001", "Pathum", "Galle");
            Customer2 c002 = new Customer2("C002", "Sovis", "Moratuwa");

            Order2 od001 = new Order2("OD001", Date.valueOf("2022-07-12"));
            Order2 od002 = new Order2("OD002", Date.valueOf("2022-07-15"), c001);
            Order2 od003 = new Order2("OD003", Date.valueOf("2022-07-16"), c001);


            session.save(c002);

            session.save(od001);

            session.persist(od002);
            session.persist(od003);

            session.getTransaction().commit();
        }
    }
}
