package DAL;

import Modelos.Rol;
import java.sql.*;
import java.util.*;

public class RolesRepositorio {
    
    private final Persistencia _persistencia;
    
    public RolesRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Rol> Leer(){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM rol";
            ResultSet rs = stmt.executeQuery(sql);
            List<Rol> lstRoles = new ArrayList<>();
            while (rs.next()){
                lstRoles.add(new Rol(rs.getInt("idrol"), rs.getString("nombre"), rs.getString("descripcion")));
            }
            return lstRoles;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public Rol Leer(String id){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM Rol WHERE idrol = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.first()){
                return new Rol(rs.getInt("idrol"), rs.getString("nombre"), rs.getString("descripcion"));
            } else {
                return null;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public int Insertar(Rol rol){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "INSERT INTO Rol (nombre, descripcion) VALUES ('" + rol.getNombre();
            sql += "','" + rol.getDescripcion() + "');";
            return stmt.executeUpdate(sql);
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Actualizar(Rol rol){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "UPDATE rol SET nombre = '" + rol.getNombre() + "', descripcion = '";
            sql += rol.getDescripcion() + "' WHERE idrol = " + rol.getIdRol() + ";";
            return stmt.executeUpdate(sql);
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Eliminar(int id){
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            ResultSet rsCount = stmt.executeQuery("SELECT COUNT(*) FROM usuario_rol WHERE idrol = " + id + ";");
            rsCount.first();
                
            int count = rsCount.getInt(0);

            if (count > 0){
                return 0;
            } else {
                String sql = "DELETE Rol Where idrol = " + id + ";";
                return stmt.executeUpdate(sql);
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
}
