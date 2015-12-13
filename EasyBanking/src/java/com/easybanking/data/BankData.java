/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.data;

import com.easybanking.entity.BankAccount;
import com.easybanking.entity.IdSet;
import com.easybanking.entity.Person;
import com.easybanking.singleton.InterfaceCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tolkerism
 */
public class BankData implements InterfaceCRUD<IdSet> {
    
    private final BaseData con = BaseData.connectionState();
    private PreparedStatement ps;
    
     public IdSet read(IdSet set) {

        try {

            ps = this.con.getCon().prepareStatement("SELECT *"
                    + " FROM PeopleBank WHERE IdBank = ?");

            ps.setString(1, "" +set.getBankId());

            ResultSet res = ps.executeQuery();

            while (res.next()) {
                set.getListOfPersonId().add(res.getInt(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonData.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            con.closeCon();
        }
        return set;
     }
            
    
    @Override
    public List<IdSet> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IdSet readClient(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(IdSet c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(IdSet c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(IdSet c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
