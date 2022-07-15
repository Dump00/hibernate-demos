package com.cisco;

import com.cisco.entity.Employee2;
import com.cisco.entity.Vehicle2;
import com.cisco.entity.Vehicle2Employee2;
import com.cisco.entity.Vehicle2Employee2PK;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToOneDemo11 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Employee2 e003 = session.get(Employee2.class, "E003");
            Vehicle2 v001 = session.get(Vehicle2.class, "V001");

            Vehicle2Employee2 ve002 = new Vehicle2Employee2();
            // insertable false
            // ve002.setVehicle2(v001);
            // ve002.setEmployee2(e003);
            ve002.setDate(Date.valueOf("2022-0715"));
            ve002.setVehicle2Employee2PK(new Vehicle2Employee2PK());


            session.getTransaction().commit();
        }
    }
}
