/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.entity;

import java.util.ArrayList;

/**
 *
 * @author Soler
 */
public class Bank implements AvailableCurrencies {

    private int id;
    private String name;
    private String country;
    private String phone;
    private ArrayList<BankBranch> listOfBranches = new ArrayList<>();
    private ArrayList<Person> listOfPersons = new ArrayList<>();

    public Bank() {
    }

    public Bank(int id, String name, String country, String phone) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.phone = phone;
    }

    public Bank(int id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Person> getListOfPersons() {
        return listOfPersons;
    }

    public void setListOfPersons(ArrayList<Person> listOfPersons) {
        this.listOfPersons = listOfPersons;
    }

    public void addPersons(Person p) {
        this.listOfPersons.add(p);
    }

    public ArrayList<BankBranch> getListOfBranches() {
        return listOfBranches;
    }

    public void setListOfBranches(ArrayList<BankBranch> listOfBranches) {
        this.listOfBranches = listOfBranches;
    }

    @Override
    public String toString() {
        return "Bank{" + "id=" + id + ", name=" + name + ", country=" + country + ", phone=" + phone + '}';
    }

}
