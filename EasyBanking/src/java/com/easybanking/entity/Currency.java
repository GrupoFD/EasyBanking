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
public class Currency {
    
    private int id;
    private String name;
    private double changeRate;

    public Currency(int id, String name, double changeRate) {
        this.id = id;
        this.name = name;
        this.changeRate = changeRate;
    }

    public Currency() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(double changeRate) {
        this.changeRate = changeRate;
    }
    
    
}
