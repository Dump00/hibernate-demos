package com.cisco;

import com.cisco.entity.*;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.sql.Date;

public class ManyToManyDemo04 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Item i001 = new Item("I001", "Keyboard", 10, new BigDecimal(500));
            Item i002 = new Item("I002", "Mouse", 10, new BigDecimal(300));
            Item i003 = new Item("I003", "Hand Free", 10, new BigDecimal(400));
            Item i004 = new Item("I004", "RAM", 10, new BigDecimal(2000));

            Bill b001 = new Bill("B001", Date.valueOf("2022-07-17"));
            Bill b002 = new Bill("B002", Date.valueOf("2022-07-17"));

            BillDetail billDetail =
                    new BillDetail(new BillDetailPK("I001", "B001"), 2, new BigDecimal(500),i001, b001);

            session.persist(billDetail);
            session.persist(i002);
            session.persist(i003);
            session.persist(i004);
            session.persist(b002);

            session.getTransaction().commit();
        }
    }
}
