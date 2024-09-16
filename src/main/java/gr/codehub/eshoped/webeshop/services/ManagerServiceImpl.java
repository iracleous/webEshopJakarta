/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.services;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author DimitrisIracleous
 */

//@Stateless

@RequestScoped
// Defines a bean that is created and destroyed with each HTTP request.

//@SessionScoped
//Defines a bean that is created and destroyed with an HTTP session.


public class ManagerServiceImpl implements ManagerService{
    @PersistenceContext(unitName = "Persistence")
    protected EntityManager em;

    @Override
    public String doWork(String input) {
       return "processing the " + input;
    }
}
