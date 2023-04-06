package controller;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    String dataBase="cr10_lab";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
  //conectar
    public conexion(){
        
    }
    public Connection conectar(){         
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+dataBase,user,password);
            //System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar :\n"+ex+"\n\n");
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;      
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        conexion conect = new conexion();
        conect.conectar();
    }
}
