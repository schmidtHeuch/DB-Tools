/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * Diese Klasse holt das ResultSet über OPENQUERY als Ergebnis für die übergebenen Parameter, die direkt an den Kostruktor übergeben werden.
 * 
 * Dem Konstruktor werden sämtliche Parameter übergeben.
 *  * 
 * @author schmidtu
 * erstellt:  01.10.2019
 * @version 1.0
 * letzte Änderung: 
 *                  21.10.2019 Erstellung / Ergänzung der javadoc
 * @since 1.8.0
 */
public class GET_ResultSet_From_OpenQuery {
    
    /**
     *
     * @param aServer
     * @param aDataBase
     * @param anArrayOfColumnNames
     * @param LinkedServer
     * @param OPENQUERY
     */
    public GET_ResultSet_From_OpenQuery(String aServer, String aDataBase, String [] anArrayOfColumnNames, String LinkedServer, String OPENQUERY) {
        
        get_DBTableData_from_OpenQuery( aServer,  aDataBase, anArrayOfColumnNames, LinkedServer, OPENQUERY);
    }
   
    /** Instanz von <code>DB_ConnectionManager</code>*/
    DB_ConnectionManager MY_DBCM;
    /** Anzahl der DB-Spalten aus dem ResultSet. */
    int TableColumns;
    /** Das Ergebnis aus dem ResultSet als String [][]. */
    String [][] TheReturnAsArray;
    
    /**
     * Holt die DB-Verbindung.
     *
     * @param aServer
     * @param aDataBase
     */
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
     * Holt die Daten aus der DB.
     *
     * @param aServer
     * @param aDataBase
     * @param anArrayOfColumnNames
     * @param LinkedServer
     * @param OPENQUERY
     */  
    private void get_DBTableData_from_OpenQuery(String aServer, String aDataBase, String [] anArrayOfColumnNames, String LinkedServer, String OPENQUERY) {
        try
        { 
            StringBuilder completeSQL = new StringBuilder();
            StringBuilder myColumns = new StringBuilder();
            
            if (anArrayOfColumnNames.length > 0) {
                for (int i=0; i < anArrayOfColumnNames.length; ++i) {
                    myColumns.append(anArrayOfColumnNames[i]);
                    if (i < anArrayOfColumnNames.length - 1) {
                        myColumns.append(", ");
                    }
                }
            }
            else {
                myColumns.append(" * ");
            }
            
            completeSQL.append("SELECT ");
            completeSQL.append(myColumns);
            completeSQL.append(" FROM OPENQUERY(");
            completeSQL.append(LinkedServer);
            completeSQL.append(", ' ");
            completeSQL.append(OPENQUERY);
            completeSQL.append("')");
            
            get_DBConnection(aServer, aDataBase);
            
            Statement myStatement = MY_DBCM.getConnection().createStatement();   
            
            ResultSet myResultSet = myStatement.executeQuery(completeSQL.toString());           
            TableColumns = myResultSet.getMetaData().getColumnCount(); 
            
            ArrayList<ArrayList<String>> myRows = new ArrayList<>();//            int row = 0;
            ArrayList<String> values = new ArrayList<>();

            while (myResultSet.next()) {
//                
                for (int col = 1; col <= TableColumns; col++) {
                    if (myResultSet.getString(col) != null) {
                        values.add(myResultSet.getString(col).trim()); 
                    }
                    else {
                        values.add("");                        
                    }
                }
                myRows.add(values);
                    values = new ArrayList<>();
            }
            
            if (!myResultSet.next()) {
                TheReturnAsArray = new String[myRows.size()][TableColumns];
                for (int x = 0; x < myRows.size(); x++) {
                    for (int y = 0; y < TableColumns; y++)
                        TheReturnAsArray[x][y] = myRows.get(x).get(y);    
                }
            } 
        }
        catch (SQLException myException )
        {
            System.out.println(myException);
        }
        finally {
            try { 
                if (MY_DBCM.getConnection() != null && MY_DBCM.isConnnected()) {
                    MY_DBCM.getConnection().close();
                }
            } 
            catch (SQLException myException) {
                System.out.println(myException);
            }
        } 
    }
    
    
    /**
     *
     * @return TheReturnAsArray
     */
    public String[][] getResultAsArray() {
        
        return TheReturnAsArray;
        
    }
    
}
