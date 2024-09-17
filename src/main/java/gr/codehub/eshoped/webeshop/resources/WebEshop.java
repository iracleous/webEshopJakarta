/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.resources;

import gr.codehub.eshoped.webeshop.models.Product;
import gr.codehub.eshoped.webeshop.services.EshopService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;

/**
 *
 * @author DimitrisIracleous
 */
@Path("Eshop")
public class WebEshop {
    
    @Inject
    private EshopService eshopService;
    
    @Path("home")
    @GET
    public String home(){
        return "hello to our eshop";
    }
    
   @Path("product")
   @GET
   @Produces("text/json")
    public List<Product> getProducts(){
        return eshopService.getProducts();
    }
    
    
    
    
//    Product createProduct(String name);
//    Long saveProduct(Product product)throws ProductException;
//    
//    Product findProductByName(String productName)throws InvalidInputException, NotFoundException;
    
    
    
    
}
