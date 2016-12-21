package com.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by rakeshgupta on 12/21/16.
 */
@Entity
public class Restaurant {
    @Column
    @Id
    private String restaurantName;
    @Column
    private String ownerName;
    @Column
    private Date establishOn;
    @Column
    private String restaurantEmail;
    @Column
    private int numberOfEmployee;
    @Column
    private boolean provideHomeDelivery;

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", establishOn=" + establishOn +
                ", restaurantEmail='" + restaurantEmail + '\'' +
                ", numberOfEmployee=" + numberOfEmployee +
                ", provideHomeDelivery=" + provideHomeDelivery +
                '}';
    }

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String ownerName, Date establishOn,
                      String restaurantEmail, int numberOfEmployee,
                      boolean provideHomeDelivery) {
        this.restaurantName = restaurantName;
        this.ownerName = ownerName;
        this.establishOn = establishOn;
        this.restaurantEmail = restaurantEmail;
        this.numberOfEmployee = numberOfEmployee;
        this.provideHomeDelivery = provideHomeDelivery;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getEstablishOn() {
        return establishOn;
    }

    public void setEstablishOn(Date establishOn) {
        this.establishOn = establishOn;
    }

    public String getRestaurantEmail() {
        return restaurantEmail;
    }

    public void setRestaurantEmail(String restaurantEmail) {
        this.restaurantEmail = restaurantEmail;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public boolean isProvideHomeDelivery() {
        return provideHomeDelivery;
    }

    public void setProvideHomeDelivery(boolean provideHomeDelivery) {
        this.provideHomeDelivery = provideHomeDelivery;
    }
}
