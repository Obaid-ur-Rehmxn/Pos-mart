/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.mart;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Obaid
 */
public class frmpurchase extends javax.swing.JFrame {
    DefaultTableModel model;
    Socket clientSocket;
    String s;
    /**
     * Creates new form frmexpense
     */
    public frmpurchase() throws IOException {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setResizable(false);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(new Color(54, 33, 89));
        MyHeaderRender.setForeground(new Color(255, 255, 255));
        MyHeaderRender.setHorizontalAlignment( SwingConstants.CENTER );
        tblpurchase1.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
        tblpurchase1.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
        tblpurchase2.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
        tblpurchase2.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
        tblpurchase2.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(MyHeaderRender);
        tblpurchase2.getTableHeader().getColumnModel().getColumn(3).setHeaderRenderer(MyHeaderRender);
        tblpurchase2.getTableHeader().getColumnModel().getColumn(4).setHeaderRenderer(MyHeaderRender);
        tblpurchase2.getTableHeader().getColumnModel().getColumn(5).setHeaderRenderer(MyHeaderRender);
        tblpurchase2.getTableHeader().getColumnModel().getColumn(6).setHeaderRenderer(MyHeaderRender);
        tblpurchase2.getColumnModel().getColumn(0).setPreferredWidth(110);
        tblpurchase2.getColumnModel().getColumn(1).setPreferredWidth(190);
        tblpurchase2.getColumnModel().getColumn(0).setPreferredWidth(70);
        tblpurchase2.getColumnModel().getColumn(0).setPreferredWidth(56);
        tblpurchase2.getColumnModel().getColumn(0).setPreferredWidth(56);
        tblpurchase2.getColumnModel().getColumn(0).setPreferredWidth(56);
        tblpurchase2.getColumnModel().getColumn(0).setPreferredWidth(69);
         model = (DefaultTableModel) tblpurchase2.getModel();
        DateFormat datefor = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date();
        txtdate.setText(datefor.format(date));
        btnAdd.setBackground(Color.white);
        btnupdate.setBackground(Color.white);
        btndelete.setBackground(Color.white);
        btnreset.setBackground(Color.white);
        btnprint.setBackground(Color.white);
        clearFields();
    }
    
    public String Connection(String data) throws IOException {

        Socket clientSocket = new Socket("localhost", 9999);

    
        DataOutputStream outToServer
                = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(data + '\n');
        s=inFromServer.readLine();
        return s;    
    }
    
    void serialno() throws IOException{
        String sql="serialno/SELECT IDENT_CURRENT('tbl_purchase1')";
        Connection(sql);
        txtno.setText(String.valueOf(parseInt(s)+1));
    }
    
    void showData(){
    try{
        Connection("tbl_purchase");
            System.out.println("connection performed");
            byte []b=new byte[2002];
            Socket sr=new Socket("localhost",9999);
            InputStream is =sr.getInputStream();
            FileOutputStream fr=new FileOutputStream("tbl_purchase.txt");
            is.read(b, 0, b.length);
            fr.write(b, 0, b.length);
            is.close();
            fr.close();
            sr.close();
            BufferedReader br = new BufferedReader(new FileReader("tbl_purchase.txt"));
            DefaultTableModel model1 = (DefaultTableModel) tblpurchase1.getModel();
            Object[] tableLines = br.lines().toArray();
            for (int i = model1.getRowCount() - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            for (int i = 0; i < tableLines.length-1; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model1.addRow(dataRow);
            }
        } catch (IOException ex) {
            Logger.getLogger(frmcompany.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearFields() throws IOException{
    txtname.setText("Cash purchase");
    txtbarcode.setText("");
    txtproname.setText("");
    txtprice.setText("");
    txtdisc.setText("");
    txtstax.setText("");
    txtqty.setText("");
    txtamount.setText("");
    txtttlamount.setText("");
    txtreceivedamount.setText("");
    txtchange.setText("");
    txtbarcode.requestFocus();
    for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
    showData();
    serialno();
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
        tblpurchase1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpurchase2 = new javax.swing.JTable();
        txtamount = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtttlamount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtreceivedamount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtchange = new javax.swing.JTextField();
        txtproname = new javax.swing.JTextField();
        txtbarcode = new javax.swing.JTextField();
        txtstax = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txtdisc = new javax.swing.JTextField();
        btnprint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Purchase");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        tblpurchase1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblpurchase1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblpurchase1);

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
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sr no");

        txtno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Date");

        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });

        tblpurchase2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblpurchase2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Name", "Price", "Disc", "S Tax", "Qty", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpurchase2.setShowGrid(false);
        jScrollPane2.setViewportView(tblpurchase2);
        if (tblpurchase2.getColumnModel().getColumnCount() > 0) {
            tblpurchase2.getColumnModel().getColumn(0).setResizable(false);
            tblpurchase2.getColumnModel().getColumn(1).setResizable(false);
            tblpurchase2.getColumnModel().getColumn(2).setResizable(false);
            tblpurchase2.getColumnModel().getColumn(3).setResizable(false);
            tblpurchase2.getColumnModel().getColumn(4).setResizable(false);
            tblpurchase2.getColumnModel().getColumn(5).setResizable(false);
            tblpurchase2.getColumnModel().getColumn(6).setResizable(false);
        }

        txtamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountActionPerformed(evt);
            }
        });
        txtamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtamountKeyPressed(evt);
            }
        });

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total Amount");

        txtttlamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtttlamountActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Name");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cash Given");

        txtreceivedamount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtreceivedamountFocusLost(evt);
            }
        });
        txtreceivedamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreceivedamountActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Remaining");

        txtchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchangeActionPerformed(evt);
            }
        });

        txtproname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpronameActionPerformed(evt);
            }
        });

        txtbarcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbarcodeFocusLost(evt);
            }
        });
        txtbarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbarcodeActionPerformed(evt);
            }
        });
        txtbarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbarcodeKeyPressed(evt);
            }
        });

        txtstax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstaxActionPerformed(evt);
            }
        });

        txtqty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqtyFocusLost(evt);
            }
        });
        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });

        txtdisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscActionPerformed(evt);
            }
        });

        btnprint.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnprint.setText("PRINT");
        btnprint.setContentAreaFilled(false);
        btnprint.setOpaque(true);
        btnprint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnprintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnprintMouseExited(evt);
            }
        });
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtttlamount, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtreceivedamount, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtchange, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtproname, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdisc, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstax, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtproname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstax, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdisc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtttlamount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtchange, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtreceivedamount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String query = "insert/insert into tbl_purchase1(purchase_name,purchase_date,purchase_ttlamount,purchase_cashgiven) values ('" + txtname.getText() + "','" + txtdate.getText() + "'," + parseInt(txtttlamount.getText()) + "," + parseInt(txtreceivedamount.getText()) + ")";
            System.out.println(query);
            Connection(query);
            for(int i=0;i<model.getRowCount();i++){
            String query1 = "insert/insert into tbl_purchase2(purchase_Fkid,purchase_Fkproduct,purchase_price,purchase_disc,purchase_tax,purchase_quantity) values ("+parseInt(txtno.getText())+",'" + model.getValueAt(i, 1).toString() + "',"+Double.parseDouble(model.getValueAt(i, 2).toString())+","+Double.parseDouble(model.getValueAt(i, 3).toString())+","+Double.parseDouble(model.getValueAt(i, 4).toString())+","+parseInt(model.getValueAt(i, 5).toString())+")";    
                System.out.println(query1);
                Connection(query1);
            }
            clearFields();
        } catch (IOException ex) {
            System.out.println("Doesnt execute the query");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btndeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseEntered
        btndelete.setBackground(new Color(54, 33, 89));
        btndelete.setForeground(Color.white);
    }//GEN-LAST:event_btndeleteMouseEntered

    private void btndeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseExited
        btndelete.setBackground(new Color(255,255,255));
        btndelete.setForeground(Color.black);
    }//GEN-LAST:event_btndeleteMouseExited

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
       try {
           String query1 = "delete/Delete from tbl_purchase2 where purchase_Fkid=" + parseInt(txtno.getText());
            System.out.println(query1);
            Connection(query1);
            String query = "delete/Delete from tbl_purchase1 where purcahse_id=" + parseInt(txtno.getText());
            System.out.println(query);
            Connection(query);
            clearFields();
        } catch (IOException ex) {
            System.out.println("Doesnt execute the query");
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnresetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseEntered
        btnreset.setBackground(new Color(54, 33, 89));
        btnreset.setForeground(Color.white);
    }//GEN-LAST:event_btnresetMouseEntered

    private void btnresetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseExited
        btnreset.setBackground(new Color(255,255,255));
        btnreset.setForeground(Color.black);
    }//GEN-LAST:event_btnresetMouseExited

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        try {
            clearFields();
        } catch (IOException ex) {
            Logger.getLogger(frmpurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnupdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseEntered
       btnupdate.setBackground(new Color(54, 33, 89));
        btnupdate.setForeground(Color.white);
    }//GEN-LAST:event_btnupdateMouseEntered

    private void btnupdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseExited
       btnupdate.setBackground(new Color(255,255,255));
        btnupdate.setForeground(Color.black);
    }//GEN-LAST:event_btnupdateMouseExited

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
           String query = "update/Update tbl_purchase1 set purchase_date='"+txtdate.getText()+"',purchase_name='"+txtname.getText()+"',purchase_ttlamount="+parseInt(txtttlamount.getText())+",purchase_cashgiven="+parseInt(txtreceivedamount.getText())+" where purcahse_id="+parseInt(txtno.getText());
            System.out.println(query);
            Connection(query);
            for(int i=0;i<model.getRowCount();i++){
            String query1 = "update/update tbl_purchase2 Set purchase_Fkproduct='" + model.getValueAt(i, 1).toString() + "',purchase_price=" + Double.parseDouble(model.getValueAt(i, 2).toString()) + ",purchase_disc=" + Double.parseDouble(model.getValueAt(i, 3).toString()) + ",purchase_tax=" + Double.parseDouble(model.getValueAt(i, 4).toString()) +",purchase_quantity=" + parseInt(model.getValueAt(i, 5).toString())  + " where purchase_Fkid="+parseInt(txtno.getText());    
                System.out.println(query1);
                Connection(query1);
            }
            clearFields();
        } catch (IOException ex) {
            System.out.println("Doesnt execute the query");
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void txtnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateActionPerformed

    private void txtamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamountActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtttlamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtttlamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtttlamountActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtreceivedamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreceivedamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreceivedamountActionPerformed

    private void txtchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchangeActionPerformed

    private void txtpronameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpronameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpronameActionPerformed

    private void txtbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbarcodeActionPerformed

    private void txtstaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstaxActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyActionPerformed

    private void txtdiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiscActionPerformed

    private void btnprintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprintMouseEntered
        btnprint.setBackground(new Color(54, 33, 89));
        btnprint.setForeground(Color.white);
    }//GEN-LAST:event_btnprintMouseEntered

    private void btnprintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprintMouseExited
        btnprint.setBackground(new Color(255,255,255));
        btnprint.setForeground(Color.black);
    }//GEN-LAST:event_btnprintMouseExited

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnprintActionPerformed

    private void txtamountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtamountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String total="0";
        model.insertRow(model.getRowCount(), new Object[]{txtbarcode.getText(), txtproname.getText(),txtprice.getText(),txtdisc.getText(),txtstax.getText(),txtqty.getText(),txtamount.getText()});
        txtbarcode.setText("");
    txtproname.setText("");
    txtprice.setText("");
    txtdisc.setText("");
    txtstax.setText("");
    txtqty.setText("");
    txtamount.setText("");
    txtbarcode.requestFocus();
        for (int i = 0; i < model.getRowCount(); i++) {
                int Amount = Integer.parseInt(model.getValueAt(i, 6) + "");
                total = String.valueOf(Amount + Integer.parseInt(total));
            }
            txtttlamount.setText(total);
        }
    }//GEN-LAST:event_txtamountKeyPressed

    private void txtreceivedamountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtreceivedamountFocusLost
        txtchange.setText(String.valueOf(parseInt(txtttlamount.getText())-parseInt(txtreceivedamount.getText())));
    }//GEN-LAST:event_txtreceivedamountFocusLost

    private void txtbarcodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbarcodeFocusLost
        
    }//GEN-LAST:event_txtbarcodeFocusLost

    private void txtqtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqtyFocusLost
        Double a=Double.parseDouble(txtprice.getText())+(Double.parseDouble(txtstax.getText())*Double.parseDouble(txtprice.getText())/100)-(Double.parseDouble(txtdisc.getText())*Double.parseDouble(txtprice.getText())/100);
        String b=String.valueOf((int)(a*parseInt(txtqty.getText())));
        txtamount.setText(b);
    }//GEN-LAST:event_txtqtyFocusLost

    private void txtbarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarcodeKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try {
            String a="purchasebarcode/"+txtbarcode.getText();
            Connection(a);
            String data[] = s.split(",");
            txtproname.setText(data[0]);
            txtprice.setText(data[1]);
            txtdisc.setText(data[2]);
            txtstax.setText(data[3]);
        } catch (IOException ex) {
            Logger.getLogger(frmpurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_txtbarcodeKeyPressed

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
            java.util.logging.Logger.getLogger(frmpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmpurchase().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(frmpurchase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblpurchase1;
    private javax.swing.JTable tblpurchase2;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtbarcode;
    private javax.swing.JTextField txtchange;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtdisc;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtproname;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtreceivedamount;
    private javax.swing.JTextField txtstax;
    private javax.swing.JTextField txtttlamount;
    // End of variables declaration//GEN-END:variables
}
