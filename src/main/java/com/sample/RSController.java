package com.sample;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by rakeshgupta on 12/21/16.
 */

@Path("/RSManagement")
@Produces(MediaType.APPLICATION_JSON)
public class RSController {

    @GET
    public Response getRestaurantDetails() {
        return Response.ok(RSDatabase.getRestaurant()).build();
    }

    @GET
    @Path("/{restaurantName}")
    public Response getRestaurantByName(@PathParam("restaurantName") String str) {
        Restaurant restaurant = RSDatabase.getRestaurant(str);
        if (restaurant != null)
            return Response.ok(restaurant).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addRestaurant(Restaurant restaurant) throws URISyntaxException {
        Restaurant rs = RSDatabase.getRestaurant(restaurant.getRestaurantName());

        if (rs != null) {
            RSDatabase.updateRestaurant(restaurant);
            return Response.created(new URI("/RSManagement/" + restaurant.getRestaurantName()))
                    .build();
        } else {
            RSDatabase.addRestaurant(restaurant);
            return Response.created(new URI("/RSManagement/" + restaurant.getRestaurantName()))
                    .build();
        }
    }

    @PUT
    @Path("/{restaurantName}")
    public Response updateRestaurantName(@PathParam("restaurantName") String str, Restaurant restaurant) throws URISyntaxException {
        Restaurant rs = RSDatabase.getRestaurant(restaurant.getRestaurantName());

        if (rs != null) {
            RSDatabase.updateRestaurant(restaurant);
            return Response.created(new URI("/RSManagement/" + restaurant.getRestaurantName()))
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{restaurantName}")
    public Response removeRestaurant(@PathParam("restaurantName") String str) {
        Restaurant restaurant = RSDatabase.getRestaurant(str);
        if (restaurant != null) {
            RSDatabase.removeRestaurant(restaurant.getRestaurantName());
            return Response.ok().build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}