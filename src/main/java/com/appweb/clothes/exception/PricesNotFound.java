/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes.exception;

/**
 *
 * @author HP
 */

public class PricesNotFound extends Exception {
    
    public  PricesNotFound(String errorMessage){
        super(errorMessage);
    }
}