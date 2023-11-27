/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes.service;

import com.appweb.clothes.exception.TarifaNotFound;
import com.appweb.clothes.projection.TarifasSegunFechasProjection;
import com.appweb.clothes.repository.TarifasSegunFechasRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class TarifasSegunFechasService {
    private final TarifasSegunFechasRepository tarifaSFRepository;
   
    @Autowired
    public TarifasSegunFechasService(TarifasSegunFechasRepository tarifaSFRepository) {
        this.tarifaSFRepository = tarifaSFRepository;
    }
    
    
    public TarifasSegunFechasProjection obtenerTarifaConMayorPrioridad(Date applicationDate, Date dateToCompare, Long productId, Long brandId) throws TarifaNotFound {
    List<TarifasSegunFechasProjection> tarifas = tarifaSFRepository
        .findByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(applicationDate, dateToCompare, productId, brandId);
    
    if (tarifas.isEmpty()) {
        throw new TarifaNotFound("Tarifa no encontrada");
    }
    
    return tarifas.get(0);
}

}
