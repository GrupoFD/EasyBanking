/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import com.easybanking.banking.BankAccount;

/**
 *
 * @author Glenn Benavides
 */
public abstract class Combos {
    
    private BankAccount account_Colones;
    private BankAccount account_Dollars;
    private BankAccount account_Euros;
    private BankAccount account_Credit;

    public Combos() {
    }

    public Combos(BankAccount account_Colones, BankAccount account_Dollars, BankAccount account_Euros, BankAccount account_Credit) {
        this.account_Colones = account_Colones;
        this.account_Dollars = account_Dollars;
        this.account_Euros = account_Euros;
        this.account_Credit = account_Credit;
    }

    public BankAccount getAccount_Colones() {
        return account_Colones;
    }

    public void setAccount_Colones(BankAccount account_Colones) {
        this.account_Colones = account_Colones;
    }

    public BankAccount getAccount_Dollars() {
        return account_Dollars;
    }

    public void setAccount_Dollars(BankAccount account_Dollars) {
        this.account_Dollars = account_Dollars;
    }

    public BankAccount getAccount_Euros() {
        return account_Euros;
    }

    public void setAccount_Euros(BankAccount account_Euros) {
        this.account_Euros = account_Euros;
    }

    public BankAccount getAccount_Credit() {
        return account_Credit;
    }

    public void setAccount_Credit(BankAccount account_Credit) {
        this.account_Credit = account_Credit;
    }
    
    public void setDollarAccountBalance(Double amount) {
        this.account_Dollars.setAmount(amount);
    }
    
    public double getDollarAccountBalance() {
    return this.account_Dollars.getAmount();
    }

    @Override
    public String toString() {
        return "Combos{" + "account_Colones=" + account_Colones + ", account_Dollars=" + account_Dollars + ", account_Euros=" + account_Euros + ", account_Credit=" + account_Credit + '}';
    }

    


}
