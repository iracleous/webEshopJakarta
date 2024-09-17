/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.services;

 
 
import gr.codehub.eshoped.webeshop.exceptions.InvalidInputException;
import gr.codehub.eshoped.webeshop.exceptions.ProductException;
import gr.codehub.eshoped.webeshop.models.Product;
import gr.codehub.eshoped.webeshop.repositories.ProductRepository;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author DimitrisIracleous
 */
@Slf4j
public class EshopServiceImpl implements EshopService{
    private final ProductRepository productRepository;

    public EshopServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Product createProduct(String name) {
      Product product =   new Product();
      product.setName(name);
      return product;
    }

    @Override
    public Long saveProduct(Product product) throws ProductException {
        
        if (product.getPrice()>100)
            throw new ProductException();
        productRepository.save(product);
        return product.getId();
    
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductByName(String productName) throws InvalidInputException, NotFoundException {
        
       if (productName == null) {
           log.debug("Null product name was given");
           throw new InvalidInputException();
       }
       if (! productName.chars().allMatch(Character::isLetter)) throw new InvalidInputException();
        
       List<Product> products =  productRepository.findAll(productName, 100);
       
       if (products.isEmpty()) throw new NotFoundException();
       return products.getFirst();
    }

     
    
}
