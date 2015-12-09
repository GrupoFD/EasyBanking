/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joselyn
 */
public class BaseData {

    public static BaseData instance;
    private Connection con;
    private String url = "jdbc:sqlserver://uxgv6xybvi.database.windows.net:1433;databaseName=EasyBanking";
    private String login = "carara";
    private String password = "c4r4r4SICAP";

    private BaseData(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, login, password);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseData.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(BaseData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    //synchronized permite la lista de espera si muchos desean conectarse al mismo tiempo

    public synchronized static BaseData connectionState(){
        if (instance == null) {
            instance = new BaseData();
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }

    public void closeCon() {

        instance = null;
    }

}
