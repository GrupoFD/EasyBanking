/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.entity;

/**
 *
 * @author Soler
 */
public class BankBranch extends Legal{

    private Bank bankOwner;
    private String idBranch;
    
    public BankBranch(Bank bankOwner, String id, String name, String email, String address, String phone, Natural responsible, String idBranch) {
        super(id, name, email, address, phone, responsible);
        this.bankOwner = bankOwner;
        this.idBranch = idBranch;
    }

    public Bank getBankOwner() {
        return bankOwner;
    }

    public void setBankOwner(Bank bankOwner) {
        this.bankOwner = bankOwner;
    }

    public String getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(String idBranch) {
        this.idBranch = idBranch;
    }
    
    
}
