/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author crist
 */
public class examenes {
    String idexamen,examen;
    Double precio;

    public examenes(String idexamen, String examen, Double precio) {
        this.idexamen = idexamen;
        this.examen = examen;
        this.precio = precio;
    }

    public void setIdexamen(String idexamen) {
        this.idexamen = idexamen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getIdexamen() {
        return idexamen;
    }

    public String getExamen() {
        return examen;
    }

    public Double getPrecio() {
        return precio;
    }
    
    
    @Override
    public String toString() {
    return examen + " | L" + precio;
    }
}
