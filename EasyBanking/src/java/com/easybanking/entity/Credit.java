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
    private Calendar expirationDate;
    private boolean isGoodForLoan;

    public Credit(double maxCredit, double minPayment, double lastBalance, Calendar expirationDate, boolean isGoodForLoan) {
        this.maxCredit = maxCredit;
        this.minPayment = minPayment;
        this.lastBalance = lastBalance;
        this.isGoodForLoan = isGoodForLoan;
    }

    public Credit(double maxCredit, double minPayment, double lastBalance, Calendar expirationDate, boolean isGoodForLoan, String id, Currency currency, double amountBalance, Calendar creationDate) {
        super(id, currency, amountBalance, creationDate, expirationDate);
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
