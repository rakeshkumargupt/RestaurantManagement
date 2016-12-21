package com.sample;

import java.util.List;

/**
 * Created by rakeshgupta on 12/21/16.
 */
public class TestHibernateApp {
    public static void main(String[] args) {
        RSDatabase rsDatabase = new RSDatabase();

        Restaurant rs = new Restaurant();
        rs.setOwnerName("AAA");
        rs.setRestaurantName("JuiceJunction5");
        rs.setNumberOfEmployee(100);
        rs.setProvideHomeDelivery(true);
        rs.setRestaurantEmail("juice@junction.com");
        rs.setEstablishOn(new java.sql.Date(9999-99-99));

        rsDatabase.addRestaurant(rs);

        rsDatabase.updateRestaurant(rs);

        List<Restaurant> list = rsDatabase.getRestaurant();
        for (Restaurant restaurant : list){
            System.out.println(restaurant.getRestaurantName());
        }

        rsDatabase.removeRestaurant("JuiceJunction3");
    }
}
