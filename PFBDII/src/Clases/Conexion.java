/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
public class Conexion {
    
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    public Conexion ()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306,Login","root","Mysm@ldoql2023");
            System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            
            System.out.println("Error al conectar a la base de datos");
        }
    }
    
    public ArrayList<LoginGetSet> login(String usuario, String clave)
    {
        ArrayList<LoginGetSet> res = new ArrayList<>();
        try {
            ps = cn.prepareStatement("SELECT * FROM usuario WHERE id=? AND clave=?");
            ps.setString(1, usuario);
            ps.setString(2, clave );
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                LoginGetSet lo = new LoginGetSet();
                lo.setId(rs.getString("id"));
                lo.setClave(rs.getString("clave"));
                lo.setNombre(rs.getString("nombre"));
                res.add(lo);
            }
            
            if (res.isEmpty()) {
                
                System.out.println("Acceso Denegado");
                
            } else {
                System.out.println("Login exitoso");
            }
        } catch (Exception e) {
        }
        return res;
    }
    
   
   
}
