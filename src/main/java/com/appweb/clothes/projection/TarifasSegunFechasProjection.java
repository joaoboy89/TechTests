/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes.projection;

import java.util.Date;

/**
 *
 * @author HP
 */
public interface TarifasSegunFechasProjection {
     Long getProductId();
     Long getBrandId();
     int getPriority();
     Date getStartDate();
     Date getEndDate();
     double getPrice();
}
