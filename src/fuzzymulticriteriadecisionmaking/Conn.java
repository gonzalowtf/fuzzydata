/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzymulticriteriadecisionmaking;

/**
 *
 * @author gonzalowtf
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conn {
    public Connection c = null;
    public Statement stmt = null;
    public Conn(String url){
        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Database Class Not Found" + e);
        }
        
        
        try{
            c = DriverManager.getConnection("jdbc:sqlite:" + url);
            
            //JOptionPane.showMessageDialog(null,"Connection Established");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Connection Error " + err);
        }
        
        
    }
    
}
