package com.cisco;

import com.cisco.entity.Customer;
import com.cisco.entity.Order;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OneToManyDemo05 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

//            Customer c001 = session.get(Customer.class, "C001");
//            c001.getOrderList().forEach(System.out::println);
//            Customer c002 = session.get(Customer.class, "C002");
//            c002.getOrderList().forEach(System.out::println);

//            Customer customer = new Customer("C003", "Dinusha", "Colombo");
//            session.save(customer);


//            Order od001 = session.get(Order.class, "OD001");
//            Customer c003 = session.get(Customer.class, "C003");
//            System.out.println(od001);
//            od001.setCustomer(c003);

//            Customer c001 = session.get(Customer.class, "C001");
//            c001.getOrderList().forEach(System.out::println);
//            Order od001 = session.get(Order.class, "OD001");
//            List<Order> orderList = c001.getOrderList();
//            orderList.add(od001);
//            c001.setOrderList(orderList);

            Order od0011 = session.get(Order.class, "OD001");
            Customer c003 = session.get(Customer.class, "C003");
            c003.addOrder(od0011);


            session.getTransaction().commit();
        }
    }
}
