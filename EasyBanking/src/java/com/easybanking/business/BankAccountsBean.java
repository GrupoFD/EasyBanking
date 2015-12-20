/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.business;

import com.easybanking.entity.BankAccount;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Soler
 */
@ManagedBean(name = "ACCOUNTBEAN")
@SessionScoped

public class BankAccountsBean {

    /**
     * Creates a new instance of BankAccountsBean
     */
    private ArrayList<BankAccount> listOfAccounts = new ArrayList<>();
    

    public BankAccountsBean() {
    }

    public ArrayList<BankAccount> getListOfAccounts() {
        return listOfAccounts;
    }

    public void setListOfAccounts(ArrayList<BankAccount> listOfAccounts) {
        this.listOfAccounts = listOfAccounts;
    }
    
}
