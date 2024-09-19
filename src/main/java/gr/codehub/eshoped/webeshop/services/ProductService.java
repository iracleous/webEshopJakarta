/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.services;

 
 
import gr.codehub.eshoped.webeshop.exceptions.InvalidInputException;
import gr.codehub.eshoped.webeshop.exceptions.ProductException;
import gr.codehub.eshoped.webeshop.models.Product;
import jakarta.ws.rs.NotFoundException;
import java.util.List;

/**
 *
 * @author DimitrisIracleous
 */
public interface ProductService {
    Product createProduct(String name);
    Long saveProduct(Product product)throws ProductException;
    List<Product> getProducts();
    Product findProductByName(String productName)throws InvalidInputException, NotFoundException;
    boolean deleteProduct(long id);
}
