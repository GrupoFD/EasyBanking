/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.entity;

import java.util.ArrayList;

/**
 *
 * @author Tolkerism
 */
public class IdSet {
    
    private int bankId;
    private int personId;
    private ArrayList<Integer> listOfPersonId = new ArrayList<>();

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
    
     public ArrayList<Integer> getListOfPersonId() {
        return listOfPersonId;
    }

    public void setListOfPersonId(ArrayList<Integer> listOfPersonId) {
        this.listOfPersonId = listOfPersonId;
    }

    public IdSet() {
    }
    
    public IdSet(int bankId, int personId) {
        this.bankId = bankId;
        this.personId = personId;
    }
    
}
