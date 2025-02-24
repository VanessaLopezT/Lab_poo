/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conceptospoo;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Estudiante_MCA
 */
public class Programa implements Serializable{
    private double ID;
    private String nombre;
    private double duracion;
    private Date registro;
    private Facultad facultad;

    public Programa(double ID, String nombre, double duracion, Date registro, Facultad facultad) {
        this.ID = ID;
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return "Programa{" + "ID=" + ID + ", nombre=" + nombre + ", duracion=" + duracion + ", registro=" + registro + ", facultad=" + facultad.toString() + '}';
    }

    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
    
    
}
