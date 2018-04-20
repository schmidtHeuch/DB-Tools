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
    
    private boolean isConnnected = false;
    Connection myConnection;
    
//    public DB_ConnectionManager() {
//    }
    
    public DB_ConnectionManager(String aClassNameAsString, String aConnectionUrlAsString, String aSign_CONNECT_or_DISCONNECT) {
        
        set_connection(aClassNameAsString, aConnectionUrlAsString,aSign_CONNECT_or_DISCONNECT);        
        
    }
    
    public boolean isConnnected() {
        
        return isConnnected;
        
    }

    private void set_connection(String aClassNameAsString, String aConnectionUrlAsString, String aSign_CONNECT_or_DISCONNECT) {

        try
        {
            if (myConnection == null && aSign_CONNECT_or_DISCONNECT.equals("CONNECT")) {
                
                Class myClasse = Class.forName(aClassNameAsString);
                String myURL = aConnectionUrlAsString;
                myConnection = DriverManager.getConnection(myURL);
            }
            if (myConnection != null && !myConnection.isClosed() && aSign_CONNECT_or_DISCONNECT.equals("DISCONNECT")) {
                
                myConnection.close();
            }
        }
        catch (ClassNotFoundException | SQLException myException )
        {
        }
        finally {
            try {
                if (myConnection == null) {
                    
                    isConnnected = false;
                }
                if (myConnection != null && !myConnection.isClosed()) {
                    
                    isConnnected = true;
                }
            } catch (SQLException myException) {
            }
        } 
    }
    
}
