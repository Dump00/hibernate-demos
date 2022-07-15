package com.cisco;

import com.cisco.entity.*;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToOneDemo08 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee2 e001 = new Employee2("E001", "Pathum", "Galle");
            Employee2 e002 = new Employee2("E002", "Sovis", "Dehiwala");
            Employee2 e003 = new Employee2("E003", "Dinusha", "Gampaha");

            Vehicle2 v001 = new Vehicle2("V001", "Car");
            Vehicle2 v002 = new Vehicle2("V002", "Bike");
            Vehicle2 v003 = new Vehicle2("V003", "Van");

            session.save(e001);
            session.save(e002);
            session.save(e003);

            session.save(v001);
            session.save(v002);
            session.save(v003);

            session.getTransaction().commit();
        }
    }
}
