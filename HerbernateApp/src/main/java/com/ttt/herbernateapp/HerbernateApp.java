/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ttt.herbernateapp;

import com.ttt.repositories.iml.CategoryRepositoryImpl;
import com.ttt.repositories.iml.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HerbernateApp {

    public static void main(String[] args) {
        CategoryRepositoryImpl cates = new CategoryRepositoryImpl();
        cates.getCategoriesImpl().forEach(c -> System.out.println(c.getName()));
        
        ProductRepositoryImpl props = new ProductRepositoryImpl();
        
        Map<String, String> params = new HashMap<>();
//        params.put("kw", "galaxy");
//        params.put("fromPrice", "1200000");
//        params.put("cateId", "2");
          params.put("page", "1");
        
        
        props.getProductsImpl(params).forEach(p -> System.out.printf("%d - %s - %d\n", p.getId(), p.getName(), p.getPrice()));
    }
}
