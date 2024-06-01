/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bank.management.system;


import java.sql.*;

/**
 *
 * @author khanh
 */
public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "BtsSvt181104");
            s = c.createStatement();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
}
