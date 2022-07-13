package com.cisco;

import com.cisco.entity.Employee;
import com.cisco.entity.Vehicle;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo05 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Vehicle v002 = session.get(Vehicle.class, "V002");
            System.out.println(v002);
            System.out.println(v002.getEmployee());

            Employee e002 = session.get(Employee.class, "E002");
            System.out.println(e002);
            System.out.println(e002.getVehicle());


            session.getTransaction().commit();
        }
    }
}
