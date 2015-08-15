/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Soler
 */
public class Person {

    private String id;
    private String name;
    private String lastName;
    private String lastName2;
    private String email;
    private String password;
    private String direction;
    private Calendar birthDate;
    private String phone;
    private ArrayList<BankAccount> listOfBankAccounts = new ArrayList<>();

    ;

    public Person() {

    }

    public Person(String id, String name, String lastName, String lastName2, String email, String password, String direction, Calendar birthDate, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.email = email;
        this.password = password;
        this.direction = direction;
        this.birthDate = birthDate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
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

            responsible = ((Legal) p).getResponsible();

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

    public String encriptPassword(String encriptPass) {
        String encripted = DigestUtils.md5Hex(encriptPass);
        return encripted;
    }

    public void sendEmail() {
        // Recipient's email ID needs to be mentioned.
        String to = "abcd@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "web@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Su contraseña");

            // Create the message part 
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText("Estimado usuario su contraseña es:");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "file.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");

        StringBuffer sb = new StringBuffer();

        sb.append("EASY BANK! \n");
        sb.append("Cedula: " + this.getId() + "\n");
        sb.append("Nombre: " + this.getName() + "         Telefono: " + this.getPhone() + "\n");
        sb.append("Dirección: " + this.getDirection() + "          Fecha Nacimiento: " + sdf.format(this.getBirthDate().getTime()) + "\n");
        sb.append("Responsable: " + this.getResponsible(this) + "\n");
        sb.append("------------------------------------------------------------------------ \n");
        sb.append("-------------------------- Cuentas Bancarias --------------------------- \n");
        sb.append("------------------------------------------------------------------------ \n");
        sb.append(this.printAccounts());
        sb.append("----------------------------------------------------------------------- \n");

        return sb.toString();
    }

}
