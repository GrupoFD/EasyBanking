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
public interface Interesable {
    
    // ¿A ver? ¿INTERÉS es un monto con dos funciones: 1) monto que se 
    // suma positivamente a las cuentas de los clientes como beneficio por
    // tener dinero ahorrado... y 2) monto que se le cobra a los clientes
    // de crédito cada vez que pagan su mensualidad y que se cobra como un
    // extra a su mensualidad?
    // El interés para el crédito es un porcentaje del saldo de la deuda..!!!!! ????
    
    // Si todo lo anterior es verdadero, podemos tener dos métodos para calcular el interest:
    
    public double getInterestRegularAccount(); 
    public double getInterestCreditAccount();
    
}
