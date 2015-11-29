package com.easybanking.banking;

import com.easybanking.entity.BankAccount;
import java.util.Calendar;

/**
 *
 * @author Glenn
 */
public abstract class Transaction {

    private String id;
    private Calendar timeStamp;
    private double amountOfTransaction;

    public Transaction() {

    }

    public Transaction(String id, Calendar timeStamp, double amountOfTransaction) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.amountOfTransaction = amountOfTransaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int createNewIdNumber(BankAccount bankAccount) {

        int newIdNumber = 0;

        for (Transaction t : bankAccount.getListOfTransactions()) {
            newIdNumber = Integer.parseInt(t.getId());
        }
        newIdNumber += 1;

        return newIdNumber;
    }

    public String getTypeOfTransaction(Transaction t) {

        String c = "";

        if (t instanceof Deposit) {
            c = "Deposito";
        } else if (t instanceof Withdraw) {
            c = "Retiro";
        } else if (t instanceof Transfer) {
            c = "Transferencia";
        }

        return c;
    }

}
