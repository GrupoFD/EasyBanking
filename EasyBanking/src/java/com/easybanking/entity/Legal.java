/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.entity;

import java.util.Calendar;

/**
 *
 * @author Soler
 */
public class Legal extends Person{
    
    private Person responsible;
    
    public Legal(){}

    public Legal(String id, String name, String email, String address, String phone, Person responsible) {
        super(id, name, email, address, phone);
        this.responsible = responsible;
    }
 
    public Person getResponsible() {
        return responsible;
    }

    public void setResponsible(Person responsible) {
        this.responsible = responsible;
    }

    @Override
    public String toString() {
        return ""+ responsible.getName();
    }
    
    
    
    
}
