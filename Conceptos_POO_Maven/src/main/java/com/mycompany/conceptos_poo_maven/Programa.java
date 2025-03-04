/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conceptos_poo_maven;
import java.io.Serializable;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author Estudiante_MCA
 */
public class Programa implements Serializable{
    private int ID;
    private String nombre;
    private double duracion;
    private Date registro;
    private Facultad facultad;

    public Programa(int ID, String nombre, double duracion, Date registro, Facultad facultad) {
        this.ID = ID;
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
    }

  public void guardarProgramaBD(Connection conexion) throws SQLException {
    String sql = "MERGE INTO programa KEY(id) VALUES (?, ?, ?, ?, ?);";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setDouble(1, this.ID);
        pstmt.setString(2, this.nombre);
        pstmt.setDouble(3, this.duracion);
        pstmt.setDate(4, new java.sql.Date(this.registro.getTime()));
        pstmt.setInt(5, this.facultad.getID());
        pstmt.executeUpdate();
    }
}

    @Override
public String toString() {
    return "Programa{" +
           "ID=" + ID +
           ", nombre='" + nombre + '\'' +
           ", duracion=" + duracion +
           ", registro=" + registro +
           ", facultad=" + (facultad != null ? facultad.getNombre() : "Sin Facultad") +
           '}';
}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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
