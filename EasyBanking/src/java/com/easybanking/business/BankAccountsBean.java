/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.business;

import com.easybanking.data.BankAccountData;
import com.easybanking.data.BankData;
import com.easybanking.entity.BankAccount;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
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
    
    @ManagedProperty(value = "#{BANKBEAN}")
    private BankBean bankbean;
    
    private ArrayList<BankAccount> listOfAccounts = new ArrayList<>();
    

    public BankAccountsBean() {
    }

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }

    public BankBean getBankbean() {
        return bankbean;
    }

    public void setBankbean(BankBean bankbean) {
        this.bankbean = bankbean;
    }

    public ArrayList<BankAccount> getListOfAccounts() {
        return listOfAccounts;
    }

    public void setListOfAccounts(ArrayList<BankAccount> listOfAccounts) {
        this.listOfAccounts = listOfAccounts;
    }
    
    @PostConstruct
    public void init(){
        BankAccountData bad = new BankAccountData();
         listOfAccounts = bad.getListOfAccounts(login.getSelectedBank(),bankbean.getSelectedClient());
    }
    public ArrayList<BankAccount> loadTable() {

        BankAccountData bad = new BankAccountData();
        ArrayList<BankAccount> resultList = bad.getListOfAccounts(login.getSelectedBank(),bankbean.getSelectedClient());
        
        return resultList;
    }
    
    
}
