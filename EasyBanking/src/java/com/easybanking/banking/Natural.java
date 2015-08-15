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
public class Natural extends Person{

    public Natural() {
    }

    public Natural(String id, String name, String lastName, String lastName2, String email, String password, String direction, Calendar birthDate, String phone) {
        super(id, name, lastName, lastName2, email, password, direction, birthDate, phone);
    }


    
}
