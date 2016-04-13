package DAL;

import Modelos.Editorial;
import java.sql.*;
import java.util.*;

public class EditorialesRepositorio {
    
    private final Persistencia _persistencia;
    
    public EditorialesRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Editorial> Leer(){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM Editorial";
            ResultSet rs = stmt.executeQuery(sql);
            List<Editorial> lstEditoriales = new ArrayList<>();
            while (rs.next()){
                lstEditoriales.add(new Editorial(rs.getInt("ideditorial"), rs.getString("nombre")));
            }
            this._persistencia.cerrarConexion();
            return lstEditoriales;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public Editorial Leer(String id){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM Editorial WHERE ideditorial = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.first()){
                Editorial editorial = new Editorial(
                        rs.getInt("ideditorial"), 
                        rs.getString("nombre"));
                this._persistencia.cerrarConexion();
                return editorial;
            } else {
                return null;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public int Insertar(Editorial editorial){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "INSERT INTO Editorial (nombre) VALUES ('" + editorial.getNombre() + "');";
            int result = stmt.executeUpdate(sql);
            this._persistencia.cerrarConexion();
            return result;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Actualizar(Editorial editorial){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "UPDATE Editorial SET nombre = '" + editorial.getNombre() + "' WHERE ideditorial = " + editorial.getIdEditorial() + ";";
            int result = stmt.executeUpdate(sql);
            this._persistencia.cerrarConexion();
            return result;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Eliminar(String id){
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            
            // Verificar que no existan libros asociados a la editorial
            ResultSet rsCount = stmt.executeQuery("SELECT COUNT(ideditorial) FROM libro WHERE ideditorial = " + id + ";");
            rsCount.first();
            
            int count = rsCount.getInt(1);

            if (count > 0){
                this._persistencia.cerrarConexion();
                return 0;
            } else {
                String sql = "DELETE from editorial where ideditorial = " + id + ";";
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
