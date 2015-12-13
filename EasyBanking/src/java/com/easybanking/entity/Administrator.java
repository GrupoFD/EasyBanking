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
public class Administrator extends Natural {

    private String password;

    public Administrator() {

    }

    public Administrator(String password) {
        this.password = password;
    }

    public Administrator(String password, String id, String name, String lastName, String lastName2, String email, String adress, Calendar birthDate, String phone) {
        super(id, name, lastName, lastName2, email, adress, birthDate, phone);
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
