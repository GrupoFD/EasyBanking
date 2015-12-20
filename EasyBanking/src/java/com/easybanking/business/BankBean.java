/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.business;

import com.easybanking.data.BankAccountData;
import com.easybanking.data.BankData;
import com.easybanking.entity.BankBranch;
import com.easybanking.entity.Legal;
import com.easybanking.entity.Natural;
import com.easybanking.entity.Person;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Soler
 */
@ManagedBean(name = "BANKBEAN")
@SessionScoped

public class BankBean {
    
    @ManagedProperty(value="#{LOGINBEAN}")
    private LoginBean login;
    
    @ManagedProperty(value = "#{ACCOUNTBEAN}")
    private BankAccountsBean accountBankBean;
    
    private String searchId = "";

    private ArrayList<BankBranch> listOfBranches = new ArrayList<>();

    private ArrayList<Person> listOfPersons = new ArrayList<>();
    
    private Person selectedClient;

    public BankBean() {

    }

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }  
    
    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public ArrayList<BankBranch> getListOfBranches() {
        return listOfBranches;
    }

    public void setListOfBranches(ArrayList<BankBranch> listOfBranches) {
        this.listOfBranches = listOfBranches;
    }

    public ArrayList<Person> getListOfPersons() {
        return listOfPersons;
    }

    public void setListOfPersons(ArrayList<Person> listOfPersons) {

        this.listOfPersons = listOfPersons;
    }

    public Person getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Person selectedClient) {
        this.selectedClient = selectedClient;
    }

    public BankAccountsBean getAccountBankBean() {
        return accountBankBean;
    }

    public void setAccountBankBean(BankAccountsBean accountBankBean) {
        this.accountBankBean = accountBankBean;
    }
    
    
   
    public void loadTable() {

        listOfPersons.clear();
        
        BankData bd = new BankData();
        ArrayList<Person> resultList = bd.getListOfPersons(login.getSelectedBank());

        for (Person p : resultList) {
            
            if (p.getId().equals(searchId)) {
                
                listOfPersons.add(p);
            }
        }
    }
    
    public String goToClient(Person p) {

       BankAccountData bad = new BankAccountData();
        
       String url = "";
       
       this.selectedClient = p;
       
        if (p instanceof Natural) {
            
            accountBankBean.getListOfAccounts().clear();
            accountBankBean.setListOfAccounts(bad.getListOfAccounts(login.getSelectedBank(),getSelectedClient()));
            url = "naturalinfo.xhtml";
            
        }else if (p instanceof Legal) {
            
            accountBankBean.getListOfAccounts().clear();
            accountBankBean.setListOfAccounts(bad.getListOfAccounts(login.getSelectedBank(),getSelectedClient()));
            url = "legalinfo.xhtml";
        }
       
       return url;
    }

    
}
