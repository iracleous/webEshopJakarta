package gr.codehub.eshoped.webeshop.services;

 
 
import gr.codehub.eshoped.webeshop.exceptions.InvalidInputException;
import gr.codehub.eshoped.webeshop.exceptions.CustomerException;
import gr.codehub.eshoped.webeshop.models.Customer;
import gr.codehub.eshoped.webeshop.repositories.CustomerRepository;
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
public class CustomerServiceImpl implements CustomerService{
    @Inject
    private   CustomerRepository productRepository;


    /**
     *
     * @param name
     * @return
     */
    @Override
    public Customer createCustomer(String name) {
      Customer product =   new Customer();
      product.setName(name);
      return product;
    }

    @Override
    public Long saveCustomer(Customer product) throws CustomerException {
        
        productRepository.save(product);
        return product.getId();
    
    }

    @Override
    public List<Customer> getCustomers() {
        return productRepository.findAll();
    }

    @Override
    public Customer findCustomerByName(String productName) throws InvalidInputException, NotFoundException {
        
      
      return productRepository.findByName(productName);
    }

    @Override
    public boolean deleteCustomer(long id) {
         return productRepository.deleteById(id);
    }

     
    
}
