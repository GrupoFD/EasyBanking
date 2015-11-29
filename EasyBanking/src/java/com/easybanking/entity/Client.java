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
public class Client extends Natural {

    public Client() {
    }

    public Client(String id, String name, String lastName, String lastName2, String email, String adress, Calendar birthDate, String phone) {
        super(id, name, lastName, lastName2, email, adress, birthDate, phone);
    }
    
        
    
}
