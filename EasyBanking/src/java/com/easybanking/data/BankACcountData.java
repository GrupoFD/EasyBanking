/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.data;

import com.easybanking.entity.Bank;
import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Currency;
import com.easybanking.entity.Person;
import com.easybanking.entity.Savings;
import com.easybanking.singleton.InterfaceCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Soler
 */
public class BankAccountData implements InterfaceCRUD<BankAccount>{

    private final BaseData con = BaseData.connectionState();
    private PreparedStatement ps;
    
    public BankAccountData(){
        
    }
    
    public ArrayList<BankAccount> getListOfAccounts(Bank b, Person p) {

        PersonData pd = new PersonData();
        Calendar date = Calendar.getInstance();
        ArrayList<BankAccount> listOfAccounts = new ArrayList<>();
        Currency c = new Currency();
        
        try {

            ps = this.con.getCon().prepareStatement("SELECT *"
                    + " FROM Account WHERE BankId = ? AND PersonId = ?");

            ps.setInt(1, b.getId());
            ps.setString(2, ""+p.getId());
            ResultSet res = ps.executeQuery();

            while (res.next()) {

                c.setId(res.getInt(2));
                date.setTime(res.getDate(7));
                
                if (res.getInt(2) == 1) {
                   
                    listOfAccounts.add(new Savings(res.getString(1), b, res.getFloat(4), c, p,date,date,0,0,true));
                }
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            con.closeCon();
        }

        return listOfAccounts;
    }
    
    
    @Override
    public BankAccount readClient(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(BankAccount c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(BankAccount c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(BankAccount c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BankAccount read(BankAccount c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BankAccount> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
