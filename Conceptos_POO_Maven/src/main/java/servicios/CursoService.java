package servicios;

import BaseDatos.ConexionBD;
import DAO.CursoDAO;
import modelo.Curso;
import modelo.Programa;
import DAO.DAOFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class CursoService {
    private Connection conexion;
    private CursoDAO cursoDAO;
 

    
    public void guardarCurso(int idCurso, String nombre, Programa programa, boolean activo) throws SQLException {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío.");
        }

        if (programa == null) {
            throw new IllegalArgumentException("No existe un programa con ese ID en la base de datos.");
        }

        Curso nuevoCurso = DAOFactory.crearCurso(idCurso, nombre, programa, activo);

        try (Connection conexion = ConexionBD.conectar()) {
            CursoDAO cursoDAO = new CursoDAO(conexion);
            cursoDAO.guardarCursoBD(conexion, nuevoCurso);
            ConexionBD.mostrarDatosBD_CURSO();
        }
    }
    
    
    
    
}
