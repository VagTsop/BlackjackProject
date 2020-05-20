/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vatso
 */
public class ProductModel {
    
      public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("p01", "Product 1", 20, 5));
        products.add(new Product("p02", "Product 2", 21, 16));
        products.add(new Product("p03", "Product 3", 22, 3));
        products.add(new Product("p04", "Product 4", 23, 20));
        products.add(new Product("p05", "Product 5", 24, 8));
        return products;
 
      }
}
