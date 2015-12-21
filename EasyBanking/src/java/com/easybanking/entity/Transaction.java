
package com.easybanking.entity;

import java.sql.Date;
import java.util.Calendar;

/**
 * @author Glenn Benavides
 */
public class Transaction {
    
    int idTransaction;
    String transType;
    Calendar date;
    int trasPerson;
    int recipPerson;
    String accNumberSender;
    String accNumberRecip;
    double transAmount;

    public Transaction() {
    }

    public Transaction(int idTransaction, String transType, Calendar date, int trasPerson, int recipPerson, String accNumberSender, String accNumberRecip, double transAmount) {
        this.idTransaction = idTransaction;
        this.transType = transType;
        this.date = date;
        this.trasPerson = trasPerson;
        this.recipPerson = recipPerson;
        this.accNumberSender = accNumberSender;
        this.accNumberRecip = accNumberRecip;
        this.transAmount = transAmount;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getTrasPerson() {
        return trasPerson;
    }

    public void setTrasPerson(int trasPerson) {
        this.trasPerson = trasPerson;
    }

    public int getRecipPerson() {
        return recipPerson;
    }

    public void setRecipPerson(int recipPerson) {
        this.recipPerson = recipPerson;
    }

    public String getAccNumberSender() {
        return accNumberSender;
    }

    public void setAccNumberSender(String accNumberSender) {
        this.accNumberSender = accNumberSender;
    }

    public String getAccNumberRecip() {
        return accNumberRecip;
    }

    public void setAccNumberRecip(String accNumberRecip) {
        this.accNumberRecip = accNumberRecip;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }
    
    

    
}
