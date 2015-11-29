/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Person;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 *
 * @author Soler
 */
public class Withdraw extends Transaction {

    public Withdraw(String id, Calendar timeStamp, double amountOfTransaction) {
        super(id, timeStamp, amountOfTransaction);
    }

    public boolean withdrawAmount(Person person, BankAccount bankAccount) {
        for (BankAccount b : person.getlistOfBankAccounts()) {
            if (b.equals(bankAccount)) {
                double amount = b.getAmount();
                if (amount >= getAmountOfTransaction()) {
                    double finalAmount = b.getAmount() - this.getAmountOfTransaction();
                    b.setAmount(finalAmount);
                    return true;
                } else {
                    return false;
                }

            }

        }
        return false;
    }

}
