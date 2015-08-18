/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

/**
 *
 * @author Soler
 */
public class ErrorMessages {
    
    public String errorEmpySpace(){
    return "Error: ha dejado campos vacios";
    }
    
    public String errorNotEnoughCash() {
    return "Error: insuficiencia de fondos para la transaccion";
    }
    
    public String errorInvalidEmail() {
    return "Error: Email invalido o inexistente";
    }
    
    public String errorNegativeCashInput() {
    return "Error: ingreso de fondos en negativo";
    }
    
    public String errorIncorrectInput() {
    return "Error: ingreso incorrecto de datos";
    }
    
}
