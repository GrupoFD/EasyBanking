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

                if (res.getInt(9) != 3) {

                    client = new Client(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), date, res.getString(8));

                } else if (res.getInt(9) == 3) {

                    //LEGAL
                    Natural c = new Natural();

                    c.setId(res.getString(9));

                    c = (Natural) read(c);

                    client = new LegalClient(res.getString(1), res.getString(2), res.getString(5), res.getString(6), res.getString(8), c);

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

        boolean bool = false;

        try {
            if (c instanceof Client) {
                Client n = (Client) c;
                ps = this.con.getCon().prepareStatement("INSERT INTO Person (PersonId, Name, Lastname, SecondLastname, Email, Address, Birthdate, Phone, PersonType)"
                        + " Values(?,?,?,?,?,?,?,?,?)");
                ps.setString(3, n.getLastName());
                ps.setString(4, n.getLastName2());
                ps.setString(5, n.getEmail());
                ps.setString(6, n.getAddress());
                Calendar s = n.getBirthDate().getInstance(); //
                ps.setDate(7, new java.sql.Date(s.getTimeInMillis()));
                ps.setString(8, n.getPhone());
                ps.setInt(9, 2);

            } else if (c instanceof LegalClient) {
                LegalClient l = (LegalClient) c;
                ps = this.con.getCon().prepareStatement("INSERT INTO Person (PersonId, Name, Email, Address,  Phone, PersonType, Responsable)"
                        + " Values(?,?,?,?,?,?,?)");
                ps.setString(3, l.getEmail());
                ps.setString(4, l.getAddress());
                ps.setString(5, l.getPhone());
                ps.setInt(6, 3);
                ps.setString(7, l.getResponsible().getId());
            }
            ps.setInt(1, Integer.parseInt(c.getId()));
            ps.setString(2, c.getName());
            ps.executeUpdate();
            bool = true;
            
        } catch (SQLException ex) {

            Logger.getLogger(PersonData.class.getName()).log(Level.SEVERE, null, ex);
            bool = false;

        } finally {

            con.closeCon();
        }

        return bool;
    }

    @Override
    public boolean delete(Person c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Person c) {
       
        boolean update = false;
        try {
            
        
        if(c instanceof Client){
              Calendar s = Calendar.getInstance();
              
        Client n = (Client)c;
        n.setBirthDate(s);
        ps = con.getCon().prepareStatement("Update Person SET Name = ?, lastname = ?, secondLastname = ?, email = ?, address =?, birthdate= ?, phone = ?, personType = ? Where PersonId = ?" );
                 ps.setString(1, c.getName());
                ps.setString(2, n.getLastName());
                ps.setString(3, n.getLastName2());
                ps.setString(4, n.getEmail());
                ps.setString(5, n.getAddress());
                //
                ps.setDate(6,new java.sql.Date(s.getTimeInMillis()) );
                ps.setString(7, n.getPhone());
                ps.setString(8, "2");
                 ps.setInt(9, Integer.parseInt(c.getId()));
                 
            }
        if (c instanceof LegalClient) {
                 LegalClient l = (LegalClient)c;
                ps = this.con.getCon().prepareStatement("Update Person SET name = ?, email =?, address = ?,  phone= ?, personType = ?, responsable = ? Where PersonId = ?");
                ps.setString(1, c.getName());
                ps.setString(2, l.getEmail());
                ps.setString(3, l.getAddress());
                ps.setString(4, l.getPhone());
                ps.setString(5, "3");
                ps.setString(6, "");
                ps.setInt(7, Integer.parseInt(c.getId()));
            }
 
           ps.executeUpdate();
           ps.close();
           
           
           update = true;
           
        } catch (SQLException ex) {
            Logger.getLogger(PersonData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return update;
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
