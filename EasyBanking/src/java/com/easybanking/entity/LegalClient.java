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
public class LegalClient extends Legal{

    public LegalClient(String id, String name, String email, String address, String phone, Natural responsible) {
        super(id, name, email, address, phone, responsible);
    }

    public LegalClient() {
        
    }

    
}
