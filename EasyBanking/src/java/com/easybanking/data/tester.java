/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.data;

import com.easybanking.business.BankBean;
import com.easybanking.business.LoginBean;
import com.easybanking.entity.Bank;
import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Client;
import com.easybanking.entity.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Soler
 */
public class tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String pass = "123";
        String newPass = encriptPassword(pass);
        Bank bank = new Bank();
        bank.setId(1);
        System.out.println(newPass);

        BankBean bb = new BankBean();
        LoginBean lb = new LoginBean();
        lb.setSelectedBank(bank);
        BankData bd = new BankData();
        ArrayList<Person> resultList = bd.getListOfPersons(lb.getSelectedBank());

        BankAccountData bad = new BankAccountData();
        Client p = new Client();
        p.setId("456");
        p.setName("CARLOS");
        p.setLastName("Soto");
        p.setLastName2("soto");
        p.setEmail("wefd@DSF");
        p.setAddress("asdqw");
        p.setBirthDate(Calendar.getInstance(Locale.ENGLISH));
        p.setPhone("1234");

        PersonData pd = new PersonData();
        boolean insert = pd.create(p);

        System.out.println("" + insert);

        for (BankAccount ba : bad.getListOfAccounts(bank, p)) {

            System.out.println("" + ba.getId());

        }
        bb.loadTable();
    }

    public static String encriptPassword(String encriptPass) {
        String encripted = DigestUtils.md5Hex(encriptPass);
        return encripted;

    }

}
