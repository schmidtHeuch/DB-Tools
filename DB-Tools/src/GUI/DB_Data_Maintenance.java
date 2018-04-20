/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DBTools.DB_ConnectionManager;

/**
 *
 * @author schmidtu
 */
public class DB_Data_Maintenance extends javax.swing.JFrame {

    boolean myAnswerIfConnected;
    
    /**
     * Creates new form DB_Data_Maintenance
     */
    public DB_Data_Maintenance() {
        initComponents();
        getDBConnection("CONNECT");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_table = new javax.swing.JPanel();
        jTextField_searchValue1 = new javax.swing.JTextField();
        jTextField_searchValue2 = new javax.swing.JTextField();
        btn_deleteSearchValue1 = new javax.swing.JButton();
        btn_deleteSearchValue2 = new javax.swing.JButton();
        jScrollPane_dbData = new javax.swing.JScrollPane();
        jTable_dbData = new javax.swing.JTable();
        lbl_search1 = new javax.swing.JLabel();
        lbl_search2 = new javax.swing.JLabel();
        jPanel_buttonsForEdit = new javax.swing.JPanel();
        btn_new = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_accept = new javax.swing.JButton();
        jTextField_key = new javax.swing.JTextField();
        jTextField_value2 = new javax.swing.JTextField();
        lbl_key = new javax.swing.JLabel();
        lbl_Spalte2 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_duplicate = new javax.swing.JButton();
        jPanel_footer = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_deleteSearchValue1.setText("X");
        btn_deleteSearchValue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteSearchValue1ActionPerformed(evt);
            }
        });

        btn_deleteSearchValue2.setText("X");

        jTable_dbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Spalte Key", "Spalte x"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane_dbData.setViewportView(jTable_dbData);

        lbl_search1.setText("Suchen");

        lbl_search2.setText("Suchen");

        javax.swing.GroupLayout jPanel_tableLayout = new javax.swing.GroupLayout(jPanel_table);
        jPanel_table.setLayout(jPanel_tableLayout);
        jPanel_tableLayout.setHorizontalGroup(
            jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_dbData, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(jPanel_tableLayout.createSequentialGroup()
                        .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_tableLayout.createSequentialGroup()
                                .addComponent(jTextField_searchValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(btn_deleteSearchValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_search1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_tableLayout.createSequentialGroup()
                                .addComponent(jTextField_searchValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_deleteSearchValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_search2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_tableLayout.setVerticalGroup(
            jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_search1)
                    .addComponent(lbl_search2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_searchValue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_searchValue2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deleteSearchValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deleteSearchValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_dbData, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btn_new.setText("Neu");

        btn_edit.setText("Bearbeiten");

        btn_delete.setText("Löschen");

        btn_accept.setText("Übernehmen");

        lbl_key.setText("Key");

        lbl_Spalte2.setText("Spalte2");

        btn_cancel.setText("Abbrechen");

        btn_duplicate.setText("Duplizieren");

        javax.swing.GroupLayout jPanel_buttonsForEditLayout = new javax.swing.GroupLayout(jPanel_buttonsForEdit);
        jPanel_buttonsForEdit.setLayout(jPanel_buttonsForEditLayout);
        jPanel_buttonsForEditLayout.setHorizontalGroup(
            jPanel_buttonsForEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_buttonsForEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_buttonsForEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_buttonsForEditLayout.createSequentialGroup()
                        .addComponent(btn_new)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_duplicate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete))
                    .addGroup(jPanel_buttonsForEditLayout.createSequentialGroup()
                        .addGroup(jPanel_buttonsForEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_key, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_key))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_buttonsForEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Spalte2)
                            .addComponent(jTextField_value2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_buttonsForEditLayout.createSequentialGroup()
                        .addComponent(btn_accept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_buttonsForEditLayout.setVerticalGroup(
            jPanel_buttonsForEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_buttonsForEditLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_buttonsForEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_key)
                    .addComponent(lbl_Spalte2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_buttonsForEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_value2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_buttonsForEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(btn_edit)
                    .addComponent(btn_delete)
                    .addComponent(btn_duplicate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_buttonsForEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_accept)
                    .addComponent(btn_cancel))
                .addContainerGap())
        );

        btn_close.setText("Schließen");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_footerLayout = new javax.swing.GroupLayout(jPanel_footer);
        jPanel_footer.setLayout(jPanel_footerLayout);
        jPanel_footerLayout.setHorizontalGroup(
            jPanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_close)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_footerLayout.setVerticalGroup(
            jPanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_close)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_buttonsForEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_buttonsForEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deleteSearchValue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteSearchValue1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteSearchValue1ActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
        getDBConnection("DISCONNECT");
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void getDBConnection(String aSign_CONNECT_or_DISCONNECT) {
        DB_ConnectionManager myConnection = new DB_ConnectionManager("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://HV-ABAS-SQL;databaseName=DiafBDE;integratedSecurity=true", aSign_CONNECT_or_DISCONNECT);
        myAnswerIfConnected = myConnection.isConnnected();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DB_Data_Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DB_Data_Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DB_Data_Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DB_Data_Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DB_Data_Maintenance().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_deleteSearchValue1;
    private javax.swing.JButton btn_deleteSearchValue2;
    private javax.swing.JButton btn_duplicate;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private javax.swing.JPanel jPanel_buttonsForEdit;
    private javax.swing.JPanel jPanel_footer;
    private javax.swing.JPanel jPanel_table;
    private javax.swing.JScrollPane jScrollPane_dbData;
    private javax.swing.JTable jTable_dbData;
    private javax.swing.JTextField jTextField_key;
    private javax.swing.JTextField jTextField_searchValue1;
    private javax.swing.JTextField jTextField_searchValue2;
    private javax.swing.JTextField jTextField_value2;
    private javax.swing.JLabel lbl_Spalte2;
    private javax.swing.JLabel lbl_key;
    private javax.swing.JLabel lbl_search1;
    private javax.swing.JLabel lbl_search2;
    // End of variables declaration//GEN-END:variables
}
