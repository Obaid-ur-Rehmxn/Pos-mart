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
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
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
//              
            }
        }
            catch(Exception e){
                    System.out.println("khaie ahi");
                    }
   
} 
public String login_validation(String username,String userpass) throws SQLException {
    String status="invalid";
    System.out.println(username);
    System.out.println(userpass);
    Connection con = DriverManager.getConnection(ConnectionClass.conString);
    PreparedStatement statement = con.prepareStatement("SELECT * FROM tbl_users");
    ResultSet rs = statement.executeQuery();
     while (rs.next())
             {      
//                String name = rs.getString("RwName");         
//                 if("obaid"==username  && "obaid"==userpass){
                if((rs.getString(2).equals(username)) && (rs.getString(3).equals(userpass))){
                     status="valid";
                break;
                }

                 }
             //end while
             con.close();
             return status;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        server s=new server();
        s.serverside();
        
}

    }
    

