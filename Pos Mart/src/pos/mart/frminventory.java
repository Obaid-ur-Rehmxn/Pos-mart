/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.mart;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Obaid
 */
public class frminventory extends javax.swing.JFrame {
    int company;
//    frmLogin fr=new frmLogin();/
    /**
     * Creates new form frmcompany
     */
    
    public frminventory() throws IOException{
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setResizable(false);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(new Color(54, 33, 89));
        MyHeaderRender.setForeground(new Color(255, 255, 255));
        tblinventory.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
        tblinventory.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
        txtbarcode.requestFocus();
        btnAdd.setBackground(Color.white);
        btnupdate.setBackground(Color.white);
        btndelete.setBackground(Color.white);
        btnreset.setBackground(Color.white);
        
    }

    String fkConnection(String data){
        String s = null;
        try {
            Socket clientSocket = new Socket("localhost", 9999);
            DataOutputStream outToServer
                    = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(data + '\n');
            s=inFromServer.readLine();
            if(s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")){
                System.out.println(s);
            }
            else{
                company=parseInt(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(frminventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblinventory = new javax.swing.JTable();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtdescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtpurchaseprice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbcompany = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtbarcode = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        txtsaletax = new javax.swing.JTextField();
        txtsaledisc = new javax.swing.JTextField();
        txtsaleprice3 = new javax.swing.JTextField();
        txtpurchasetax = new javax.swing.JTextField();
        txtpurchasedisc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtminstock = new javax.swing.JTextField();
        chkinactive = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INVENTORY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 679, -1));

        tblinventory.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblinventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr no", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblinventory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 112, 340, 324));

        btnupdate.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.setContentAreaFilled(false);
        btnupdate.setOpaque(true);
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnupdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnupdateMouseExited(evt);
            }
        });
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 169, 53));

        btndelete.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btndelete.setText("DELETE");
        btndelete.setContentAreaFilled(false);
        btndelete.setOpaque(true);
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndeleteMouseExited(evt);
            }
        });
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 169, 53));

        btnreset.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnreset.setText("RESET");
        btnreset.setContentAreaFilled(false);
        btnreset.setOpaque(true);
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnresetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnresetMouseExited(evt);
            }
        });
        getContentPane().add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 169, 53));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.setContentAreaFilled(false);
        btnAdd.setOpaque(true);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 169, 53));

        txtsearch.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        getContentPane().add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 190, 25));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 50, 25));

        txtno.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });
        getContentPane().add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 120, 25));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sr no");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 50, 25));

        txtdescription.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescriptionActionPerformed(evt);
            }
        });
        getContentPane().add(txtdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 210, 25));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Description");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 60, 25));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Code");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 50, 20));

        txtpurchaseprice.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtpurchaseprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpurchasepriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtpurchaseprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 100, 25));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Purchase");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 70, 25));

        cmbcompany.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cmbcompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nabeel", "other", "jamal" }));
        cmbcompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcompanyActionPerformed(evt);
            }
        });
        getContentPane().add(cmbcompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 210, 25));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Barcode");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 70, 20));

        txtbarcode.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtbarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbarcodeActionPerformed(evt);
            }
        });
        getContentPane().add(txtbarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 120, 25));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Company");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 60, 25));

        txtname.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 210, 25));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("STax %");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 50, 25));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sales");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 50, 25));

        txtcode.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeActionPerformed(evt);
            }
        });
        getContentPane().add(txtcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 25));

        txtsaletax.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtsaletax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsaletaxActionPerformed(evt);
            }
        });
        getContentPane().add(txtsaletax, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 100, 25));

        txtsaledisc.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtsaledisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsalediscActionPerformed(evt);
            }
        });
        getContentPane().add(txtsaledisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 100, 25));

        txtsaleprice3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtsaleprice3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsaleprice3ActionPerformed(evt);
            }
        });
        getContentPane().add(txtsaleprice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 100, 25));

        txtpurchasetax.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtpurchasetax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpurchasetaxActionPerformed(evt);
            }
        });
        getContentPane().add(txtpurchasetax, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 100, 25));

        txtpurchasedisc.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtpurchasedisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpurchasediscActionPerformed(evt);
            }
        });
        getContentPane().add(txtpurchasedisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 100, 25));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Name");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 50, 25));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Price");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 50, 25));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Disc %");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 50, 25));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Quantity");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 50, 20));

        txtqty.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });
        getContentPane().add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 120, 25));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Min Stock level");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 100, 20));

        txtminstock.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtminstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtminstockActionPerformed(evt);
            }
        });
        getContentPane().add(txtminstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 120, 25));

        chkinactive.setText("Inactive");
        getContentPane().add(chkinactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        btnAdd.setBackground(new Color(54, 33, 89));
        btnAdd.setForeground(Color.white);
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        btnAdd.setBackground(new Color(255,255,255));
        btnAdd.setForeground(Color.black);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        var inactive=chkinactive.isSelected();
        int inactive1;
        if (inactive==true) {
            inactive1=1;
        }
        else{
            inactive1=0;
        }
        int srno=parseInt(txtno.getText());
        String sql="update/update tbl_inventory set inventory_code = '"+txtcode.getText()+"',inventory_name = '"+txtname.getText()+
                "',invemtory_description = '"+txtdescription.getText()+
                "',inventory_barcode = "+parseInt(txtbarcode.getText())+",inventory_Fkcompany = "+company+",inventory_saleprice = "+parseInt(txtsaleprice3.getText())+",inventory_saledisc = "+parseInt(txtsaledisc.getText())+" "
                + ", inventory_saletax = "+parseInt(txtsaletax.getText())+" , inventory_purchaseprice = "+parseInt(txtpurchaseprice.getText())+
                " , inventory_purchasedisc = "+parseInt(txtpurchasedisc.getText())+" ,inventory_purchasetax = "+parseInt(txtpurchasetax.getText())+" , inventory_inactive = "+inactive1+" , inventory_quantity = "+parseInt(txtqty.getText())+" , inventory_minstock = "+parseInt(txtminstock.getText())+" where inventory_id = "+srno;
        System.out.println(sql);
        fkConnection(sql);
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        System.out.println(company);
        var inactive=chkinactive.isSelected();
        int inactive1;
        if (inactive==true) {
            inactive1=1;
        }
        else{
            inactive1=0;
        }
        String query = "insert/insert into tbl_inventory(inventory_Fkcompany,inventory_code,inventory_name,inventory_barcode,invemtory_description,"
                + "inventory_saleprice,inventory_saledisc,inventory_saletax,inventory_purchaseprice,inventory_purchasedisc,inventory_purchasetax,"
                + "inventory_quantity,inventory_minstock,inventory_inactive) Values"
                + " (" + company + ",'" + txtcode.getText() + "','"+txtname.getText()+"',"+parseInt(txtbarcode.getText())
                +",'"+txtdescription.getText()+"',"+parseInt(txtsaleprice3.getText())+","+parseInt(txtsaledisc.getText())+","
                +parseInt(txtsaletax.getText())+","+parseInt(txtpurchaseprice.getText())+","+parseInt(txtpurchasedisc.getText())+","+parseInt(txtpurchasetax.getText())+","+parseInt(txtqty.getText())+","+parseInt(txtminstock.getText())+","+inactive1+")";
        System.out.println(query);
        fkConnection(query);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnupdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseEntered
        btnupdate.setBackground(new Color(54, 33, 89));
        btnupdate.setForeground(Color.white);
    }//GEN-LAST:event_btnupdateMouseEntered

    private void btnupdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseExited
        btnupdate.setBackground(new Color(255,255,255));
        btnupdate.setForeground(Color.black);
    }//GEN-LAST:event_btnupdateMouseExited

    private void btndeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseEntered
        btndelete.setBackground(new Color(54, 33, 89));
        btndelete.setForeground(Color.white);
    }//GEN-LAST:event_btndeleteMouseEntered

    private void btndeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseExited
        btndelete.setBackground(Color.white);
        btndelete.setForeground(Color.black);
    }//GEN-LAST:event_btndeleteMouseExited

    private void btnresetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseEntered
         btnreset.setBackground(new Color(54, 33, 89));
        btnreset.setForeground(Color.white);
    }//GEN-LAST:event_btnresetMouseEntered

    private void btnresetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseExited
         btnreset.setBackground(Color.white);
        btnreset.setForeground(Color.black);
    }//GEN-LAST:event_btnresetMouseExited

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoActionPerformed

    private void txtdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescriptionActionPerformed

    private void txtpurchasepriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpurchasepriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpurchasepriceActionPerformed

    private void txtbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbarcodeActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeActionPerformed

    private void txtsaletaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsaletaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsaletaxActionPerformed

    private void txtsalediscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsalediscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsalediscActionPerformed

    private void txtsaleprice3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsaleprice3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsaleprice3ActionPerformed

    private void txtpurchasetaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpurchasetaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpurchasetaxActionPerformed

    private void txtpurchasediscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpurchasediscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpurchasediscActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyActionPerformed

    private void txtminstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtminstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtminstockActionPerformed

    private void cmbcompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcompanyActionPerformed

        String cmp_name=cmbcompany.getSelectedItem().toString();
        System.out.println(cmp_name);
        String sql="fkcompany/Select company_id from tbl_company where company_name='"+cmp_name+"'";
        System.out.println(sql);
        fkConnection(sql);
    }//GEN-LAST:event_cmbcompanyActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int srno = parseInt(txtno.getText());
        String query = "delete/delete from tbl_inventory where inventory_id=" + srno;
        System.out.println(query);
        fkConnection(query);
    }//GEN-LAST:event_btndeleteActionPerformed

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
            java.util.logging.Logger.getLogger(frminventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frminventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frminventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frminventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frminventory().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(frminventory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnupdate;
    private javax.swing.JCheckBox chkinactive;
    private javax.swing.JComboBox<String> cmbcompany;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblinventory;
    private javax.swing.JTextField txtbarcode;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtminstock;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtpurchasedisc;
    private javax.swing.JTextField txtpurchaseprice;
    private javax.swing.JTextField txtpurchasetax;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtsaledisc;
    private javax.swing.JTextField txtsaleprice3;
    private javax.swing.JTextField txtsaletax;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
