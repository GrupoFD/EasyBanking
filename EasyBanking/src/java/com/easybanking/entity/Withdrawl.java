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
public class Withdrawl extends Transaccion{

    public Withdrawl() {
    }

    public Withdrawl(int idTransacction, Person transactor, int amount, BankAccount account, Calendar transaccionDate) {
        super(idTransacction, transactor, amount, account, transaccionDate);
    }
    
    public void WithdrawFromAccount(Person transactor, int amount, BankAccount account){
       amount = getAmount();
       transactor = getTransactor();
       account = getAccount();
       
       account.setAmount(account.getAmount()- amount);
       System.out.print("Usted obtuvo: "+amount+ "de su cuenta");
   }
}
