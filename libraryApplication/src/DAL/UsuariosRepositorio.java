package DAL;

import Modelos.Usuario;
import java.sql.*;
import java.util.*;

public class UsuariosRepositorio {
    
    private final Persistencia _persistencia;
    
    public UsuariosRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Usuario> Leer(){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM Usuario";
            ResultSet rs = stmt.executeQuery(sql);
            List<Usuario> lstUsuarios = new ArrayList<>();
            while (rs.next()){
                lstUsuarios.add(
                        new Usuario(
                                rs.getString("idusuario"), 
                                rs.getString("nombres"), 
                                rs.getString("clave"),
                                rs.getString("correo"),
                                rs.getBoolean("activo")
                        ));
            }
            this._persistencia.cerrarConexion();
            return lstUsuarios;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public Usuario Leer(String id){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM usuario WHERE idusuario = '" + id + "';";
            ResultSet rs = stmt.executeQuery(sql);
            
            this._persistencia.cerrarConexion();
            if (rs.first()){
                return new Usuario(
                    rs.getString("idusuario"), 
                    rs.getString("nombres"), 
                    rs.getString("clave"),
                    rs.getString("correo"),
                    rs.getBoolean("activo"));
            } else {
                return null;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public int Insertar(Usuario usuario){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "INSERT INTO usuario (idusuario,nombres,clave,correo,activo) VALUES ('";
            sql += usuario.getIdUsuario() + "','" + usuario.getNombres() + "','" + usuario.getClave();
            sql += "','" + usuario.getCorreo() + "'," + usuario.isActivo() + ");";
            int result = stmt.executeUpdate(sql);
            this._persistencia.cerrarConexion();
            return result;
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Actualizar(Usuario usuario){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "UPDATE Usuario SET nombres = '" + usuario.getNombres();
            sql += "', clave = '" + usuario.getClave();
            sql += "', correo = '" + usuario.getCorreo();
            sql += "', activo = " + usuario.isActivo();
            sql += " WHERE idusuario = '" + usuario.getIdUsuario() + "';";
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
            
            ResultSet rsCountRoles = stmt.executeQuery("SELECT COUNT(*) FROM usuario_rol WHERE idusuario = '" + id + "';");
            rsCountRoles.first();
            
            ResultSet rsCountPrestamos = stmt.executeQuery("SELECT COUNT(*) FROM prestamo WHERE idusuario = '" + id + "';");
            rsCountPrestamos.first();
            
            int countRoles = rsCountRoles.getInt(0);
            int countPrestamos = rsCountPrestamos.getInt(0);

            if (countRoles > 0 || countPrestamos > 0){
                this._persistencia.cerrarConexion();
                return 0;
            } else {
                String sql = "DELETE usuario Where idusuario = " + id + ";";
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
