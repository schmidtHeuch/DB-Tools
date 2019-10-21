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
 * Diese Klasse holt das ResultSet direkt als Ergebnis für die übergebenen Parameter, die direkt an den Kostruktor übergeben werden.
 * 
 * Dem Konstruktor werden sämtliche Parameter übergeben.
 * 
 * @author schmidtu
 * erstellt:  16.01.2019
 * @version 1.0
 * letzte Änderung: 12.02.2019
 *                  25.09.2019 Klauseln um "GROUP BY", "HAVING" und "OERDER BY erweitert
 *                  27.09.2019 OPENQUERY zugefügt
 *                  21.10.2019 Erstellung / Ergänzung der javadoc
 * @since 1.8.0
 */
public class GET_ResultSet_From_DBTableData {
    
    /**
     *
     * @param aServer
     * @param aDataBase
     * @param aSchema
     * @param aDBTableName
     * @param anArrayOfColumnNames
     * @param aStringOfWhereClause
     * @param anArrayOfGroupByClause
     * @param aStringOfHavingClause
     * @param anArrayOfOrderByClause
     */
    public GET_ResultSet_From_DBTableData(String aServer, String aDataBase, String aSchema, String aDBTableName, 
            String [] anArrayOfColumnNames, String aStringOfWhereClause, String [] anArrayOfGroupByClause,
            String aStringOfHavingClause, String [] anArrayOfOrderByClause) {
                
        get_DBTableData_ViewORTable(aServer, aDataBase, aSchema, aDBTableName, anArrayOfColumnNames, aStringOfWhereClause,
            anArrayOfGroupByClause, aStringOfHavingClause, anArrayOfOrderByClause);
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
     * @param aSchema
     * @param aDBTableName
     * @param anArrayOfColumnNames
     * @param aStringOfWhereClause
     * @param anArrayOfGroupByClause
     * @param aStringOfHavingClause
     * @param anArrayOfOrderByClause
     */
    private void get_DBTableData_ViewORTable(String aServer, String aDataBase, String aSchema, String aDBTableName, 
            String [] anArrayOfColumnNames, String aStringOfWhereClause, String [] anArrayOfGroupByClause,
            String aStringOfHavingClause, String [] anArrayOfOrderByClause) {
                        
        /** Zusammenstellung des SQLCommands aus den übergebenen Werten.*/
        StringBuilder myColumns = new StringBuilder();
        StringBuilder myWhereClause = new StringBuilder();
        StringBuilder myGroupByClause = new StringBuilder();
        StringBuilder myHavingClause = new StringBuilder();
        StringBuilder myOrderByClause = new StringBuilder();
        
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
        
        if (!aStringOfWhereClause.equals("")) {
            myWhereClause.append(" WHERE ");
            myWhereClause.append(aStringOfWhereClause);
        }
        else {
            myWhereClause.append("");
        }
                
        if (!anArrayOfGroupByClause[0].equals("")) {
                myGroupByClause.append(" GROUP BY ");
            for (int row=0; row < anArrayOfGroupByClause.length; row++) {
                myGroupByClause.append(anArrayOfGroupByClause[row]);
                if (row < anArrayOfGroupByClause.length - 1) {
                    myGroupByClause.append(", ");
                }
            }
        }
        else {myGroupByClause.append("");}
        
        if (!aStringOfHavingClause.equals("")) {
            myHavingClause.append(" HAVING ");
            myHavingClause.append(aStringOfHavingClause);
        }
        else {
            myHavingClause.append("");
        }
        
        if (!anArrayOfOrderByClause[0].equals("")) {
                myOrderByClause.append(" ORDER BY ");
            for (int row=0; row < anArrayOfOrderByClause.length; row++) {
                myOrderByClause.append(anArrayOfOrderByClause[row]);
                myOrderByClause.append(" = '");
                myOrderByClause.append(anArrayOfOrderByClause[row]);
                myOrderByClause.append("'");
                if (row < anArrayOfOrderByClause.length - 1) {
                    myOrderByClause.append(" , ");
                }
            }
        }
        else {myOrderByClause.append("");}
        try
        {             
            get_DBConnection(aServer, aDataBase);
            Statement myStatement = MY_DBCM.getConnection().createStatement();
            String mySQL;
            mySQL = "SELECT " + myColumns + " FROM " + aDataBase +  "." + aSchema + "." + aDBTableName + myWhereClause + myGroupByClause
                + myHavingClause + myOrderByClause;
            ResultSet myResultSet = myStatement.executeQuery(mySQL);           
            TableColumns = myResultSet.getMetaData().getColumnCount(); 
            
            ArrayList<ArrayList<String>> myRows = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();

            while (myResultSet.next()) {
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
