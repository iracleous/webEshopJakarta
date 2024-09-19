package gr.codehub.eshoped.webeshop.repositories;

 
import gr.codehub.eshoped.webeshop.models.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author DimitrisIracleous
 */
@Slf4j
@RequestScoped
public class CustomerRepository implements Repository<Customer, Long>{
    
    
    @PersistenceContext(unitName = "Persistence")
    private  EntityManager entityManager;

  
    /**
     *
     * @param id the id of the requested product
     * @return Optional<Customer>
     */
    @Override
    public Optional<Customer> findById(Long id) {
        try {
            Customer t = entityManager.find(getEntityClass(), id);
            return Optional.of(t);
        } catch (Exception e) {
            log.debug("An exception occured");
             return Optional.empty();  
        }
    }

    @Override
    @Transactional
    public List<Customer> findAll() {
        TypedQuery<Customer> query = 
               entityManager.createQuery("from " + getEntityClassName(), getEntityClass());
        return query.getResultList();    
    }

    
    
     
    @Transactional
    public Customer findByName(String productName) {
        String query = "from " + getEntityClassName() 
                       +" p where p.name = :productName";
        
       var q =  entityManager.createQuery(query, getEntityClass())
                .setParameter("productName", productName);
        return q.getResultList().get(0);
    }
    
    
    
    @Override
     @Transactional
    public Optional<Customer> save(Customer t) {
         entityManager.persist(t);
        return Optional.of(t);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        Customer persistentInstance = entityManager.find(getEntityClass(), id);
        if (persistentInstance != null) {
                  entityManager.remove(persistentInstance);
            return true;
        }
        return false;   
    }
 
    public List<Customer> findAll(String productName, double price) {
       TypedQuery<Customer> query = 
               entityManager.createQuery("from " + getEntityClassName()
                       + " where name  like :productName "
                       + " and price < :price"
                       , getEntityClass())
               .setParameter("productName", productName)
               .setParameter("price", price);
        return query.getResultList();    
   }
  
    
     private Class<Customer> getEntityClass() {
        return Customer.class;
    }

    private String getEntityClassName() {
        return Customer.class.getName();
    }
    
}
