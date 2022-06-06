/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.mart;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Obaid
 */
public class frmproduct extends javax.swing.JFrame {

    Socket clientSocket;
    private String Data;
    int counter = 0;

    /**
     * Creates new form frmproduct
     */
    public frmproduct() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setResizable(false);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(new Color(54, 33, 89));
        MyHeaderRender.setForeground(new Color(255, 255, 255));
        MyHeaderRender.setHorizontalAlignment(SwingConstants.CENTER);
        tblproduct.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
        tblproduct.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
        tblproduct.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(MyHeaderRender);
        tblproduct.getTableHeader().getColumnModel().getColumn(3).setHeaderRenderer(MyHeaderRender);
        tblproduct.getTableHeader().getColumnModel().getColumn(4).setHeaderRenderer(MyHeaderRender);
        tblproduct.getTableHeader().getColumnModel().getColumn(5).setHeaderRenderer(MyHeaderRender);
        tblproduct.getTableHeader().getColumnModel().getColumn(6).setHeaderRenderer(MyHeaderRender);
        tblproduct.getTableHeader().getColumnModel().getColumn(7).setHeaderRenderer(MyHeaderRender);
        tblproduct.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblproduct.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblproduct.getColumnModel().getColumn(2).setPreferredWidth(70);
        tblproduct.getColumnModel().getColumn(3).setPreferredWidth(56);
        tblproduct.getColumnModel().getColumn(4).setPreferredWidth(56);
        tblproduct.getColumnModel().getColumn(5).setPreferredWidth(70);
        tblproduct.getColumnModel().getColumn(6).setPreferredWidth(56);
        tblproduct.getColumnModel().getColumn(7).setPreferredWidth(56);
    }

    String Connection(String data) throws IOException {
        String modifiedSentence;

        clientSocket = new Socket("localhost", 9999);

        DataOutputStream outToServer
                = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(data + '\n');

        modifiedSentence = inFromServer.readLine();

        System.out.println("FROM SERVER: " + modifiedSentence);

        return modifiedSentence;
    }

    void showData() {
        try {
            Connection("tbl_inventory");
            byte[] b = new byte[2002];
            Socket sr = new Socket("localhost", 9999);
            InputStream is = sr.getInputStream();
            FileOutputStream fr = new FileOutputStream("tbl_inventory.txt");
            is.read(b, 0, b.length);
            fr.write(b, 0, b.length);
            is.close();
            fr.close();
            sr.close();
            BufferedReader br = new BufferedReader(new FileReader("tbl_inventory.txt"));
            DefaultTableModel model = (DefaultTableModel) tblproduct.getModel();
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length - 1; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);

            }
        } catch (IOException ex) {
            Logger.getLogger(frmproduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproduct = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Products");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        jLabel2.setText("Search");

        txtsearch.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tblproduct.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblproduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Name", "Sale Price", "Sale Disc", "Sale Tax", "Pur Price", "Pur Disc", "Pur Tax"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblproduct);
        if (tblproduct.getColumnModel().getColumnCount() > 0) {
            tblproduct.getColumnModel().getColumn(0).setResizable(false);
            tblproduct.getColumnModel().getColumn(1).setResizable(false);
            tblproduct.getColumnModel().getColumn(2).setResizable(false);
            tblproduct.getColumnModel().getColumn(3).setResizable(false);
            tblproduct.getColumnModel().getColumn(4).setResizable(false);
            tblproduct.getColumnModel().getColumn(5).setResizable(false);
            tblproduct.getColumnModel().getColumn(6).setResizable(false);
            tblproduct.getColumnModel().getColumn(7).setResizable(false);
        }

        jButton1.setText("Import");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
//    try {
//        // TODO add your handling code here:
//        Connection("tbl_inventory");
//    } catch (IOException ex) {
//        Logger.getLogger(frmproduct.class.getName()).log(Level.SEVERE, null, ex);
//    }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(frmproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmproduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblproduct;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
