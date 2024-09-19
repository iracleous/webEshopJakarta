/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.services;

import gr.codehub.eshoped.webeshop.exceptions.InvalidInputException;
import gr.codehub.eshoped.webeshop.exceptions.CustomerException;
import gr.codehub.eshoped.webeshop.models.Customer;
import jakarta.ws.rs.NotFoundException;
import java.util.List;

/**
 *
 * @author DimitrisIracleous
 */
public interface CustomerService {
    
    Customer createCustomer(String name);
    Long saveCustomer(Customer product)throws CustomerException;
    List<Customer> getCustomers();
    Customer findCustomerByName(String productName)throws InvalidInputException, NotFoundException;
    boolean deleteCustomer(long id);
    
}
