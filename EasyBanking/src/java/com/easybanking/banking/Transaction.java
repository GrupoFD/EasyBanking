
package com.easybanking.banking;

import java.util.Calendar;

/**
 *
 * @author Glenn Benavides
 */
public class Transaction{
    
    private int id;
    private Calendar timeStamp;
    private double amountOfTransaction;
    private String beneficiaryOfTransaction;

    public Transaction() {
    }

    public Transaction(Calendar timeStamp, double amountOfTransaction) {
             this.timeStamp = timeStamp;
          this.amountOfTransaction = amountOfTransaction;
          this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeneficiaryOfTransaction() {
        return beneficiaryOfTransaction;
    }

    public void setBeneficiaryOfTransaction(String beneficiaryOfTransaction) {
        this.beneficiaryOfTransaction = beneficiaryOfTransaction;
    }
    
    
    public Calendar getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Calendar timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getAmountOfTransaction() {
        return amountOfTransaction;
    }

    public void setAmountOfTransaction(double amountOfTransaction) {
        this.amountOfTransaction = amountOfTransaction;
    }
    
    public void createNewIdNumber(BankAccount bankAccount) {
    
        int newIdNumber = 0;
            for (Transaction t: bankAccount.getListOfTransactions()) {
                newIdNumber = t.getId();
            } 
        newIdNumber += 1;
    
        this.setId(newIdNumber);
    }

}
