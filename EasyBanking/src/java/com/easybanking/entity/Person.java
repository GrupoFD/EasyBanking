/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Soler
 */
public class Person {

    private String id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private ArrayList<BankAccount> listOfBankAccounts = new ArrayList<>();

    public Person() {

    }

    public Person(String id, String name, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String direction) {
        this.address = direction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<BankAccount> getlistOfBankAccounts() {
        return listOfBankAccounts;
    }

    public void setListOfAccounts(ArrayList<BankAccount> listOfBankAccounts) {
        this.listOfBankAccounts = listOfBankAccounts;
    }

    public void addAccount(BankAccount a) {
        this.listOfBankAccounts.add(a);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<BankAccount> getListOfBankAccounts() {
        return listOfBankAccounts;
    }

    public void setListOfBankAccounts(ArrayList<BankAccount> listOfBankAccounts) {
        this.listOfBankAccounts = listOfBankAccounts;
    }

    public String getResponsible(Person p) {

        String responsible = "";

        if (p instanceof Legal) {

            responsible = ((Legal) p).getResponsible().toString();

        } else {

            responsible = "-----";
        }

        return responsible;
    }

    public String printAccounts() {

        String returnable = "";

        for (BankAccount i : listOfBankAccounts) {
            returnable += i.toString();

        }

        return returnable;
    }

    public String convertCalendar(Calendar date) {

        Calendar c = date.getInstance();

        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String annio = Integer.toString(c.get(Calendar.YEAR));
        String dateF = dia + "/" + mes + "/" + annio;
        
        return dateF;
    }
//    public void sendEmail(String password, String email) {
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
////        props.put("mail.smtp.host", "smtp.gmail.com");
////        props.put("mail.smtp.socketFactory.port", "465");
////        props.put("mail.smtp.socketFactory.class",
////                "javax.net.ssl.SSLSocketFactory");
////        props.put("mail.smtp.auth", "true");
////        props.put("mail.smtp.port", "465");
//
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication("easybankprogra@gmail.com", "easybank506");
//                    }
//                });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("easybankprogra@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(email));
//            message.setSubject("EasyBanking constraseña");
//            message.setText("Su contraseña es: \n" + password);
//            Transport.send(message);
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");

        StringBuffer sb = new StringBuffer();

        sb.append("EASY BANK! \n");
        sb.append("Cedula: " + this.getId() + "\n");
        sb.append("Nombre: " + this.getName() + "         Telefono: " + this.getPhone() + "\n");
        sb.append("Dirección: " + this.getAddress() + "    \n");
        sb.append("Responsable: " + this.getResponsible(this) + "\n");
        sb.append("------------------------------------------------------------------------ \n");
        sb.append("-------------------------- Cuentas Bancarias --------------------------- \n");
        sb.append("------------------------------------------------------------------------ \n");
        sb.append(this.printAccounts());
        sb.append("----------------------------------------------------------------------- \n");

        return sb.toString();
    }

}
