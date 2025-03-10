/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import servicios.Servicios;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.io.Serializable;


/**
 *
 * @author Estudiante_MCA
 */
    public class CursoProfesores implements Serializable, Servicios{
    private static final long serialVersionUID=1L; // Para mantener compatibilidad en serialización
    private List<CursoProfesor> listado=new ArrayList<CursoProfesor>();
    
    
    @Override
    public String toString() {
        return "CursoProfesores{" + "listado=" + listado + '}';
    }

    public List<CursoProfesor> getListado() {
        return listado;
    }

    public void agregarCursoProfesor(CursoProfesor cursoProfesor) {
        listado.add(cursoProfesor);
    }

    public void eliminarCursoProfesor(CursoProfesor cursoProfesor) {
        listado.remove(cursoProfesor);
    }

  
    public void guardainformacion() {
    try {
        FileOutputStream archivo = new FileOutputStream("CursoProfesor.bin");
        ObjectOutputStream escritura = new ObjectOutputStream(archivo);
        
        escritura.writeObject(listado); // Guardar lista completa en binario
        System.out.print("\nguardainformacion--> Lista de CursoProfesor aniadida con exito.");
        escritura.close();
    } catch (IOException error) {
        error.printStackTrace(System.out);
    }
}

    public void cargarDatos() {
    try (FileInputStream archivo = new FileInputStream("CursoProfesor.bin");
         ObjectInputStream lectura = new ObjectInputStream(archivo)) {
        
        List<CursoProfesor> listaCursoProfesorRecuperada = (List<CursoProfesor>) lectura.readObject();
        
        System.out.println("\ncargarDatos--> Lista de CursoProfesor leída con éxito:");
        for (CursoProfesor cursoProfesor : listaCursoProfesorRecuperada) {
            if (cursoProfesor.getCurso() != null && cursoProfesor.getProfesor() != null) {
                System.out.println(cursoProfesor);
            }
        }
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al leer el archivo:");
        e.printStackTrace();
    }
}
    

    @Override
    public String ImprimirPosicion(int posicion) {
        return (posicion >= 0 && posicion < listado.size()) ? listado.get(posicion).toString() : "Posición fuera de rango";
    }

    @Override
    public int cantidadActual() {
        return listado.size();
    }

    @Override
    public List<String> ImprimirListado() {
        List<String> cursos = new ArrayList<>();
        for (CursoProfesor cursoProfesor : listado) {
            cursos.add("\n"+cursoProfesor.toString());
        }
        return cursos;
    }
    

}

    
    

