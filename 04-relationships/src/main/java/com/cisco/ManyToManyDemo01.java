package com.cisco;

import com.cisco.entity.Actor;
import com.cisco.entity.Employee;
import com.cisco.entity.Movie;
import com.cisco.entity.Spouse;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyDemo01 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Actor a001 = new Actor("A001", "Dinusha");
            Actor a002 = new Actor("A002", "Sovis");
            Actor a003 = new Actor("A003", "Pathum");
            Actor a004 = new Actor("A004", "Manoj");

            Movie m001 = new Movie("M001", "Iron Man");
            Movie m002 = new Movie("M002", "Dune");
            Movie m003 = new Movie("M003", "Ant Man");
            Movie m004 = new Movie("M004", "Sky Fall");

            a001.getMovieList().add(m003);
            a001.getMovieList().add(m004);

            a002.getMovieList().add(m002);
            a002.getMovieList().add(m004);

            a003.getMovieList().add(m001);
            a003.getMovieList().add(m003);

            a004.getMovieList().add(m002);

            session.persist(a001);
            session.persist(a002);
            session.persist(a003);
            session.persist(a004);

            session.persist(m001);
            session.persist(m002);
            session.persist(m003);
            session.persist(m004);

            session.getTransaction().commit();
        }
    }
}
