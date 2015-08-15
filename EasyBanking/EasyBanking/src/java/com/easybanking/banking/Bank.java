/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import java.util.ArrayList;

/**
 *
 * @author Soler
 */
public class Bank {

    private int id;
    private String name;
    private String country;
    private int phone;
    private ArrayList<Person> listOfPersons = new ArrayList<>();

    public Bank() {
    }

    public Bank(int id, String name, String country, int phone) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.phone = phone;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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

    public Person personValidation(String id, String password) {

        for (Person p : this.listOfPersons) {

            if (p.getId().equals(id)) {

                if (p.getPassword().equals(password)) {

                    return p;
                }
            }

        }

        return null;
    }

    public Person personConfirmation(String id) {

        for (Person p : this.listOfPersons) {

            if (p.getId().equals(id)) {

                return p;
            }
        }
        return null;
    }

    public ArrayList<Person> searchedPerson(String name) {
        
        ArrayList<Person> searchList = new ArrayList<>();

        for (Person p : this.listOfPersons) {

            if (p.getId().toLowerCase().equals(name.toLowerCase())) {

                if (p.getName().toLowerCase().equals(name.toLowerCase())) {

                    if (p.getLastName().toLowerCase().equals(name.toLowerCase())) {

                        if (p.getEmail().toLowerCase().equals(name.toLowerCase())) {

                            searchList.add(p);

                        }

                    }
                }
            }
        }
        return searchList;
    }

    @Override
    public String toString() {
        return "Bank{" + "id=" + id + ", name=" + name + ", country=" + country + ", phone=" + phone + '}';
    }

}
