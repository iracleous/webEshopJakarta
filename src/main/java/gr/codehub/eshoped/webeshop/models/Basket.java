/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DimitrisIracleous
 */
@Entity
@Setter
@Getter
public class Basket {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private long id;
    
   private Date date;
   
   @ManyToOne
   private Customer customer;
   
   @OneToMany(mappedBy ="basket")
   private List<BasketProduct> basketProducts;
   
   
}
