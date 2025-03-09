/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import modelo.Persona;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author VANESA
 */
public class PersonaDAO {
    private Connection conexion;

    public PersonaDAO(Connection conexion) {
        this.conexion = conexion;
    }
        
public void guardarPersonaBD(Connection conexion, Persona persona) throws SQLException { 
    String sqlPersona = "MERGE INTO persona KEY(id) VALUES (?, ?, ?, ?);";
    
    try (PreparedStatement pstmt = conexion.prepareStatement(sqlPersona)) {
        pstmt.setInt(1, persona.getID());
        pstmt.setString(2, persona.getNombres());
        pstmt.setString(3, persona.getApellidos());
        pstmt.setString(4, persona.getEmail());
        pstmt.executeUpdate();
    }
}
    public Persona obtenerPersonaPorID(int idPersona) throws SQLException {
        String sql = "SELECT * FROM persona WHERE id = ?";
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idPersona);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return DAOFactory.crearPersona(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email")
                    );
                }
            }
        }
        return null; // Retorna null si la persona no existe
    
}
}
