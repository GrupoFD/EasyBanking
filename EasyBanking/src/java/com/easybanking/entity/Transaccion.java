/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.entity;

import java.util.Calendar;

/**
 *
 * @author Tolkerism
 */
public abstract class Transaccion {
    public  int idTransacction;
    public  Person transactor;
    public int amount;
    public  BankAccount account;
    public  Calendar transaccionDate;

    public Transaccion() {
    }

    public Transaccion(int idTransacction, int amount, BankAccount account) {
        this.idTransacction = idTransacction;
        this.amount = amount;
        this.account = account;
    }

    public Transaccion(Person transactor, int amount, BankAccount account) {
        this.transactor = transactor;
        this.amount = amount;
        this.account = account;
    }
    
    public Transaccion(int idTransacction, Person transactor, int amount, BankAccount account, Calendar transaccionDate) {
        this.idTransacction = idTransacction;
        this.transactor = transactor;
        this.amount = amount;
        this.account = account;
        this.transaccionDate = transaccionDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdTransacction() {
        return idTransacction;
    }

    public void setIdTransacction(int idTransacction) {
        this.idTransacction = idTransacction;
    }

    public Person getTransactor() {
        return transactor;
    }

    public void setTransactor(Person transactor) {
        this.transactor = transactor;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public Calendar getTransaccionDate() {
        return transaccionDate;
    }

    public void setTransaccionDate(Calendar transaccionDate) {
        this.transaccionDate = transaccionDate;
    }
                    
    
    
}
