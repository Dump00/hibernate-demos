package com.cisco;

import com.cisco.entity.Actor;
import com.cisco.entity.Movie;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo02 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Actor a003 = session.get(Actor.class, "A003");
            a003.getMovieList().clear();

            session.getTransaction().commit();
        }
    }
}
