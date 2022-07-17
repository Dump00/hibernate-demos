package com.cisco;

import com.cisco.entity.Class;
import com.cisco.entity.ClassStudent;
import com.cisco.entity.ClassStudentPK;
import com.cisco.entity.Student;
import com.cisco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class OneToManyDemo14 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Class dep = new Class("DEP", "direct entry program");
            Class mad = new Class("MAD", "mobile application developer");
            Student s001 = new Student("S001", "Pathum", "Galle");
            Student s002 = new Student("S002", "Gayal", "Gampaha");

            session.save(dep);
            session.save(mad);
            session.save(s001);
            session.save(s002);

            ClassStudent cs01 = new ClassStudent(new ClassStudentPK("DEP", "S001"),
                    Date.valueOf("2022-07-15"), dep, s001);
            ClassStudent cs02 = new ClassStudent(new ClassStudentPK("DEP", "S002"), Date.valueOf("2022-07-15"));
            session.persist(cs01);
            session.save(cs02);


            session.getTransaction().commit();
        }
    }
}
