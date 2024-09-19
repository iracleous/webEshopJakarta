/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.resources;

import gr.codehub.eshoped.webeshop.exceptions.InvalidInputException;
import gr.codehub.eshoped.webeshop.exceptions.CustomerException;
import gr.codehub.eshoped.webeshop.models.Customer;
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
import gr.codehub.eshoped.webeshop.services.CustomerService;

/**
 *
 * @author DimitrisIracleous
 */
@Path("Eshop")
@Slf4j
public class CustomerResource {
    
    @Inject
    private CustomerService eshopService;
    
 
    
   @Path("customer")
   @GET
   @Produces("text/json")
    public List<Customer> getCustomers(){
        return eshopService.getCustomers();
    }
    
    
   @Path("customer/{customerName}")
   @GET
   @Produces("text/json")
  public  Customer findCustomerByName(@PathParam ("customerName") String customerName)
         {
     try{ return eshopService.findCustomerByName(customerName);
     }
     catch (   InvalidInputException | NotFoundException e){
         Customer customer = new Customer();
         customer.setName(e.getMessage());
         customer.setId(-1);
         return customer;
     }
  }
    
   @Path("customer")
   @POST
   @Consumes("application/json")
   @Produces("application/json")
   public Customer saveCustomer(Customer customer) {
       log.debug("customer= " + customer.getName());
        try {
            eshopService.saveCustomer(customer);
            return customer;
        } catch (CustomerException ex) {
            Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
        }
      return new Customer();
   }
  
  
   @Path("customer/{customerId}")
   @DELETE
   @Consumes("application/json")
   @Produces("application/json")   
  public boolean deleteCustomer(@PathParam ("customerId") long customerId){
      return  eshopService.deleteCustomer(customerId);
  }
    

    
    
}
