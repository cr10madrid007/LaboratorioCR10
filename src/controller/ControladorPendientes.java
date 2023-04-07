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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author crist
 */
public class ControladorPendientes {
    conexion db = new conexion();
    notificaciones nt = new notificaciones();
    DefaultTableModel modelo;
    DefaultTableModel modeloP;
    
    public DefaultTableModel modeloUsuarios(){
        String[] titulo ={"Identidad", "Nombre", "Correo", "Celular"};
        modelo = new DefaultTableModel(null, titulo);
        return modelo;
    }
    
    public DefaultTableModel tablaUsuarios(String parametros){
        String consulta="SELECT * FROM tclientes WHERE "
                + " identidad    LIKE '"+parametros+"%'         ||"
                + " nombre       LIKE '"+parametros+"%'         ||"
                + " celular      LIKE '"+parametros+"%'         ||"
                + " correo       LIKE '"+parametros+"%'           " ;
       
                PreparedStatement st;
                            try {
                                st = db.conectar().prepareStatement(consulta);
                                ResultSet rs = st.executeQuery();

                                while(rs.next()){
                                    Object[] clientes = {
                                        rs.getString("identidad"),
                                        rs.getString("nombre"),
                                        rs.getString("correo"),
                                        rs.getString("celular")
                                    };

                                    modelo.addRow(clientes);


                                }
                                db.desconectar();
                                return modelo;

                            } catch (SQLException ex) {
                                Logger.getLogger(ControladorPendientes.class.getName()).log(Level.SEVERE, null, ex);
                                
                            }
            db.desconectar();
           return null;     
    }
    
    
    public DefaultTableModel modeloPendientes(){
        String[] titulo ={"Examen", "Fecha de ingreso", "Estado"};
        modeloP = new DefaultTableModel(null, titulo);
        return modeloP;
    }
    
    
    public DefaultTableModel tablaPendientes(String parametros){
        String consulta="SELECT * FROM tclientes WHERE "
                + " identidad    LIKE '"+parametros+"%'         ||"
                + " nombre       LIKE '"+parametros+"%'         ||"
                + " celular      LIKE '"+parametros+"%'         ||"
                + " correo       LIKE '"+parametros+"%'           " ;
                PreparedStatement st;
                            try {
                                st = db.conectar().prepareStatement(consulta);
                                ResultSet rs = st.executeQuery();

                                while(rs.next()){
                                    Object[] clientes = {
                                        rs.getString("identidad"),
                                        rs.getString("nombre"),
                                        rs.getString("correo"),
                                        rs.getString("celular")
                                    };

                                    modelo.addRow(clientes);


                                }
                                db.desconectar();
                                return modelo;

                            } catch (SQLException ex) {
                                Logger.getLogger(ControladorPendientes.class.getName()).log(Level.SEVERE, null, ex);
                                
                            }
            db.desconectar();
           return null;     
    }
    
    
}
