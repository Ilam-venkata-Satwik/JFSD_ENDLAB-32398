package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        
        Device device = new Device();
        device.setBrand("GenericBrand");
        device.setModel("GenericModel");
        device.setPrice(200.0);
        session.save(device);

   
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(999.99);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution("12MP");
        session.save(smartphone);

 
        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S8");
        tablet.setPrice(650.0);
        tablet.setScreenSize("11 inches");
        tablet.setBatteryLife("15 hours");
        session.save(tablet);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Records inserted successfully.");
    }
}
