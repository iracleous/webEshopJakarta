package gr.codehub.eshoped.webeshop.services;

 
 
import gr.codehub.eshoped.webeshop.exceptions.InvalidInputException;
import gr.codehub.eshoped.webeshop.exceptions.ProductException;
import gr.codehub.eshoped.webeshop.models.Product;
import gr.codehub.eshoped.webeshop.repositories.ProductRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author DimitrisIracleous
 */
@Slf4j
@RequestScoped
public class ProductServiceImpl implements ProductService{
    @Inject
    private   ProductRepository productRepository;


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
        
      
      return productRepository.findByName(productName);
    }

    @Override
    public boolean deleteProduct(long id) {
         return productRepository.deleteById(id);
    }

     
    
}
