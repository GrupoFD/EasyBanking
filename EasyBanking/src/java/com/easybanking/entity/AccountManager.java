/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.entity;

import java.util.Calendar;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Soler
 */
public class AccountManager extends Natural {

    private String password;

    public AccountManager(String password) {
        this.password = password;
    }

    public AccountManager(String password, String id, String name, String lastName, String lastName2, String email, String adress, Calendar birthDate, String phone) {
        super(id, name, lastName, lastName2, email, adress, birthDate, phone);
        this.password = encriptPassword(password);
    

    }
    
       public String encriptPassword(String encriptPass) {
        String encripted = DigestUtils.md5Hex(encriptPass);
        return encripted;
    }
}
