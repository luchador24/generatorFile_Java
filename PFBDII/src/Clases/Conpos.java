/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
/**
 *
 * @author rherr
 */
public class Conpos {
    //public static void main(String[] args){
        String jdbcURL = "jdbc:postgresql://localhost:5432/bd";
        String username = "postgres";
        String password = "Pos1uch@214";
        
        public Conpos(){
        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL server");
            connection.close();
        }catch(SQLException e){
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }}
    //}
}
