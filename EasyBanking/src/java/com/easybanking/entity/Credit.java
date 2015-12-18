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
    private double minPayment;
    private double lastBalance;
    private boolean isGoodForLoan;

    public Credit() {
    }

    public Credit(double maxCredit, double minPayment, double lastBalance, boolean isGoodForLoan, String id, Bank issuer, double amountBalance, Currency currency, Person owner, Calendar creationDate, Calendar expirationDate, int giftPoints) {
        super(id, issuer, amountBalance, currency, owner, creationDate, expirationDate, giftPoints);
        this.maxCredit = maxCredit;
        this.minPayment = minPayment;
        this.lastBalance = lastBalance;
        this.isGoodForLoan = isGoodForLoan;
    }
    
    

    public double getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(double maxCredit) {
        this.maxCredit = maxCredit;
    }

    public double getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(double minPayment) {
        this.minPayment = minPayment;
    }

    public double getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(double lastBalance) {
        this.lastBalance = lastBalance;
    }

    public boolean isIsGoodForLoan() {
        return isGoodForLoan;
    }

    public void setIsGoodForLoan(boolean isGoodForLoan) {
        this.isGoodForLoan = isGoodForLoan;
    }
    
    
}
