package controller;

import Formularios.FormLogin;
import Formularios.Home;
import ds.desktop.notify.DesktopNotify;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class consultasLogin {
    public void guardarUsuario(String usuario, String password){
        conexion db = new conexion();
        String sql = "insert into tusuarios(user, pass) values ('" + usuario +"', '" + password +"');";
        Statement st;
        Connection conexion = db.conectar();
        try
        {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public int consultarUsuario(String user, String pass)
    {
        int validar=0;
        // TODO add your handling code here:
        conexion db = new conexion();
        // Se inicializa a null
        String usuarioCorrecto = null;
        String passCorrecto = null;
    try {

        Connection cn = db.conectar();
        PreparedStatement pst = cn.prepareStatement("SELECT user, pass FROM tusuarios where user='"+user+"' && pass='"+pass+"'");
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            usuarioCorrecto = rs.getString(1);
            passCorrecto = rs.getString(2);
        }

        if (user.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
            validar=1;
          //JOptionPane.showMessageDialog(null, "Login correcto Bienvenido " + user);
          DesktopNotify.showDesktopMessage(
                    "Login Correcto",
                    "Bienvenido "+user+" a LaboratorioCR10.",
                    DesktopNotify.SUCCESS,
                    7000);
        } else  {
            //JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            DesktopNotify.showDesktopMessage(
                    "Error",
                    "Sus credenciales no son correctas.",
                    DesktopNotify.FAIL,
                    5000L);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        //JOptionPane.showMessageDialog(null, "Error " + e);
    }
    return validar;
    }
    
}
