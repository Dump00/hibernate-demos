package com.cisco;

import com.cisco.entity.Employee2;
import com.cisco.entity.Vehicle2;
import com.cisco.entity.Vehicle2Employee2;
import com.cisco.entity.Vehicle2Employee2PK;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToOneDemo12 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Vehicle2Employee2 ve005 = new Vehicle2Employee2("V005", "E003", Date.valueOf("2022-07-15"));
            Vehicle2 v005 = new Vehicle2("V005", "Lambo", ve005);

            session.persist(v005);


            session.getTransaction().commit();
        }
    }
}
