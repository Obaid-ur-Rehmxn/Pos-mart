/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.server;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getString;

/**
 *
 * @author Obaid
 */
public class server {

    String s;

    void serverside() throws IOException, Exception {
        String clientdata = "";
        String status = "";
        ServerSocket welcomeSocket = new ServerSocket(9999);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient
                    = new DataOutputStream(connectionSocket.getOutputStream());
            clientdata = inFromClient.readLine();
            System.out.println(clientdata);
            String data[] = clientdata.split("/");
            if (data[0].equalsIgnoreCase("login")) 
            {
                System.out.println("k5");
                String username = data[1];
                String userpass = data[2];
                status = login_validation(username, userpass);
                outToClient.writeBytes(status + '\n');
                connectionSocket.close();
            } 
            else if (data[0].equalsIgnoreCase("fkcompany"))
            {
                int a = 0;
                String qwe = data[1];
                Connection con = DriverManager.getConnection(ConnectionClass.conString);
                PreparedStatement pst = con.prepareStatement(qwe);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    a = rs.getInt(1);
                    System.out.println(a);
                }
                String b = String.valueOf(a);
                con.close();
                outToClient.writeBytes(b + '\n');
                connectionSocket.close();
            } 
            else if (data[0].equalsIgnoreCase("insert") || data[0].equalsIgnoreCase("update") || data[0].equalsIgnoreCase("delete")) {
                String qwe = data[1];
                Connection con = DriverManager.getConnection(ConnectionClass.conString);
                PreparedStatement pst = con.prepareStatement(qwe);
                boolean abc = pst.execute();
                System.out.println(abc);
                String q=String.valueOf(abc);
                con.close();
                outToClient.writeBytes(q + '\n');
                connectionSocket.close();
            } 
            else if (clientdata.equals("tbl_inventory")) {
                s = clientdata;
                getDataFromInventory(clientdata);
                outToClient.writeBytes("filecreated" + '\n');
                connectionSocket.close();
                String path = s + ".txt";
        while (true) {     
            Socket sr = welcomeSocket.accept();
            FileInputStream fr = new FileInputStream(path);
            byte b[] = new byte[2002];
            fr.read(b, 0, b.length);
            OutputStream os = sr.getOutputStream();
            os.write(b, 0, b.length);
        }
            }
             else if (clientdata.equals("tbl_company")) {
                s = clientdata;
                getDataFromCompany(clientdata);
                outToClient.writeBytes("filecreated" + '\n');
                connectionSocket.close();
                String path = s + ".txt";
                Socket sr;
        while (true) {
            sr = welcomeSocket.accept();
            FileInputStream fr = new FileInputStream(path);
            byte b[] = new byte[2002];
            fr.read(b, 0, b.length);
            OutputStream os = sr.getOutputStream();
            os.write(b, 0, b.length);
        }
       }
        }
    }

    String login_validation(String username, String userpass) throws SQLException {
        String status = "invalid";
        Connection con = DriverManager.getConnection(ConnectionClass.conString);
        PreparedStatement statement = con.prepareStatement("SELECT * FROM tbl_users");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            if ((rs.getString(2).equals(username)) && (rs.getString(3).equals(userpass))) {
                status = "valid";
                break;
            }
        }
        con.close();
        return status;
    }

//    public void checkrows(String table) throws SQLException, IOException{
//        System.out.println("into check");
//        Connection con = DriverManager.getConnection(ConnectionClass.conString);
//        PreparedStatement statement = con.prepareStatement("SELECT count(*) FROM "+table);
//        ResultSet rs = statement.executeQuery();
//        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
//         int numberOfColumn = rsmd.getColumnCount()
//        System.out.println(count);
//      getDataFromTables(count,table);
//    }
    String getDataFromInventory(String table) throws SQLException, IOException {
        String[] data = {"", "", "", "", "", "", "", "", ""};
        String fileData = "";
        String path = table + ".txt";
        FileWriter myWriter = new FileWriter(path);
        myWriter.write("");
        myWriter.close();
        FileWriter file = new FileWriter(path);
        Connection con = DriverManager.getConnection(ConnectionClass.conString);
        PreparedStatement statement = con.prepareStatement("SELECT * FROM " + table);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            data[0] = rs.getString("inventory_barcode");
            data[1] = rs.getString("inventory_name");
            data[2] = rs.getString("inventory_saleprice");
            data[3] = rs.getString("inventory_saledisc");
            data[4] = rs.getString("inventory_saletax");
            data[5] = rs.getString("inventory_purchaseprice");
            data[6] = rs.getString("inventory_purchasedisc");
            data[7] = rs.getString("inventory_purchasetax");
            fileData = data[0].concat("," + data[1]).concat("," + data[2]).concat("," + data[3]).concat("," + data[4]).concat("," + data[5]).concat("," + data[6]).concat("," + data[7]);
            System.out.println(fileData);    
        file.write(fileData);
        file.write("\n");
        }
        file.close();
        con.close();
        return fileData;
    }
    
    String getDataFromCompany(String table) throws SQLException, IOException {
        System.out.println("company");
        String[] data = {"", "", ""};
        String fileData = " ";
        String path = table + ".txt";
        FileWriter myWriter = new FileWriter(path);
        myWriter.write("");
        myWriter.close();
        FileWriter file = new FileWriter(path);
        Connection con = DriverManager.getConnection(ConnectionClass.conString);
        PreparedStatement statement = con.prepareStatement("SELECT * FROM " + table);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            data[0] = rs.getString("company_id");
            data[1] = rs.getString("company_name");
            data[2] = rs.getString("company_shortname");
            fileData = data[0].concat("," + data[1]).concat("," + data[2]);
            System.out.println(fileData);    
        file.write(fileData);
        file.write("\n");
        }
        file.close();
        con.close();
        return fileData;
    }
    
    void sendFile(String table) throws IOException {
        String path = table + ".txt";
        ServerSocket s = new ServerSocket(9999);
        while (true) {     
        Socket sr = s.accept();
            FileInputStream fr = new FileInputStream(path);
            byte b[] = new byte[2002];
            fr.read(b, 0, b.length);
            OutputStream os = sr.getOutputStream();
            os.write(b, 0, b.length);
        }  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        server s=new server();
        s.serverside();

    }
}
