/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0
 * @author DimitrisIracleous
 * @since 2024-08-06
 */
    
@Entity
@Setter
@Getter
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
   private String name;
   private String email;
   @Column(unique=true, nullable=false)
   private String VatCode;

   @OneToMany(mappedBy = "customer")
   private List<Basket> baskets;
}
