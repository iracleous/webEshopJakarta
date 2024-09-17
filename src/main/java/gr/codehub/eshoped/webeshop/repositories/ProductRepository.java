/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.repositories;

 
import gr.codehub.eshoped.webeshop.models.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
public class ProductRepository implements Repository<Product, Long>{
    
    
    @PersistenceContext(unitName = "Persistence")
    private  EntityManager entityManager;

  
    /**
     *
     * @param id the id of the requested product
     * @return Optional<Product>
     */
    @Override
    public Optional<Product> findById(Long id) {
        try {
            Product t = entityManager.find(getEntityClass(), id);
            return Optional.of(t);
        } catch (Exception e) {
            log.debug("An exception occured");
             return Optional.empty();  
        }
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        TypedQuery<Product> query = 
               entityManager.createQuery("from " + getEntityClassName(), getEntityClass());
        return query.getResultList();    
    }

    @Override
     @Transactional
    public Optional<Product> save(Product t) {
         entityManager.persist(t);
        return Optional.of(t);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        Product persistentInstance = entityManager.find(getEntityClass(), id);
        if (persistentInstance != null) {
                  entityManager.remove(persistentInstance);
            return true;
        }
        return false;   
    }
 
 
   public List<Product> findAll(String productName, double price) {
       TypedQuery<Product> query = 
               entityManager.createQuery("from " + getEntityClassName()
                       + " where name  like :productName "
                       + " and price < :price"
                       , getEntityClass())
               .setParameter("productName", productName)
               .setParameter("price", price);
        return query.getResultList();    
   }
  
    
    
    
    
    
    private Class<Product> getEntityClass() {
        return Product.class;
    }

    private String getEntityClassName() {
        return Product.class.getName();
    }
    
}
