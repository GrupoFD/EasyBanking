/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.business;

import com.easybanking.data.PersonData;
import com.easybanking.entity.Client;
import com.easybanking.entity.LegalClient;
import com.easybanking.entity.Person;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Soler
 */
@ManagedBean(name = "CREATEUSERBEAN")
@SessionScoped

public class NewPersonBean {

    /**
     * Creates a new instance of NewPersonBean
     */
    @ManagedProperty(value = "#{ACCOUNTBEAN}")
    private BankAccountsBean accountBankBean;
    
    @ManagedProperty(value = "#{BANKBEAN}")
    private BankBean bankBean;


    private Client natural = new Client();

    private LegalClient legal = new LegalClient();

    private Person responsible = new Person();

    private String msgError;

    private boolean msg = false;

    private String alertColor = "danger";

    public NewPersonBean() {
    }

    public Client getNatural() {
        return natural;
    }

    public void setNatural(Client natural) {
        this.natural = natural;
    }

    public LegalClient getLegal() {
        return legal;
    }

    public void setLegal(LegalClient legal) {
        this.legal = legal;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public boolean isMsg() {
        return msg;
    }

    public void setMsg(boolean msg) {
        this.msg = msg;
    }

    public String getAlertColor() {
        return alertColor;
    }

    public void setAlertColor(String alertColor) {
        this.alertColor = alertColor;
    }

    public Person getResponsible() {
        return responsible;
    }

    public void setResponsible(Person responsible) {
        this.responsible = responsible;
    }

    public BankAccountsBean getAccountBankBean() {
        return accountBankBean;
    }

    public void setAccountBankBean(BankAccountsBean accountBankBean) {
        this.accountBankBean = accountBankBean;
    }
    
    

    public String createNaturalUser() {

        String url = "";

        PersonData pd = new PersonData();
        boolean insert = pd.create(natural);

        if (insert == true) {

            bankBean.setSelectedNaturtalClient(natural);
            msgError = "El usuario se agrego con exito!";
            alertColor = "success";
            accountBankBean.setIsNatural(true);
            accountBankBean.setIsLegal(false);
            msg = true;

        } else {

            msgError = "El usuario no se agrego con exito!";
            alertColor = "danger";
            msg = true;

        }

        return url;
    }

    public String createLegalUser() {

        String url = "";

        legal.setResponsible(responsible);

        PersonData pd = new PersonData();
        boolean insert = pd.create(legal);

        if (insert == true) {

            bankBean.setSelectedLegalClient(legal);
            msgError = "El usuario se agrego con exito!";
            alertColor = "success";
            msg = true;
            accountBankBean.setIsNatural(false);
            accountBankBean.setIsLegal(true);

        } else {

            msgError = "El usuario no se agrego con exito!";
            alertColor = "danger";
            msg = true;

        }

        return url;
    }
}
