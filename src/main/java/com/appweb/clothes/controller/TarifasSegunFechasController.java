/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes.controller;

import com.appweb.clothes.exception.TarifaNotFound;
import com.appweb.clothes.projection.TarifasSegunFechasProjection;
import com.appweb.clothes.service.TarifasSegunFechasService;
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
public class TarifasSegunFechasController {
    private final TarifasSegunFechasService tarifasSegunFechasService;
    
    @Autowired
    public TarifasSegunFechasController(TarifasSegunFechasService tarifasSegunFechasService){
        this.tarifasSegunFechasService = tarifasSegunFechasService;
    }
    
    @GetMapping("/prices")
    public TarifasSegunFechasProjection obtenerTarifas(
                                      @RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date fecha,
                                      @RequestParam("idProducto") Long idProducto,
                                      @RequestParam("idCadena") Long idCadena) {
        try {
            return tarifasSegunFechasService.obtenerTarifaConMayorPrioridad(fecha, fecha, idProducto, idCadena);
        } catch(TarifaNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarifa no encontrada", e);
        }
        
    } 
           
}
