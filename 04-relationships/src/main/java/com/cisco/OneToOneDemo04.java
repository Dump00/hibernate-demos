package com.cisco;

import com.cisco.entity.Employee;
import com.cisco.entity.Vehicle;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo04 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee e002 = session.get(Employee.class, "E002");

            Vehicle v001 = new Vehicle("V001", "Car");
            Vehicle v002 = new Vehicle("V002", "Bike", e002);
            Vehicle v003 = new Vehicle("V003", "Van");

            session.save(v001);
            session.save(v002);
            session.save(v003);

            session.getTransaction().commit();
        }
    }
}
