package DAL;

import Modelos.Autor;
import java.sql.*;
import java.util.*;

public class AutoresRepositorio {
    
    private final Persistencia _persistencia;
    
    public AutoresRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Autor> Leer(){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM Autor";
            ResultSet rs = stmt.executeQuery(sql);
            List<Autor> lstAutores = new ArrayList<>();
            while (rs.next()){
                lstAutores.add(new Autor(rs.getInt("idautor"), rs.getString("nombre"), rs.getString("acerca_de")));
            }
            this._persistencia.cerrarConexion();
            return lstAutores;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public Autor Leer(String id){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM autor WHERE idautor = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            
            this._persistencia.cerrarConexion();
            if (rs.first()){
                return new Autor(rs.getInt("idautor"), rs.getString("nombre"), rs.getString("acerca_de"));
            } else {
                return null;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public int Insertar(String nombre, String acerca_de){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "INSERT INTO Autor (nombre, acerca_de) VALUES ('" + nombre + "','" + acerca_de + "');";
            int result = stmt.executeUpdate(sql);
            this._persistencia.cerrarConexion();
            return result;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Actualizar(int id, String nombre, String acerca_de){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "UPDATE Autor SET nombre = '" + nombre + "', acerca_de = '";
            sql += acerca_de + "' WHERE idautor = " + id + ";";
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
            
            ResultSet rsCount = stmt.executeQuery("SELECT COUNT(*) FROM libro WHERE idautor = " + id + ";");
            rsCount.first();
            
            int count = rsCount.getInt(0);

            if (count > 0){
                this._persistencia.cerrarConexion();
                return 0;
            } else {
                String sql = "DELETE Autor Where idautor = " + id + ";";
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
