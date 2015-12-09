/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.business;

import com.easybanking.data.PersonData;
import com.easybanking.entity.Administrator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Soler
 */
@ManagedBean(name = "LOGINADMIN")
@SessionScoped

public class LoginBean {

    private Administrator admin = new Administrator();

    private Administrator loggedAdmin = new Administrator();

    public LoginBean() {

    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public Administrator getLoggedAdmin() {
        return loggedAdmin;
    }

    public void setLoggedAdmin(Administrator loggedAdmin) {
        this.loggedAdmin = loggedAdmin;
    }

    
    public String encriptPassword(String encriptPass) {
        String encripted = DigestUtils.md5Hex(encriptPass);
        return encripted;
    }
    
    public String verifyAdmin(){

        String url = "";
        
        PersonData pd = new PersonData();
        
        if (pd.read(admin) != null) {
            
            loggedAdmin = (Administrator) pd.read(admin);
           
            String encriptedPass = encriptPassword(admin.getPassword());
            
            if (encriptedPass.equals(loggedAdmin.getPassword())) {
                
                url = "/home.xhtml";
                
            }else{
            
                //password incorrecto
            url = "/login.xhtml?ERROR";
                
            }
          
        }else{
    
            //el usuario no existe
           url = "/login.xhtml?faces-redirect=true";
            
        }

        return url;

    }

}
