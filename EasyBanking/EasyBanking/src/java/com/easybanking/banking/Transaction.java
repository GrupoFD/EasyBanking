
package com.easybanking.banking;

import java.util.Calendar;

/**
 *
 * @author Glenn
 */
public class Transaction{
    
    
    private Calendar timeStamp;
    private double amountOfTransaction;

    public Transaction() {
    }

    public Transaction(Calendar timeStamp, double amountOfTransaction) {
             this.timeStamp = timeStamp;
          this.amountOfTransaction = amountOfTransaction;
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

}
