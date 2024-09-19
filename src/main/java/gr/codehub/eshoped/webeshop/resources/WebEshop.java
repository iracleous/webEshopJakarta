/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.resources;

import gr.codehub.eshoped.webeshop.exceptions.InvalidInputException;
import gr.codehub.eshoped.webeshop.exceptions.ProductException;
import gr.codehub.eshoped.webeshop.models.Product;
import gr.codehub.eshoped.webeshop.services.EshopService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author DimitrisIracleous
 */
@Path("Eshop")
@Slf4j
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
    
    
   @Path("product/{productName}")
   @GET
   @Produces("text/json")
  public  Product findProductByName(@PathParam ("productName") String productName)
         {
     try{ return eshopService.findProductByName(productName);
     }
     catch (   InvalidInputException | NotFoundException e){
         Product product = new Product();
         product.setName(e.getMessage());
         product.setId(-1);
         return product;
     }
  }
    
   @Path("product")
   @POST
   @Consumes("application/json")
   @Produces("application/json")
   public Product saveProduct(Product product) {
       log.debug("product= " + product.getName());
        try {
            eshopService.saveProduct(product);
            return product;
        } catch (ProductException ex) {
            Logger.getLogger(WebEshop.class.getName()).log(Level.SEVERE, null, ex);
        }
      return new Product();
   }
  
  
   @Path("product/{productId}")
   @DELETE
   @Consumes("application/json")
   @Produces("application/json")   
  public boolean deleteProduct(@PathParam ("productId") long productId){
      return  eshopService.deleteProduct(productId);
  }
    

    
    
}
