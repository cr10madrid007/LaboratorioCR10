/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import ds.desktop.notify.DesktopNotify;

/**
 *
 * @author crist
 */
public class notificaciones {
    
    public void procesoTerminado(String titulo, String contenido, int tiempo){
        DesktopNotify.showDesktopMessage(
                titulo,
                contenido,
                DesktopNotify.SUCCESS,
                tiempo);
    }
    
    public void procesoErroneo(String titulo, String contenido, int tiempo){
         DesktopNotify.showDesktopMessage(
                titulo,
                contenido,
                DesktopNotify.ERROR,
                tiempo);
    }
    
    
    public void procesoFallido(String titulo, String contenido, int tiempo){
         DesktopNotify.showDesktopMessage(
                titulo,
                contenido,
                DesktopNotify.FAIL,
                tiempo);
    }
    
    public void procesoAyuda(String titulo, String contenido, int tiempo){
         DesktopNotify.showDesktopMessage(
                titulo,
                contenido,
                DesktopNotify.HELP,
                tiempo);
    }
    
    public void procesoInformacion(String titulo, String contenido, int tiempo){
         DesktopNotify.showDesktopMessage(
                titulo,
                contenido,
                DesktopNotify.INFORMATION,
                tiempo);
    }
    
    public static void procesoRespuesta(String titulo, String contenido, int tiempo){
        String rst;
        
                DesktopNotify.showDesktopMessage(
                titulo,
                contenido,
                DesktopNotify.INPUT_REQUEST,
                tiempo);
    }
    
    
    public static void procesoConsejo(String titulo, String contenido, int tiempo){
         DesktopNotify.showDesktopMessage(
                titulo,
                contenido,
                DesktopNotify.TIP,
                tiempo);
    }
    
    public static void procesoPrecaucion(String titulo, String contenido, int tiempo){
         DesktopNotify.showDesktopMessage(
                titulo,
                contenido,
                DesktopNotify.WARNING,
                tiempo);
    }
    
    public static void procesoDefault(String titulo, String contenido, int tiempo){
         DesktopNotify.showDesktopMessage(
                titulo,
                contenido,
                DesktopNotify.DEFAULT,
                tiempo);
    }
    public static void main(String[] args) {
        procesoRespuesta("Hola","Cuerpo",5000);
    }
    
}
