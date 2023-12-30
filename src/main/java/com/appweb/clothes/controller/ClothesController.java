/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes.controller;

import com.appweb.clothes.dto.ClothesDTO;
import com.appweb.clothes.exception.PricesNotFound;
import com.appweb.clothes.service.ClothesServices;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author HP
 */

@RestController
public class ClothesController {
    private final ClothesServices prices;
    
    @Autowired
    public ClothesController(ClothesServices prices){
        this.prices = prices;
    }
    
    @GetMapping("/prices")
    public ClothesDTO getPrices (
                                      @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date date,
                                      @RequestParam("idProduct") Long idProduct,
                                      @RequestParam("idBrand") Long idBrand) {
        try {
            return prices.getPricesWithPriority(date, date, idProduct, idBrand);
        } catch(PricesNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarifa no encontrada", e);
        }
        
    } 
           
}
