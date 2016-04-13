package DAL;

import Modelos.Libro;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class LibrosRepositorio {
    
    private final Persistencia _persistencia;
    
    public LibrosRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Libro> Leer(){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT l.*, a.nombre nombreAutor, e.nombre nombreEditorial FROM libro l";
            sql += " INNER JOIN autor a ON a.idautor = l.idautor ";
            sql += " INNER JOIN editorial e ON e.ideditorial = l.ideditorial;";
            
            ResultSet rs = stmt.executeQuery(sql);
            List<Libro> lstLibros = new ArrayList<>();
            while (rs.next()){
                lstLibros.add(
                    new Libro(
                        rs.getString("idlibro"), 
                        rs.getString("titulo"), 
                        rs.getInt("anio"),
                        rs.getString("edicion"),
                        rs.getInt("ideditorial"),
                        rs.getInt("idautor"),
                        rs.getString("sinopsis"),
                        rs.getString("nombreAutor"),
                        rs.getString("nombreEditorial")
                ));
            }
            this._persistencia.cerrarConexion();
            return lstLibros;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public Libro Leer(String id){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT l.*, a.nombre nombreAutor, e.nombre nombreEditorial FROM libro l ";
            sql += "INNER JOIN autor a ON a.idautor = l.idautor ";
            sql += "INNER JOIN editorial e ON e.ideditorial = l.ideditorial";
            sql += " WHERE l.idlibro = '" + id + "';";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.first()){
                Libro libro = new Libro(
                    rs.getString("idlibro"), 
                    rs.getString("titulo"), 
                    rs.getInt("anio"),
                    rs.getString("edicion"),
                    rs.getInt("ideditorial"),
                    rs.getInt("idautor"),
                    rs.getString("sinopsis"),
                    rs.getString("nombreAutor"),
                    rs.getString("nombreEditorial")
                );
                this._persistencia.cerrarConexion();
                return libro;
            } else {
                return null;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public int Insertar(Libro libro) {
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "INSERT INTO Libro (idlibro, titulo, anio, edicion, sinopsis, ideditorial, idAutor)";
            sql += " VALUES('" + libro.getIdLibro() + "','" + libro.getTitulo() + "'," + libro.getAnio() + ",'" + libro.getEdicion() + "','";
            sql += libro.getSinopsis() + "'," + libro.getIdEditorial() + "," + libro.getIdAutor() + ");";
            int result = stmt.executeUpdate(sql);
            this._persistencia.cerrarConexion();
            return result;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Actualizar(Libro libro){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "UPDATE libro SET titulo = '" + libro.getTitulo() + "',";
            sql += "anio = " + libro.getAnio() + ",";
            sql += "edicion = '" + libro.getEdicion() + "',";
            sql += "sinopsis = '" + libro.getSinopsis() + "',";
            sql += "ideditorial = " + libro.getIdEditorial() + ",";
            sql += "idAutor = " + libro.getIdAutor() + ";";
            int result = stmt.executeUpdate(sql);
            this._persistencia.cerrarConexion();
            return result;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Eliminar(int id){
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            
            ResultSet rsCount = stmt.executeQuery("SELECT COUNT(*) FROM libro_inventario WHERE idlibro = " + id + ";");
            rsCount.first();
            
            int count = rsCount.getInt(0);

            if (count > 0){
                this._persistencia.cerrarConexion();
                return 0;
            } else {
                String sql = "DELETE Libro Where idlibro = " + id + ";";
                
                int result = stmt.executeUpdate(sql);
                this._persistencia.cerrarConexion();
                return result;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
}
