/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DimitrisIracleous
 */

 
@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;
    private int  inventoryQuantity;

    @Enumerated(EnumType.STRING)
    private Category category;
 
    @OneToMany(mappedBy ="product")
    private List<BasketProduct> basketProducts;
}