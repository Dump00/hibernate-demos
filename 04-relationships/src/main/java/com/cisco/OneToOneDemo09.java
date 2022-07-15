package com.cisco;

import com.cisco.entity.Employee2;
import com.cisco.entity.Vehicle2;
import com.cisco.entity.Vehicle2Employee2;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToOneDemo09 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            //Vehicle2Employee2 v2e2 = new Vehicle2Employee2("V002", "E002", Date.valueOf("2022-07-15"));
            Vehicle2Employee2 v2e2 = new Vehicle2Employee2("V003", "E001", Date.valueOf("2022-07-15"));

            session.save(v2e2);

            session.getTransaction().commit();
        }
    }
}
