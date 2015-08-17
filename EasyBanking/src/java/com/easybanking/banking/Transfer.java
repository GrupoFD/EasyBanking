/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import java.util.Calendar;

/**
 *
 * @author Glenn Benavides
 */
public class Transfer extends Transaction {

    private double transferToUser;
    private String beneficiaryOfTransaction;

    public Transfer(double transferToUser, Calendar timeStamp, double amountOfTransaction) {
        super(timeStamp, amountOfTransaction);
        this.transferToUser = transferToUser;
    }
    
    public String getBeneficiaryOfTransaction() {
        return this.beneficiaryOfTransaction;
    }

    public void transferAmount(Person person, BankAccount bankAccount, Person personToTransfer, BankAccount bankAccountTotransfer) {

        for (BankAccount b : person.getlistOfBankAccounts()) {
            while (b.equals(bankAccount)) {
                if (this.verifyPersonToTransferAccount(personToTransfer, bankAccountTotransfer)) {
                    if (this.verifyAccountCurrency(bankAccount, bankAccountTotransfer)) {
                        double amount = b.getAmount();
                        if (amount >= getAmountOfTransaction()) {

                            double finalAmount = amount - this.getAmountOfTransaction();
                            b.setAmount(finalAmount);
                            this.beneficiaryOfTransaction = personToTransfer.getName();
                            
                        } else {
                            System.out.println("EXCEPTION");
                        }
                    }
                }
            }
        }
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
    
}
