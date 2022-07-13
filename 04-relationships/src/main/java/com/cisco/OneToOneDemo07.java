package com.cisco;

import com.cisco.entity.Employee;
import com.cisco.entity.Vehicle;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo07 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Vehicle v004 = new Vehicle("V004", "Car");
            Employee e004 = new Employee("E004", "Hamza", "Colombo", v004);
            
            session.persist(e004);


            session.getTransaction().commit();
        }
    }
}
