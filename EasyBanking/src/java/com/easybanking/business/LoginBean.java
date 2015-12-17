/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.business;

import com.easybanking.data.BankData;
import com.easybanking.data.PersonData;
import com.easybanking.entity.Administrator;
import com.easybanking.entity.Bank;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Soler
 */
@ManagedBean(name = "LOGINBEAN")
@SessionScoped

public class LoginBean {

    private String msgError;
    private boolean msg = false;
    private Administrator loggedAdmin = new Administrator();
    private Administrator admin = new Administrator();
    private Bank selectedBank = new Bank();

    public LoginBean() {

    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public Administrator getLoggedAdmin() {
        return loggedAdmin;
    }

    public void setLoggedAdmin(Administrator loggedAdmin) {
        this.loggedAdmin = loggedAdmin;
    }

    public boolean isMsg() {
        return msg;
    }

    public void setMsg(boolean msg) {
        this.msg = msg;
    }

    public Bank getSelectedBank() {
        return selectedBank;
    }

    public void setSelectedBank(Bank selectedBank) {
        this.selectedBank = selectedBank;
    }

    public ArrayList<Bank> getListOfBanks() {
        BankData bd = new BankData();
        ArrayList<Bank> listOfBanks = bd.readAll();
        return listOfBanks;
    }

    public String encriptPassword(String encriptPass) {
        String encripted = DigestUtils.md5Hex(encriptPass);
        return encripted;
    }

    public String verifyAdmin() {

        String url = "";

        PersonData pd = new PersonData();

        if (selectedBank != null) {

            if (pd.read(admin) != null) {

                loggedAdmin = (Administrator) pd.read(admin);

                String encriptedPass = encriptPassword(admin.getPassword());

                if (encriptedPass.equals(loggedAdmin.getPassword())) {
                    url = "/home.xhtml";
                    msgError = "";
                } else {
                    //password incorrecto
                    //url = "/login.xhtml";
                    msgError = "Contraseña incorrecta.";
                    msg = true;
                }
            } else {
                //el usuario no existe
                //url = "/login.xhtml";
                msgError = "El usuario no existe.";
                msg = true;
            }
        } else {
            //no selecciono banco            
            //url = "/login.xhtml";
            msgError = "Seleccione un Banco";
            msg = true;
        }
        
        return url;

    }

    //Invalidate session
}
