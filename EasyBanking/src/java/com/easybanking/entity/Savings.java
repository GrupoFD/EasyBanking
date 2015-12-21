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

    public Savings() {
        
    }

    public Savings(String id, Bank issuer, double amountBalance, Currency currency, Person owner, Calendar creationDate, Calendar expirationDate, int giftPoints, double interest, boolean isActive) {
        super(id, issuer, amountBalance, currency, owner, creationDate, expirationDate, giftPoints);
        this.interest = interest;     
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
   
}
