/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.business;

import com.easybanking.entity.BankAccount;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    
    @ManagedProperty(value = "#{LOGINBEAN}")
    private LoginBean login;
    
    private ArrayList<BankAccount> listOfAccounts = new ArrayList<>();
    
    private BankAccount newBankAccount = new BankAccount();

    private boolean isNatural = false;
    
    private boolean isLegal = false;

    public BankAccountsBean() {
    }

    public ArrayList<BankAccount> getListOfAccounts() {
        return listOfAccounts;
    }

    public void setListOfAccounts(ArrayList<BankAccount> listOfAccounts) {
        this.listOfAccounts = listOfAccounts;
    }

    public BankAccount getNewBankAccount() {
        return newBankAccount;
    }

    public void setNewBankAccount(BankAccount newBankAccount) {
        this.newBankAccount = newBankAccount;
    }

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }
    
    public boolean isIsNatural() {
        return isNatural;
    }

    public void setIsNatural(boolean isNatural) {
        this.isNatural = isNatural;
    }

    public boolean isIsLegal() {
        return isLegal;
    }

    public void setIsLegal(boolean isLegal) {
        this.isLegal = isLegal;
    }
    
    
    
    public String createAccount() {

        String url = "";

       
        url = "/accountcreation.xhtml";
               
        
        return url;

    }
    
}
