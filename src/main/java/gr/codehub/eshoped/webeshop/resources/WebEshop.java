/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 *
 * @author DimitrisIracleous
 */
@Path("Eshop")
public class WebEshop {
    @Path("home")
    @GET
    public String home(){
        return "hello to our eshop";
    }
}
