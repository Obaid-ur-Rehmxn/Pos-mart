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
    
  
    
public void serverside() throws IOException, Exception{
    String clientdata = "";
    String status="";
    ServerSocket welcomeSocket = new ServerSocket(9999);
    try {
        
            
                               System.out.println("k1");

            while(true) {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new
                InputStreamReader(connectionSocket.getInputStream()));
                                               System.out.println("k2");

                
                DataOutputStream outToClient =
                        new DataOutputStream(connectionSocket.getOutputStream());
                
                clientdata = inFromClient.readLine();
                                               System.out.println("k3");

                
                 String data[]=clientdata.split(",");
                   
                                                System.out.println("k4");

//                 if(form.equals("login"))
//                 {
//                                                    System.out.println("k5");
//
//                     String username=data[1];
//                     String userpass=data[2];           
//                     status=login_validation(username,userpass);
//                }

//                 else{
                                                    System.out.println("k6");
           System.out.println("pta nii");
        Connection con = DriverManager.getConnection(ConnectionClass.conString) ;
        System.out.println("pta nii2");
//        String sql="insert into test2 values (?,?,?)";
String sql="delete from test2 where idw=1";
//          Statement st=(Statement) con.createStatement();
//          
//          st.execute();
        PreparedStatement pst=con.prepareStatement(sql);
//        pst.setString(1, data[0]);
//        pst.setString(2, data[1]);
//        pst.setString(3, data[2]);
         System.out.println("pta nii3");
//        pst.executeUpdate();
pst.execute();
                    
//                 }
                                                System.out.println("k7");

                outToClient.writeBytes(status +'\n');
                                               System.out.println("k8");

              
            }}
           
        
            catch(Exception e){
                    System.out.println("khaie ahi");
                    }
     welcomeSocket.close();
      
   
} 

public String basicSqlFunctions(String s1,String s2,String s3) throws SQLException, Exception{
    System.out.println("ghjg");
//    Statement st=(Statement) con.prepareStatement(query);
    try {
        System.out.println("pta nii");
        Connection con = DriverManager.getConnection(ConnectionClass.conString) ;
        System.out.println("pta nii2");
        String sql="insert into test2 values (?,?,?)";
        //    Statement st=(Statement) con.prepareStatement(query);
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, s1);
        pst.setString(2, s2);
        pst.setString(3, s3);
        pst.executeUpdate();
        System.out.println("pta nii3");
        
//        ResultSet rs=st.executeQuery();
        
        System.out.println("pta nii4");
        con.close();
        System.out.println("pta nii5");
    }
    catch(Exception e){
        System.out.println("ni chl raha boss");
    }
    
    return "sabr kr bhai";
}

public String login_validation(String username,String userpass) throws SQLException {
    String status="invalid";
    Connection con = DriverManager.getConnection(ConnectionClass.conString);
    PreparedStatement statement = con.prepareStatement("SELECT * FROM tbl_users");
    ResultSet rs = statement.executeQuery();
     while (rs.next())
             {      
                if((rs.getString(2).equals(username)) && (rs.getString(3).equals(userpass))){
                     status="valid";
                break;
                }
                 }    
             con.close();
             return status;
}

public void getDataFromUsers() throws SQLException, IOException{
    String data = "";
    String path="C:\\Users\\Jamal\\Desktop\\nabeel.txt";
     Connection con = DriverManager.getConnection(ConnectionClass.conString);
    PreparedStatement statement = con.prepareStatement("SELECT * FROM tbl_users");
    ResultSet rs = statement.executeQuery();
     while (rs.next()){
         String b=rs.getString(2);
         String c=rs.getString(3);
         data=b.concat(","+c);
         writeTextToFile(data, path);
}
      con.close();
      sendFile(path);   
}

public void writeTextToFile(String data,String path) throws IOException{
     FileWriter file = new FileWriter(path,true);
         BufferedWriter myWriter=new BufferedWriter(file);
         myWriter.write(data);
         myWriter.newLine();
         myWriter.close();
         file.close();
}

public void sendFile(String path) throws IOException{
    path="C:\\Users\\Jamal\\Desktop\\nabeel.txt";
    ServerSocket s=new ServerSocket(4333);
        while(true){
        Socket sr=s.accept();
        FileInputStream fr=new FileInputStream(path);
        byte b[]=new byte[2002];
        fr.read(b,0,b.length);
        OutputStream os=sr.getOutputStream();
        os.write(b, 0, b.length);
        }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException, Exception {
        server s=new server();
        s.serverside();
//    try {
//        server s=new server();
//        
//s.basicSqlFunctions("insert into test values("+63434+",'sprite',"+"'spr')");
//    } catch (Exception ex) {
//        Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
//    }
        
}
}
    

