/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import java.util.Calendar;

/**
 *
 * @author Soler
 */
public class FirmaDigital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Person p = new Person("1032350", "Carlos", "213", "qwdqwd", Calendar.getInstance(), 8008000);
        Bank easyBank = new Bank(1, "BAC", "Costa Rica", 800800800);
        BankAccount b = new BankAccount(123, 2, 2500, Calendar.getInstance(), Calendar.getInstance());
        p.getlistOfBankAccounts().add(b);
        easyBank.addPersons(p);

        System.out.println(p);

    }

}
