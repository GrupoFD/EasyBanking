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
public class Transfer extends Transaccion{
    
    public String recievingAccount;

    public Transfer() {
    }

    public Transfer(String recievingAccount) {
        this.recievingAccount = recievingAccount;
    }

    public Transfer(String recievingAccount, int idTransacction, Person transactor, int amount, BankAccount account, Calendar transaccionDate) {
        super(idTransacction, transactor, amount, account, transaccionDate);
        this.recievingAccount = recievingAccount;
    }

  
   public int WithdrawToDeposit(Person transactor, int amount, BankAccount account){
       amount = getAmount();
       transactor = getTransactor();
       account = getAccount();
       
       account.setAmount(account.getAmount()- amount);
       
       return amount;
   }
    public void ExecuteTransfer(Person transactor, int amount, BankAccount account){
        amount = WithdrawToDeposit(transactor, amount, account);
        BankAccount toRecieve = new BankAccount();
        toRecieve.setId(recievingAccount);
        //Select to DB here to recieve the BankAccount info with the ID
        toRecieve.setAmount(toRecieve.getAmount()+amount);
        
    }
    
}
