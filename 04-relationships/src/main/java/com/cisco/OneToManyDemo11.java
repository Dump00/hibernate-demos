package com.cisco;

import com.cisco.entity.Customer2;
import com.cisco.entity.Order2;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyDemo11 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer2 c002 = session.get(Customer2.class, "C002");
            Order2 od003 = session.get(Order2.class, "OD003");

            c002.removeOrder(od003);

            session.getTransaction().commit();
        }
    }
}
