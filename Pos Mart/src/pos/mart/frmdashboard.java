/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.mart;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Obaid
 */
public class frmdashboard extends javax.swing.JFrame {
    /**
     * Creates new form frmdashboard
     */
    public frmdashboard() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.white);
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
        btninventory = new javax.swing.JButton();
        btncompany = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("POS MART");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 265, 54));

        btninventory.setBackground(new java.awt.Color(54, 33, 89));
        btninventory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btninventory.setForeground(new java.awt.Color(255, 255, 255));
        btninventory.setText("Inventory");
        btninventory.setBorder(null);
        btninventory.setContentAreaFilled(false);
        btninventory.setOpaque(true);
        btninventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btninventoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btninventoryMouseExited(evt);
            }
        });
        btninventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninventoryActionPerformed(evt);
            }
        });
        jPanel1.add(btninventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 255, 30));

        btncompany.setBackground(new java.awt.Color(54, 33, 89));
        btncompany.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btncompany.setForeground(new java.awt.Color(255, 255, 255));
        btncompany.setText("Company");
        btncompany.setBorder(null);
        btncompany.setContentAreaFilled(false);
        btncompany.setOpaque(true);
        btncompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncompanyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncompanyMouseExited(evt);
            }
        });
        btncompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncompanyActionPerformed(evt);
            }
        });
        jPanel1.add(btncompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 255, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(417, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
       
    
    private void btninventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninventoryMouseEntered
        btninventory.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btninventoryMouseEntered

    private void btninventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninventoryMouseExited
        btninventory.setBackground(new Color(54, 33, 89));
    }//GEN-LAST:event_btninventoryMouseExited

    private void btncompanyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncompanyMouseEntered
        btncompany.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btncompanyMouseEntered

    private void btncompanyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncompanyMouseExited
        btncompany.setBackground(new Color(54, 33, 89));
    }//GEN-LAST:event_btncompanyMouseExited

    private void btncompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncompanyActionPerformed
    }//GEN-LAST:event_btncompanyActionPerformed

    private void btninventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninventoryActionPerformed

    }//GEN-LAST:event_btninventoryActionPerformed
    
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
            java.util.logging.Logger.getLogger(frmdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmdashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncompany;
    private javax.swing.JButton btninventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
