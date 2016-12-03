package com.lesson2;

import com.lesson2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Stepan on 03.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = registryBuilder.build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        Metadata metadata =  metadataSources.buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee employee = new Employee();
        employee.setName("Stepan");
        employee.setSurname("Stepan1");
        session.save(employee);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }
}
