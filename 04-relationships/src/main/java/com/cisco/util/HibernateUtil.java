package com.cisco.util;


import com.cisco.entity.*;
import com.cisco.entity.Class;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
//                StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//                .loadProperties("application.properties")
//                .build();
//
//        Metadata metadata = new MetadataSources(standardRegistry)
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Spouse.class)
//                .addAnnotatedClass(Vehicle.class)
//                .getMetadataBuilder()
//                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
//                .build();
//
//         return sessionFactory = metadata.getSessionFactoryBuilder()
//                .build();

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("application.properties")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Spouse.class)
                .addAnnotatedClass(Vehicle.class)
                .addAnnotatedClass(Vehicle2.class)
                .addAnnotatedClass(Employee2.class)
                .addAnnotatedClass(Vehicle2Employee2.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Customer2.class)
                .addAnnotatedClass(Order2.class)
                .addAnnotatedClass(Class.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(ClassStudent.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        return sessionFactory = metadata.getSessionFactoryBuilder()
                .build();

    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
