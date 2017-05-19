/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.ConnectionClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ксения
 */
public class Manager {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    private ConnectionClass conCl;
    private Connection connection = null;
    private Statement statement = null;

    public void setConnectionContainer(ConnectionClass conCl) {
        this.conCl = conCl;
    }
    
    public boolean openConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(conCl.getUrl(), conCl.getName(), conCl.getPassword());
            statement = connection.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null,
//                    ex);
            return false;
        }
    }
    
    public boolean closeConnection(){
        if (connection != null) {
                try {
                    connection.close(); // Каскадное закрытие statement, resultSet
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(
                            Level.SEVERE,
                            null, ex);
                    return false;
                }
            }
        return true;
    }
    
    
    public boolean executeQueryNS(String query) throws SQLException{
        if(statement != null){
            try {
             //   statement.executeQuery(query);
              return  statement.execute(query);
              //  return true;
            } catch (SQLException ex) {
               throw ex;
            }   
        }
        return false;

    }
    
    public int executeQueryU(String query) throws SQLException{
        if(statement != null){
            try {
             //   statement.executeQuery(query);
              return  statement.executeUpdate(query);
              //  return true;
            } catch (SQLException ex) {
               throw ex;
            }   
        }
        return -1;

    }
    
    public ResultSet executeQuery(String query) throws SQLException{
        if(statement != null){
            try {
                return statement.executeQuery(query);
            } catch (SQLException ex) {
               throw ex;
            }   
        }
        return null;

    }
}


