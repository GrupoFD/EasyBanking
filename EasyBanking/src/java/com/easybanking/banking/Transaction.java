package com.easybanking.banking;

import com.easybanking.entity.BankAccount;
import java.util.Calendar;

/**
 *
 * @author Glenn Benavides
 */
<<<<<<< HEAD
public abstract class Transaction {

    private String id;
=======
public class Transaction{
    
    private int id;
>>>>>>> master
    private Calendar timeStamp;
    private double amountOfTransaction;
    private String beneficiaryOfTransaction;

    public Transaction() {

    }

    public Transaction(String id, Calendar timeStamp, double amountOfTransaction) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.amountOfTransaction = amountOfTransaction;
    }

<<<<<<< HEAD
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
=======
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
>>>>>>> master
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
