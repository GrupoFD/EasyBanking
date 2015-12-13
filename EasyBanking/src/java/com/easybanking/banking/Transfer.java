/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Person;
import java.util.Calendar;

/**
 *
 * @author Glenn Benavides
 */
public class Transfer extends Transaction {

<<<<<<< HEAD
=======
    private double transferToUser;
>>>>>>> master
    private String beneficiaryOfTransaction;

    public Transfer(String id, Calendar timeStamp, double amountOfTransaction, String beneficiaryOfTransaction) {
        super(id, timeStamp, amountOfTransaction);
        this.beneficiaryOfTransaction = beneficiaryOfTransaction;
    }
    
    public String getBeneficiaryOfTransaction() {
        return this.beneficiaryOfTransaction;
    }

<<<<<<< HEAD
    public Transfer() {
        
    }

    public String getBeneficiaryOfTransaction() {
        return this.beneficiaryOfTransaction;
    }

    public boolean transferAmount(Person person, BankAccount bankAccount, Person personToTransfer, BankAccount bankAccountTotransfer) {

=======
    public void transferAmount(Person person, BankAccount bankAccount, Person personToTransfer, BankAccount bankAccountTotransfer) {
        
>>>>>>> master
        for (BankAccount b : person.getlistOfBankAccounts()) {
            while (b.equals(bankAccount)) {
                if (this.verifyPersonToTransferAccount(personToTransfer, bankAccountTotransfer)) {
                    if (this.verifyAccountCurrency(bankAccount, bankAccountTotransfer)) {
                        double amount = b.getAmount();
<<<<<<< HEAD
                        if (amount >= getAmountOfTransaction()) {
                            for (BankAccount b2 : personToTransfer.getListOfBankAccounts()) {
                                if (b2.equals(bankAccountTotransfer)) {
                                    b2.setAmount(b2.getAmount() + getAmountOfTransaction());
                                    double finalAmount = amount - this.getAmountOfTransaction();
                                    b.setAmount(finalAmount);
                                    this.beneficiaryOfTransaction = personToTransfer.getName();
                                    return true;
                                }
                            }
                        } else {
                            return false;
=======
                        if (amount >= getAmountOfTransaction()) { 
                            for (BankAccount b2 : personToTransfer.getListOfBankAccounts()) {
                                if (b2.equals(bankAccountTotransfer)) {
                                    b2.setAmount(b2.getAmount() + getAmountOfTransaction());
                                }
                            }
                            double finalAmount = amount - this.getAmountOfTransaction();
                            b.setAmount(finalAmount);
                            this.beneficiaryOfTransaction = personToTransfer.getName();
                            
                        } else {
                            System.out.println("EXCEPTION");
>>>>>>> master
                        }
                    }
                }
            }
        }
<<<<<<< HEAD
        return false;
=======
        
>>>>>>> master
    }


    public boolean verifyPersonToTransferAccount(Person personToTransfer, BankAccount bankAccountTotransfer) {

        for (BankAccount b : personToTransfer.getlistOfBankAccounts()) {
            if (b.equals(bankAccountTotransfer)) {
                return true;
            } else {
                System.out.println("EXEPTION");
            }
        }
        return false;
    }


    public boolean verifyAccountCurrency(BankAccount bankAccount, BankAccount bankAccountTotransfer) {

        if (bankAccount.getCurrency() == bankAccountTotransfer.getCurrency()) {
            return true;
        } else {
            System.out.println("EXCEPTION");
            return false;
        }
    }
<<<<<<< HEAD

=======
    
>>>>>>> master
}
