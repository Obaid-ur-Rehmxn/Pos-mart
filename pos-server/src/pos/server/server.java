/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.server;

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
import static javax.swing.UIManager.getString;

/**
 *
 * @author Obaid
 */
public class server {
public void serverside(){
    String clientdata = "";
    String status="";
    try {
        
            ServerSocket welcomeSocket = new ServerSocket(6789);
           
            while(true) {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new
                InputStreamReader(connectionSocket.getInputStream()));
                
                DataOutputStream outToClient =
                        new DataOutputStream(connectionSocket.getOutputStream());
                
                clientdata = inFromClient.readLine();
                 String data[]=clientdata.split(",");
                 String form=data[0];
                 if(form.equals("login")){
                     String username=data[1];
                     String userpass=data[2];           
                     status=login_validation(username,userpass);
                }
                outToClient.writeBytes(status +'\n');
              
            }
        }
            catch(Exception e){
                    System.out.println("khaie ahi");
                    }
   
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
    String data = " ";
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
    public static void main(String[] args) throws SQLException, IOException {
        server s=new server();
        s.getDataFromUsers();
        
}
}
    

