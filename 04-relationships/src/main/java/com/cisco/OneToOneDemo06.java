package com.cisco;

import com.cisco.entity.Employee;
import com.cisco.entity.Vehicle;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo06 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Vehicle v002 = session.get(Vehicle.class, "V002");
            Employee e003 = session.get(Employee.class, "E003");

            e003.setVehicle(v002);


            session.getTransaction().commit();
        }
    }
}
