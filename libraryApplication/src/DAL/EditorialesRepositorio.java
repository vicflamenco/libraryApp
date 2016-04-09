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
                return new Editorial(rs.getInt("ideditorial"), rs.getString("nombre"));
            } else {
                return null;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public int Insertar(String nombre){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "INSERT INTO Editorial (nombre) VALUES ('" + nombre + "');";
            return stmt.executeUpdate(sql);
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Actualizar(int id, String nombre){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "UPDATE Editorial SET nombre = '" + nombre + "' WHERE ideditorial = " + id + ";";
            return stmt.executeUpdate(sql);
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Eliminar(int id){
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            
            // Verificar que no existan libros asociados a la editorial
            ResultSet rsCount = stmt.executeQuery("SELECT COUNT(*) FROM libro WHERE ideditorial = " + id + ";");
            rsCount.first();
                
            
            int count = rsCount.getInt(0);

            if (count > 0){
                return 0;
            } else {
                String sql = "DELETE Editorial Where ideditorial = " + id + ";";
                return stmt.executeUpdate(sql);
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
}
