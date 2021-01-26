/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antariksa.fx.dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ale
 */
public class DBConnector {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DB = "peluncuranroket";
    private static final String MYSQLCON = "jdbc:mysql://localhost/"+DB;
    private static final String SQLITECON = "jdbc:sqlite:C:\\Users\\ACER\\Documents\\_Java_Project\\PeluncuranRoket.sqlite";
    
    public static Connection getConnection(String driver) throws SQLException{
        Connection conn = null;
        switch(driver){
            case "MYSQL": {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(MYSQLCON, USERNAME, PASSWORD);
                } catch (ClassNotFoundException ex) {
                    
                    System.out.println("Library tidak ditemukan...");
                    Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "JDBC": {
                try {
                    Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection(SQLITECON);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library tidak ditemukan...");
                    Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }   
        return conn;
    }   
}
