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
public class Legal extends Person{
    
    private String responsible;

    public Legal(String id, String name, String lastName, String lastName2, String email, String password, String direction, Calendar birthDate, String phone, String responsible) {
        super(id, name, lastName, lastName2, email, password, direction, birthDate, phone);
        this.responsible = responsible;
    }


 
    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
    
    
    
    
}
