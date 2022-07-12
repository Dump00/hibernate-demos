package com.cisco;

import com.cisco.entity.Employee;
import com.cisco.entity.Spouse;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo01 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee e001 = new Employee("E001", "Pathum", "Galle");
            Employee e002 = new Employee("E002", "Sovis", "Dehiwala");
            Employee e003 = new Employee("E003", "Dinusha", "Colombo");

            Spouse s001 = new Spouse("S001", "Prarthana", e001);
            Spouse s002 = new Spouse("S002", "Kusuma", e002);

            session.save(e001);
            session.save(e002);
            session.save(e003);
            session.save(s001);
            session.save(s002);

            session.getTransaction().commit();
        }
    }
}
