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
import java.util.Locale;
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
        Currency c = new Currency(1,"Dolares",541);
        
        try {

            ps = this.con.getCon().prepareStatement("SELECT *"
                    + " FROM Account WHERE BankId = ? AND PersonId = ?");

            ps.setInt(1, b.getId());
            ps.setString(2, ""+p.getId());
            ResultSet res = ps.executeQuery();

            while (res.next()) {

                c.setId(res.getInt(2));
                date.setTime(Calendar.getInstance(Locale.ENGLISH).getTime());
                
                if (res.getInt(2) == 1) {
                   
                    listOfAccounts.add(new Savings(res.getString(1), b, res.getFloat(4), c, p,date,date,0,0, true));
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
        
        try {
            ps = this.con.getCon().prepareStatement("INSERT INTO Account (AccountNumber, AccountType, BankID, Balance, IdCurrency, PersonId, CreationDate, ExperationDate, giftPoints)"
                    + " Values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, c.getId());
            ps.setInt(2, 1);
            ps.setInt(3, c.getIssuer().getId());
            ps.setDouble(4, c.getAmountBalance());
            ps.setInt(5, c.getCurrency().getId());
            ps.setInt(6,Integer.parseInt(c.getOwner().getId()));
            Calendar s = c.getCreationDate();
            ps.setDate(7,new java.sql.Date(s.getTimeInMillis()));
            Calendar d = c.getExpirationDate();
            ps.setDate(8,new java.sql.Date(d.getTimeInMillis()) );
            ps.setInt(9, 0);
            ps.executeUpdate();
       return true; 
        } catch (SQLException ex) {
            Logger.getLogger(BankAccountData.class.getName()).log(Level.SEVERE, null, ex);
        }finally {

            con.closeCon();
        }
        return false;
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
    
    public String createAccountNumber(Bank myBank, int typeOfAccount){
 
        String newIdNumber = "";
        String lastIdCheck = "";
        String lastNumberString = "";
        int lastNumberInt = 0;
        int lastBiggestNumber = 0;

        switch (typeOfAccount) {
            case 1:
                newIdNumber = "100-"; // New Colon Savings-Account
                break;
            case 2:
                newIdNumber = "200-"; // New Dollar Savings-Account
                break;
            case 3:
                newIdNumber = "300-"; // New Euro Savings-Account 
                break;
            case 4:
                newIdNumber = "400-"; // New Colon Credit-Account 
                break;
            case 5:
                newIdNumber = "500-"; // New Dollar Credit-Account 
                break;
            case 6:
                newIdNumber = "600-"; // New Euro Credit-Account 
                break;
        }

        for (Person p : myBank.getListOfPersons()) {
            for (BankAccount b : p.getListOfBankAccounts()) {
                lastIdCheck = b.getId();
                lastNumberString = lastIdCheck.substring(4, 10);
                lastNumberInt = Integer.parseInt(lastNumberString);
                if (lastNumberInt > lastBiggestNumber) {
                    lastBiggestNumber = lastNumberInt;
                }
            }
        }

        if (lastBiggestNumber < 9) {
            newIdNumber += "00000" + String.valueOf(lastBiggestNumber + 1);
        } else if (lastBiggestNumber >= 9 && lastBiggestNumber < 99) {
            newIdNumber += "0000" + String.valueOf(lastBiggestNumber + 1);
        } else if (lastBiggestNumber >= 99 && lastBiggestNumber < 1000) {
            newIdNumber += "000" + String.valueOf(lastBiggestNumber + 1);
        }

        return newIdNumber;
}
}
