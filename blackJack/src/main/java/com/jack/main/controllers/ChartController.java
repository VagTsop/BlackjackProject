/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.controllers;

import com.jack.main.model.Product;
import com.jack.main.model.ProductModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vatso
 */

@Controller
@RequestMapping(value = "chart")
public class ChartController {
    
   
    

    @RequestMapping(value = "showChart")
    public String index() {
        return "charts";
    }

    @RequestMapping(value = "data", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> data() {
        ProductModel productModel = new ProductModel();
        return productModel.findAll();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
