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
public class Savings extends BankAccount{
    
    private double interest;
    private boolean isActive; //?????????????

    public Savings(double interest, boolean isActive) {
        this.interest = interest;
        this.isActive = isActive;
    }

    public Savings(double interest, boolean isActive, String id, Currency currency, double amountBalance, Calendar creationDate, Calendar expirationDate) {
        super(id, currency, amountBalance, creationDate, expirationDate);
        this.interest = interest;
        this.isActive = isActive;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
}
