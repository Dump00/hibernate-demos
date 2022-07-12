package com.cisco;

import com.cisco.entity.Employee;
import com.cisco.entity.Spouse;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo03 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Spouse s004 = new Spouse("S004", "Latha", null);
            Employee e004 = new Employee("e004", "Gayal", "Colombo", s004);

            session.persist(e004);


            session.getTransaction().commit();
        }
    }
}
