/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBTools;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * Diese Klasse erzeugt eine Instanz mit DB-Connection und führt SQL-Commands aus.
 * 
 * Dem Konstruktor werden der Server und die Datenbank übergeben.
 * 
 * Über die Methode set_closinConnection(aBoolean) muss übergeben werden, ob die Connection geschlossen werden soll.
 * Die Attribute Stetement und ClosinConnection müssen über die Setter-Methoden gesetzt werden.
 * Der Aufruf der Methode do_executeCommand() führt das SQL-Command aus.
 * Zum Schluss muss über die Methode set_closinConnection(aBoolean) das Schließen der Connection übergeben werden.
 * 
 * @author schmidtu
 * erstellt:  01.10.2019
 * @version 1.0
 * letzte Änderung: 
 *                  21.10.2019  Umbau: setter und getter Methoden erstellt -> Performance-Steigerung!
 *                              Der Konstruktor erzeugt nur eine Instanz, die die Arbeit übernimmt. 
 * @since 1.8.0
 */
public class DO_SQLCommand_ExecuteUpdate {
    
    /**
     *
     * @param aServer
     * @param aDataBase
     */
    public DO_SQLCommand_ExecuteUpdate(String aServer, String aDataBase) {
                
        get_DBConnection(aServer, aDataBase);
    }
    
    /** Instanz von <code>DB_ConnectionManager</code>*/
    static public DB_ConnectionManager MY_DBCM;
    /** wird über <code>set_theSQLCommand</code> gesetzt.*/
    private String SQLCommand;
    /** Gibt zurück ob das SQLCommand ausgeführt wurde.*/
    private boolean StatemendExecuted;
    /** wird über <code>set_closinConnection</code> gesetzt und steuert das Schließen der Connection.*/
    private boolean ClosinConnection;
        
    /** Wird im Constructor aufgerufen und pro Instanz nur einmal erzeugt.*/
    private void get_DBConnection(String aServer, String aDataBase) { 
        MY_DBCM = new DB_ConnectionManager(aServer, aDataBase, "true", "CONNECT");
        if (!MY_DBCM.isConnnected()) {
            JOptionPane.showMessageDialog(null,
                    "Der Verbindungs-Aufbau zur Datenbank ist gescheitert. Bitte wenden Sie sich an den Entwickler.",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }     
    }
    
    /** 
     * Das SQLCommand muss komplett sein und vor dem <code> do_executeCommand() </code> gesetzt werrden!
     * 
     * @param aStatement 
     */
    public void set_theSQLCommand(String aStatement) {
        SQLCommand = aStatement;
    }
    
    /**
     * Wird diese Instanz nicht mehr benötigt muss die Connection geschlossen werden!
     * 
     * @param aBoolean
     */
    public void set_closinConnection(boolean aBoolean) {
        ClosinConnection = aBoolean;
    }
    
    /**
     * Führt das SQLCommand aus.
     */
    public void do_executeCommand() {
        
        try {
            if (MY_DBCM.isConnnected()) 
            {    
                StatemendExecuted = false;
                Statement myStatement = MY_DBCM.getConnection().createStatement();
                myStatement.executeUpdate(SQLCommand); 
            }
        }
        catch (SQLException myException )
        {
            StatemendExecuted = false;
        }
        finally {
            try { 
                if (ClosinConnection == true) {
                    MY_DBCM.getConnection().close();
                }
            } catch (SQLException myException) {
                System.out.println(myException);
                StatemendExecuted = false;
            }
            StatemendExecuted = true;
        }          
    }
    
    /**
     * Gibt zurück ob das SQLCommand ausgeführt wurde.
     * 
     * @return boolean
     */
    
    public boolean get_isCommandExecuted() {
        return StatemendExecuted;
    }
    
    /**     * 
     * Gibt die Instanz von <code> MY_DBCM </code> zurück ob das SQLCommand ausgeführt wurde.
     * 
     * @return MY_DBCM
     */
    public DB_ConnectionManager getInstance() {
        return MY_DBCM;
    }
}