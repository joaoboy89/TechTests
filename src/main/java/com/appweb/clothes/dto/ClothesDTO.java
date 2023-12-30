/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes.dto;

import com.appweb.clothes.model.ClothesModel;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

/**
 *
 * @author joao_
 */
@Data
public class ClothesDTO {
    private Long productId;
    private Long brandId;
    private int priority;
    private Date startDate;
    private Date endDate;
    private double price;
    
    
    public ClothesDTO(Long productId, Long brandId, int priority, Date startDate, Date endDate, double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }
    
     public static ClothesDTO fromClothesModel(ClothesModel clothesModel) {
        return new ClothesDTO(
            clothesModel.getProductId(),
            clothesModel.getBrandId(),
            clothesModel.getPriority(),
            clothesModel.getStartDate(),
            clothesModel.getEndDate(),
            clothesModel.getPrice()
        );
    }
     public static List<ClothesDTO> fromClothesModelList(List<ClothesModel> clothesModelList) {
        return clothesModelList.stream()
                .map(ClothesDTO::fromClothesModel)
                .collect(Collectors.toList());
    }

}
