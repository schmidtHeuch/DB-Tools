/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBTables;

import DBTools.DB_ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author schmidtu
 * erstellt:  16.01.2019
 * @version 1.0
 * letzte Änderung: 12.02.2019
 * @since 1.8.0
 */
public class GET_ResultSet_From_DBTableData {
    
//    public GET_ResultSet_From_DBTableData() {
//        
//    }
    
    public GET_ResultSet_From_DBTableData(String aServer, String aDataBase, String aDBTableName, String aKindOfDBObject) {
        if (aKindOfDBObject.equals("View") || aKindOfDBObject.equals("Table")) {
            get_DBTableData_ViewORTable(aServer, aDataBase, aDBTableName);
        }
        if (aKindOfDBObject.equals("StoredProcedure")) {
            get_DBTableData_storedProcedure(aServer, aDataBase, aDBTableName);
        }
    }
   
    Connection myConnection;
    DB_ConnectionManager MY_DBCM;
    int TableColumns;
    String [][] TheReturnAsArray;
    
    private void get_DBConnection(String aServer, String aDataBase) { 
        MY_DBCM = new DB_ConnectionManager(aServer, aDataBase, "true", "CONNECT");
        if (!MY_DBCM.isConnnected()) {
            JOptionPane.showMessageDialog(null,
                    "Der Verbindungs-Aufbau zur Datenbank ist gescheitert. Bitte wenden Sie sich an den Entwickler.",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    private void get_DBTableData_ViewORTable(String aServer, String aDataBase, String aDBTableName) {
        get_DBConnection(aServer, aDataBase);
        try
        { 
            MY_DBCM.setConnection_CLOSED(aServer, aDataBase, "true", "DISCONNECT");
            MY_DBCM = new DB_ConnectionManager(aServer, aDataBase, "true", "CONNECT");
            myConnection = MY_DBCM.getConnection();
            Statement myStatement = myConnection.createStatement();
            String mySQL = "SELECT * FROM " + aDataBase +  ".dbo." + aDBTableName;
            ResultSet myResultSet = myStatement.executeQuery(mySQL);           
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
                    values = new ArrayList();
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
                if (myConnection != null && !myConnection.isClosed()) {
                    myConnection.close();
                }
            } 
            catch (SQLException myException) {
                System.out.println(myException);
            }
        } 
    }
    
//    private void get_DBTableData_ViewORTable(String aServer, String aDataBase, String aDBTableName) {
//        get_DBConnection(aServer, aDataBase);
//        try
//        { 
//            MY_DBCM.setConnection_CLOSED(aServer, aDataBase, "true", "DISCONNECT");
//            MY_DBCM = new DB_ConnectionManager(aServer, aDataBase, "true", "CONNECT");
//            myConnection = MY_DBCM.getConnection();
//            Statement myStatement = myConnection.createStatement();
//            String mySQL = "SELECT * FROM " + aDataBase +  ".dbo." + aDBTableName;
//            ResultSet myResultSet = myStatement.executeQuery(mySQL);           
//            TableColumns = myResultSet.getMetaData().getColumnCount();
//            while (myResultSet.next()) {
//                  
//                TheReturnAsArray = new String[TableColumns];
//                
//                for (int i = 1; i <= TableColumns; i++) {
//                          
//                    String myDataSet = myResultSet.getString(i);
//                    if(myDataSet != null) {
//                        myDataSet = myDataSet.trim();
//                    }
//                    TheReturnAsArray[i-1] = myDataSet;
//                }  
//            }
//            if (!myResultSet.next()) {
//            } 
//        }
//        catch (SQLException myException )
//        {
//            System.out.println(myException);
//        }
//        finally {
//            try { 
//                if (myConnection != null && !myConnection.isClosed()) {
//                    myConnection.close();
//                }
//            } catch (SQLException myException) {
//                System.out.println(myException);
//            }
//        } 
//    }
    private void get_DBTableData_storedProcedure(String aServer, String aDataBase, String aDBTableName) {
        get_DBConnection(aServer, aDataBase);
        try
        { 
            MY_DBCM.setConnection_CLOSED(aServer, aDataBase, "true", "DISCONNECT");
            MY_DBCM = new DB_ConnectionManager(aServer, aDataBase, "true", "CONNECT");
            myConnection = MY_DBCM.getConnection();
            Statement myStatement = myConnection.createStatement();
            String mySQL = "SELECT * FROM " + aDataBase +  ".dbo." + aDBTableName;
            ResultSet myResultSet = myStatement.executeQuery(mySQL);           
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
                    values = new ArrayList();
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
                if (myConnection != null && !myConnection.isClosed()) {
                    myConnection.close();
                }
            } 
            catch (SQLException myException) {
                System.out.println(myException);
            }
        } 
    }
    
    public String[][] getResultAsArray() {
        
        return TheReturnAsArray;
        
    }
}
