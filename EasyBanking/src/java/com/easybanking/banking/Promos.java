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
public abstract class Promos {
    
    private BankAccount account_Dollars;

    public Promos() {
    }
    

    public Promos(BankAccount account_Dollars) {
        this.account_Dollars = account_Dollars;
    }

    public BankAccount getAccount_Dollars() {
        return account_Dollars;
    }

    public void setAccount_Dollars(BankAccount account_Dollars) {
        this.account_Dollars = account_Dollars;
    }
    
    
    
}
