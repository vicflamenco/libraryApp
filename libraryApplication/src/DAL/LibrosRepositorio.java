package DAL;

import Modelos.Libro;
import java.sql.*;
import java.util.*;

public class LibrosRepositorio {
    
    private final Persistencia _persistencia;
    
    public LibrosRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Libro> Leer(){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM Libro";
            ResultSet rs = stmt.executeQuery(sql);
            List<Libro> lstLibros = new ArrayList<>();
            while (rs.next()){
                lstLibros.add(
                        new Libro(
                                rs.getString("idlibro"), 
                                rs.getString("titulo"), 
                                rs.getInt("anio"),
                                rs.getString("edicion"),
                                rs.getString("sinopsis")
                        ));
            }
            return lstLibros;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public Libro Leer(String id){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM Libro WHERE idlibro = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.first()){
                return new Libro(
                                rs.getString("idlibro"), 
                                rs.getString("titulo"), 
                                rs.getInt("anio"),
                                rs.getString("edicion"),
                                rs.getString("sinopsis")
                        );
            } else {
                return null;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public int Insertar(String id, String titulo, int anio, 
            String edicion, String sinopsis, int idEditorial, int idAutor) {
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "INSERT INTO Libro (idlibro, titulo, anio, edicion, sinopsis, ideditorial, idAutor)";
            sql += " VALUES('" + id + "','" + titulo + "'," + anio + ",'" + edicion + "','";
            sql += sinopsis + "'," + idEditorial + "," + idAutor + ");";
            return stmt.executeUpdate(sql);
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
            sql += "idAutor = " + libro.getIdAutor() + ");";
            return stmt.executeUpdate(sql);
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
                return 0;
            } else {
                String sql = "DELETE Libro Where idlibro = " + id + ";";
                return stmt.executeUpdate(sql);
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
}
