    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;

/**
 *
 * @author tanuc
 */

public class ConnectionProvider {
    public static Connection getCon(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSl=false","root","Manju@03");
        System.out.println("Connection");
        return con;
        }
            catch(Exception e){
                   return null;
            }   
    }
   
}
