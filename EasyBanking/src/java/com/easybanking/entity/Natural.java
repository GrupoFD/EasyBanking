/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.entity;

import com.easybanking.entity.Person;
import java.util.Calendar;

/**
 *
 * @author Soler
 */
public class Natural extends Person {

    private Calendar birthDate;
    private String lastName;
    private String lastName2;

    public Natural() {
    }

    public Natural(String id, String name, String lastName, String lastName2, String email, String address, Calendar birthDate, String phone) {
        super(id, name, email, address, phone);
        this.birthDate = birthDate;
        this.lastName = lastName;
        this.lastName2 = lastName2;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return getId() + " " +getLastName();
    }

    
}
