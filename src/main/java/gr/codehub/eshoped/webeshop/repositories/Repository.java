/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.webeshop.repositories;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author DimitrisIracleous
 * @param <T> the model class
 * @param <K> the key class
 */
public interface Repository<T, K> {
      Optional<T> findById(K id) ;
      List<T> findAll() ;
      Optional<T> save(T t) ;
      boolean deleteById(K id);
}
