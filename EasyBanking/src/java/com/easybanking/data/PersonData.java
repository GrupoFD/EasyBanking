/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.data;

import com.easybanking.entity.Administrator;
import com.easybanking.entity.Client;
import com.easybanking.entity.LegalClient;
import com.easybanking.entity.Natural;
import com.easybanking.entity.Person;
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
 * @author Joselyn
 */
public class PersonData implements InterfaceCRUD<Person> {

    private final BaseData con = BaseData.connectionState();
    private PreparedStatement ps;

    public PersonData() {

    }

    @Override
    public Person readClient(Object key) {
        
        Person client = null;
        
        Calendar date = Calendar.getInstance();
        
        try {

            ps = this.con.getCon().prepareStatement("SELECT * FROM Person WHERE PersonId = ?");

            ps.setString(1, key.toString());

            ResultSet res = ps.executeQuery();
            
            while (res.next()) {

                date.setTime(res.getDate(7));
                
                if (res.getInt(9) == 1) {

                    client = new Administrator(res.getString(11), res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), date, res.getString(8));

                } else if (res.getInt(9) == 2) {

                    client = new Client(res.getString(1),res.getString(2),res.getString(3),res.getString(4), res.getString(5), res.getString(6), date, res.getString(8));
                    
                } else if (res.getInt(9) == 3) {
                    
                    Natural c = new Natural();
                    
                    c.setId(res.getString(9));

                   client = new LegalClient(res.getString(1),res.getString(2),res.getString(5), res.getString(6), res.getString(8), c); 
                    
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonData.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            con.closeCon();
        }

        return client;
    }

    @Override
    public boolean create(Person c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Person c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Person c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person read(Person c) {

        Person admin = null;

        try {

            Calendar date = Calendar.getInstance();

            ps = this.con.getCon().prepareStatement("SELECT *"
                    + " FROM Person WHERE PersonId = ?");

            ps.setString(1, c.getId());

            ResultSet res = ps.executeQuery();

            while (res.next()) {

                date.setTime(res.getDate(7));

                if (res.getInt(9) == 1) {

                    admin = new Administrator(res.getString(11), res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), date, res.getString(8));

                } else {

                    admin = null;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonData.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            con.closeCon();
        }

        return admin;
    }

    @Override
    public ArrayList<Person> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
