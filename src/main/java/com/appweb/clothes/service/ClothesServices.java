/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes.service;

import com.appweb.clothes.dto.ClothesDTO;
import com.appweb.clothes.exception.PricesNotFound;
import com.appweb.clothes.model.ClothesModel;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appweb.clothes.repository.ClothesRepository;

/**
 *
 * @author HP
 */
@Service
public class ClothesServices {
    private final ClothesRepository priceRepository;
   
    @Autowired
    public ClothesServices(ClothesRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    
    
    public ClothesDTO getPricesWithPriority(Date applicationDate, Date dateToCompare, Long productId, Long brandId) throws PricesNotFound {
    List<Object[]> prices = priceRepository
        .findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(applicationDate, dateToCompare, productId, brandId);
    
    if (prices.isEmpty()) {
        throw new PricesNotFound("Tarifa no encontrada");
    }
    
    Object[] firstResult = prices.get(0);
    ClothesModel clothesModel = (ClothesModel) firstResult[0];
    return ClothesDTO.fromClothesModel(clothesModel);
    }
}


