package com.sample;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

/**
 * Created by rakeshgupta on 12/21/16.
 */
public class RSDatabase {

    public static Session startSession(){
        AnnotationConfiguration annotationConfiguration =
                new AnnotationConfiguration();
        annotationConfiguration.addAnnotatedClass(Restaurant.class);
        annotationConfiguration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = annotationConfiguration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session;
    }

    public static List<Restaurant> getRestaurant(){
        Session s = startSession();
        Query query = s.createQuery("from Restaurant");
        List<Restaurant> list = query.list();
        s.getTransaction().commit();
        return list;
    }

    public static Restaurant getRestaurant(String rsName){
        Session s = startSession();
        Restaurant rs = (Restaurant) s.get(Restaurant.class, rsName);
        return rs;
    }

    public static void addRestaurant(Restaurant restaurant){
        Session s = startSession();
        s.persist(restaurant);
        s.getTransaction().commit();
    }

    public static boolean updateRestaurant(Restaurant restaurant){
        Session s = startSession();
        Restaurant rs = (Restaurant) s.get(Restaurant.class, restaurant.getRestaurantName());
        rs.setRestaurantEmail(restaurant.getRestaurantEmail());
        rs.setNumberOfEmployee(restaurant.getNumberOfEmployee());
        rs.setOwnerName(restaurant.getOwnerName());
        rs.setProvideHomeDelivery(restaurant.isProvideHomeDelivery());
        s.save(rs);
        s.getTransaction().commit();
        return true;
    }

    public static boolean removeRestaurant(String restaurantName){
        Session s = startSession();
        Restaurant rs = (Restaurant) s.get(Restaurant.class, restaurantName);
        s.delete(rs);
        s.getTransaction().commit();
        return true;
    }
}