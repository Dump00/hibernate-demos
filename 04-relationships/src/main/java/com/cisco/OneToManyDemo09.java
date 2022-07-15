package com.cisco;

import com.cisco.entity.Customer2;
import com.cisco.entity.Order2;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo09 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Customer2 c001 = session.get(Customer2.class, "C001");
            Order2 od001 = session.get(Order2.class, "OD001");
            //c001.getOrder2List().add(od001);

            List<Order2> orderList = new ArrayList<>();
            orderList.addAll(c001.getOrder2List());
            orderList.add(od001);
            c001.setOrder2List(orderList);

            session.getTransaction().commit();
        }
    }
}
