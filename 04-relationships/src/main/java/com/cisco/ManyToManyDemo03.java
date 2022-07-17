package com.cisco;

import com.cisco.entity.Actor;
import com.cisco.entity.Movie;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo03 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Movie m001 = session.find(Movie.class, "M001");
            m001.getActorList().forEach(System.out::println);

            Actor a002 = session.get(Actor.class, "A002");
            m001.getActorList().add(a002);

            m001.getActorList().clear();

            session.getTransaction().commit();
        }
    }
}
