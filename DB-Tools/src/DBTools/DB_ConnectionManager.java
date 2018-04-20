/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBTools;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author schmidtu
 */
public class DB_ConnectionManager {
    
    private boolean isConnnected; // = false;
    private Connection My_Connection;
    
//    public DB_ConnectionManager() {
//    }
    
    public DB_ConnectionManager(String aConnectionUrlAsString, String aSign_CONNECT_or_DISCONNECT) {
        
        set_connection(aConnectionUrlAsString,aSign_CONNECT_or_DISCONNECT);        
        
    }
    
    public Connection getConnection() {
        
        return My_Connection;
    }
    
    public boolean isConnnected() {
        
        return isConnnected;
        
    }

    public void setConnection_CLOSED(String aConnectionUrlAsString, String aSign_CONNECT_or_DISCONNECT) {
        
        set_connection(aConnectionUrlAsString, aSign_CONNECT_or_DISCONNECT);
        
    }
    private void set_connection(String aConnectionUrlAsString, String aSign_CONNECT_or_DISCONNECT) {

        try
        {
            if (/*myConnection == null && */aSign_CONNECT_or_DISCONNECT.equals("CONNECT")) {
                
//                Class.forName(aClassNameAsString); <- muss in den ClassPath
                String myURL = "jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true"; //aConnectionUrlAsString;
                My_Connection = DriverManager.getConnection(myURL);
            }
            if (My_Connection != null && !My_Connection.isClosed() && aSign_CONNECT_or_DISCONNECT.equals("DISCONNECT")) {
                
                My_Connection.close();
            }
        }
        catch (SQLException myException )
        {
        }
        finally {
            try {
                if (My_Connection == null) {
                    
                    isConnnected = false;
                }
                if (My_Connection != null && !My_Connection.isClosed()) {
                    
                    isConnnected = true;
                }
            } catch (SQLException myException) {
            }
        } 
    }
    
}
