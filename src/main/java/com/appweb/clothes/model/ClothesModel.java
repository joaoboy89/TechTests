/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HP
 */
@Getter
@Setter
@Entity
@Table (name = "PRICES")

public class ClothesModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    
        private Long brandId;
        private Date startDate;
        private Date endDate;
        private Long priceList;
        private Long productId;
        private int priority;
        private Double price;
        private String curr;
        
        public ClothesModel(){}
        
        public ClothesModel(Long id, Long brandId,
         Date startDate,
         Date endDate,
         Long priceList,
         Long productId,
         int priority,
         Double price,
         String curr){
  
            this.id = id;
            this.brandId = brandId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.priceList = priceList;
            this.productId = productId;
            this.priority = priority;
            this.price = price;
            this.curr = curr;
        };
              
}