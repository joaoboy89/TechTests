/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes.repository;

import com.appweb.clothes.dto.ClothesDTO;
import com.appweb.clothes.model.ClothesModel;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository 
public interface ClothesRepository extends JpaRepository<ClothesModel , Long> {
   List<Object[]>  findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc (Date applicationDate, Date dateToCompare, Long productId, Long brandId);
}
