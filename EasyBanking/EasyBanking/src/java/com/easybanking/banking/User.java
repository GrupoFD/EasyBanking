/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Soler
 */
public class User extends Person {

    protected int salary;
    protected String workShift;

    public User() {
    }

    public User(String id, String name, String lastName, String lastName2, String email, String password, String direction, Calendar birthDate, String phone, int salary, String workShift) {
        super(id, name, lastName, lastName2, email, password, direction, birthDate, phone);
        this.salary = salary;
        this.workShift = workShift;
    }



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkShift() {
        return workShift;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    @Override
    public String toString() {
        return "User{" + ", salary=" + salary + ", workShift=" + workShift + '}';
    }

}
