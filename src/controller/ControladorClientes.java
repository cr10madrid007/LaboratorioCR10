/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import clases.notificaciones;
import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.xdevapi.Statement;
import com.mysql.cj.*;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author crist
 */
public class ControladorClientes {
    conexion db = new conexion();
    notificaciones nt = new notificaciones();
    
    public void insertar(String identidad, String nombre, String sexo, String celular, String correo, long fechaNacimiento){
        System.out.println(celular);
        java.sql.Date fecha = new java.sql.Date(fechaNacimiento);// parseamos al formato del sql 
        try {
            
            String consulta="INSERT INTO tclientes (identidad, nombre, sexo, celular, correo, fechaNacimiento) VALUES (?,?,?,?,?,?)";
            CallableStatement cs = (CallableStatement) db.conectar().prepareCall(consulta);
                cs.setString(1, identidad);
                cs.setString(2, nombre);
                cs.setString(3, sexo);
                cs.setString(4, celular);
                cs.setString(5, correo);
                cs.setDate(6, fecha);
                
                cs.execute();
                
                
                nt.procesoTerminado("Proceso terminado", "El usuario "+nombre+" fue agregado con exito.", 5000);
                db.desconectar();
        } catch (SQLException ex) {
               nt.procesoFallido("Proceso fallido", "Surgio un error al intentar guardar", 5000);
        }
    }
    
    public int verificarIdentidad(String identidad){
        
        String consulta="SELECT * FROM tclientes WHERE identidad = '"+identidad+"'";
       
        try{
                PreparedStatement st = db.conectar().prepareStatement(consulta);
                ResultSet rs = st.executeQuery();
               
                
                if(!rs.next()){
                     db.desconectar();
                    return 0;
                }else{
                     db.desconectar();
                    return 1;
                }
                
        
                        /*
                if(identidad.length() == 13){

                }else{

                }
        */
        
        }catch(Exception e) {
         db.desconectar();    
        return 1;
        }
    
        }
}
