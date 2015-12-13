/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.business;

import com.easybanking.data.PersonData;
import com.easybanking.entity.Administrator;
import com.easybanking.entity.Client;
import com.easybanking.entity.LegalClient;
import com.easybanking.entity.Person;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Soler
 */
@ManagedBean(name = "BANKBEAN")
@RequestScoped
public class BankBean {

    /**
     * Creates a new instance of BankBean
     */
    private String searchId = ""; 
           
    private LegalClient legalClient = new LegalClient();
    
    private Client client = new Client();
    
    private Administrator admin = new Administrator();
    
    public BankBean() {
        
        
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }


    public void getClientFromId(){
    
    PersonData pd = new PersonData();
    
    Person searchIdClient = pd.readClient(searchId);
        
        if (searchIdClient instanceof Client) {
            
            client = (Client)searchIdClient;
            
        }else if(searchIdClient instanceof LegalClient) {
            
            legalClient = (LegalClient)searchIdClient;
        
        }else if(searchIdClient instanceof Administrator) {
        
             admin = (Administrator)searchIdClient;
            
        }
    }

}