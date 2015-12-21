/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.entity;

import java.util.Calendar;

/**
 *
 * @author Soler
 */
public class Credit extends BankAccount{
        
    private double maxCredit;
    private double lastBalance;


    public Credit() {
    }

    public Credit(double maxCredit, double lastBalance) {
        this.maxCredit = maxCredit;
        this.lastBalance = lastBalance;
    }

    public Credit(double maxCredit, double lastBalance, String id, Bank issuer, double amountBalance, Currency currency, Person owner, Calendar creationDate, Calendar expirationDate, int giftPoints) {
        super(id, issuer, amountBalance, currency, owner, creationDate, expirationDate, giftPoints);
        this.maxCredit = maxCredit;
        this.lastBalance = lastBalance;
    }
    
    public double getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(double maxCredit) {
        this.maxCredit = maxCredit;
    }

    public double getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(double lastBalance) {
        this.lastBalance = lastBalance;
    }
   
}
