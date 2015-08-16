/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

/**
 *
 * @author Glenn Benavides
 */
public class Combo4x3 {
    
    private BankAccount account_1;
    private BankAccount account_2;
    private BankAccount account_3;
    private BankAccount account_4;

    public Combo4x3() {
    }

    public Combo4x3(BankAccount account_1, BankAccount account_2, BankAccount account_3, BankAccount account_4) {
        this.account_1 = account_1;
        this.account_2 = account_2;
        this.account_3 = account_3;
        this.account_4 = account_4;
    }

    public BankAccount getAccount_1() {
        return account_1;
    }

    public void setAccount_1(BankAccount account_1) {
        this.account_1 = account_1;
    }

    public BankAccount getAccount_2() {
        return account_2;
    }

    public void setAccount_2(BankAccount account_2) {
        this.account_2 = account_2;
    }

    public BankAccount getAccount_3() {
        return account_3;
    }

    public void setAccount_3(BankAccount account_3) {
        this.account_3 = account_3;
    }

    public BankAccount getAccount_4() {
        return account_4;
    }

    public void setAccount_4(BankAccount account_4) {
        this.account_4 = account_4;
    }
    
    public void applyComboToClient(Person client, BankAccount comboAccount_1, BankAccount comboAccount_2, BankAccount comboAccount_3, BankAccount comboAccount_4) {
    
        client.addAccount(account_1);
        client.addAccount(account_2);
        client.addAccount(account_3);
        client.addAccount(account_4);
    
    }
}
