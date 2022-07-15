package com.cisco;

import com.cisco.entity.Vehicle2;
import com.cisco.entity.Vehicle2Employee2;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToOneDemo13 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Vehicle2 v005 = session.get(Vehicle2.class, "V005");
            System.out.println(v005);


            session.getTransaction().commit();
        }
    }
}
