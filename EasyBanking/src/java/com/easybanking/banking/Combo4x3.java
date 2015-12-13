/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

/**
 *
 * @author Glenn Benavides
 */
public class Combo4x3 extends Combos {

    private final double SPECIAL_GIFT;
    // El COMBO4x3 le regala una cuenta a un cliente, la número 4,
    // con la condición de que el cliente haga 3 cuentas de ahorro,
    // una en cada moneda..!!

    public Combo4x3(double SPECIAL_GIFT) {
        this.SPECIAL_GIFT = SPECIAL_GIFT;
    }
   
    

    public Combo4x3(BankAccount account_Colones, BankAccount account_Dollars, BankAccount account_Euros, BankAccount account_Credit) {
        super(account_Colones, account_Dollars, account_Euros, account_Credit);
        this.SPECIAL_GIFT = 100;
    }

    public double getSPECIAL_GIFT() {
        return SPECIAL_GIFT;
    }


    
}
