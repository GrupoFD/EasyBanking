/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.data;

import com.easybanking.entity.Bank;
import com.easybanking.entity.Person;
import com.easybanking.singleton.InterfaceCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tolkerism
 */
public class BankData implements InterfaceCRUD<Bank> {

    private final BaseData con = BaseData.connectionState();
    private PreparedStatement ps;

    public ArrayList<Person> getListOfPersons(Bank Bank) {

        PersonData pd = new PersonData();

        ArrayList<Person> listOfPersons = new ArrayList<>();

        try {

            ps = this.con.getCon().prepareStatement("SELECT PersonId"
                    + " FROM PeopleFromBank WHERE BankId = ?");

            ps.setString(1, "" + Bank.getId());
            ResultSet res = ps.executeQuery();

            while (res.next()) {

                listOfPersons.add(pd.readClient(res.getString(1)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            con.closeCon();
        }

        return listOfPersons;
    }

    @Override
    public Bank readClient(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

    @Override
    public boolean create(Bank c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Bank c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Bank c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bank read(Bank c) {

        try {

            ps = this.con.getCon().prepareStatement("SELECT *"
                    + " FROM Bank WHERE BankId = ?");

            ps.setString(1, "" + c.getId());

            ResultSet res = ps.executeQuery();

            while (res.next()) {

                c = new Bank(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            con.closeCon();
        }

        return c;
    }

    @Override
    public ArrayList<Bank> readAll() {

        ArrayList<Bank> listOfBanks = new ArrayList<Bank>();

        try {

            ps = this.con.getCon().prepareStatement("SELECT *"
                    + " FROM Bank");

            ResultSet res = ps.executeQuery();

            while (res.next()) {

                listOfBanks.add(new Bank(res.getInt(1), res.getString(2), res.getString(3), res.getString(4)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            con.closeCon();
        }

        return listOfBanks;
    }

}
