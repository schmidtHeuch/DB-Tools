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
 * Diese Klasse stellt eine Verbindung mit der Datenbank her.
 * Die benötigten Werte werden direkt dem Konstruktor als Parameter übergeben. 
 * 
 * @author schmidtu
 * erstellt: 15.02.2019
 * @version 1.0
 * letzte Änderung: 
 * version 1.0 21.10.2019 javadoc erstellt
 * @since 1.8.0
 */
public class DB_ConnectionManager {
        
    /**
     * Konstruktor
     *
     * @param aServername
     * @param aDatabaseName
     * @param aBoolForIntSec
     * @param aSign_CONNECT_or_DISCONNECT
     */
    public DB_ConnectionManager(String aServername, String aDatabaseName, String aBoolForIntSec, String aSign_CONNECT_or_DISCONNECT) {
        
        set_connection(aServername, aDatabaseName, aBoolForIntSec, aSign_CONNECT_or_DISCONNECT);        
        
    }
    
    /** Gibt zurück ob diese Instanz connected ist.*/
    private boolean isConnnected; // = false;
    /** Instanz von <code>My_Connection</code>*/
    private Connection My_Connection;
    
    /**
     * gibt eine Instanz von <code> Connection </code> zurück
     *
     * @return My_Connection
     */
    public Connection getConnection() {
        
        return My_Connection;
    }
    
    /**
     * 
     * Gibt zurück ob diese Instanz connected ist.
     *
     * @return isConnnected
     */
    public boolean isConnnected() {
        
        return isConnnected;
        
    }

    /**
     * erzeugt oder schließt die Connection
     * 
     * @param aServername
     * @param aDatabaseName
     * @param aBoolForIntSec integratedSecurity
     * @param aSign_CONNECT_or_DISCONNECT
     */
    public void setConnection_CLOSED(String aServername,  String aDatabaseName, String aBoolForIntSec, String aSign_CONNECT_or_DISCONNECT) {
        
        set_connection(aServername, aDatabaseName, aBoolForIntSec, aSign_CONNECT_or_DISCONNECT);
        
    }
    
    /**
     * erzeugt oder schließt die Connection
     * 
     * @param aServername
     * @param aDatabaseName
     * @param aBoolForIntSec integratedSecurity
     * @param aSign_CONNECT_or_DISCONNECT
     */
    private void set_connection(String aServername,  String aDatabaseName, String aBoolForIntSec, String aSign_CONNECT_or_DISCONNECT) {

        try
        {
            if (/*myConnection == null && */aSign_CONNECT_or_DISCONNECT.equals("CONNECT")) {
                
//                Class.forName(aClassNameAsString); <- muss in den ClassPath
                String myURL = "jdbc:sqlserver://" + aServername + ";databaseName=" + aDatabaseName + ";integratedSecurity=" + aBoolForIntSec;
                My_Connection = DriverManager.getConnection(myURL);
            }
            if (My_Connection != null && !My_Connection.isClosed() && aSign_CONNECT_or_DISCONNECT.equals("DISCONNECT")) {
                
                My_Connection.close();
            }
        }
        catch (SQLException myException )
        {
            System.out.println(myException);
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
                System.out.println(myException);
            }
        } 
    }    
}
