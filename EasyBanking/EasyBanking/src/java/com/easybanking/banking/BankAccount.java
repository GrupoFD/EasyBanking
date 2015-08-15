/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Soler
 */
public class BankAccount {

 
    private String id;
    private int currency;
    private double amount;
    private ArrayList<Transaction> listOfTransactions = new ArrayList<>();
    private Calendar registeredDate;
    private Calendar expirationDate;

    public BankAccount() {
    } 
   
   
    public BankAccount(String id, int currency, double amount, Calendar registeredDate, Calendar expirationDate) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
        this.registeredDate = registeredDate;
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(ArrayList<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public Calendar getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Calendar registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {

        return "Cuenta: " + id + ", Moneda:" + currency + ", Total: " + amount + ", listOfTransactions=" + listOfTransactions + ", registeredDate=" + registeredDate + ", expirationDate=" + expirationDate + '}';

    }

}
