package DAL;

import Modelos.Rol;
import Modelos.Usuario;
import Util.Cipher;
import java.sql.*;
import java.util.*;

public class UsuariosRepositorio {
    
    private final Persistencia _persistencia;
    
    public UsuariosRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Usuario> Leer(){
        
        try {          
            _persistencia.abrirConexion();
            ResultSet rs = _persistencia.ejecutarConsulta( "SELECT * FROM Usuario;");
            List<Usuario> lstUsuarios = new ArrayList<>();
            while (rs.next()){
                lstUsuarios.add(
                        new Usuario(
                                rs.getString("idusuario"), 
                                rs.getString("nombres"), 
                                rs.getString("clave"),
                                rs.getString("correo"),
                                rs.getBoolean("activo"),
                                TieneRol(rs.getString("idusuario"),1),
                                TieneRol(rs.getString("idusuario"),2),
                                TieneRol(rs.getString("idusuario"),3)
                        ));
            }
            return lstUsuarios;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
        finally{
            _persistencia.cerrarConexion();
        }
    }
    
    public Usuario Leer(String id){
        
        try {
            _persistencia.abrirConexion();
            ResultSet rs = _persistencia.ejecutarConsulta("SELECT * FROM usuario WHERE idusuario = '" + id + "';");
            
            if (rs.first()){
                return new Usuario(
                    rs.getString("idusuario"), 
                    rs.getString("nombres"), 
                    rs.getString("clave"),
                    rs.getString("correo"),
                    rs.getBoolean("activo"),
                    TieneRol(rs.getString("idusuario"),1),
                    TieneRol(rs.getString("idusuario"),2),
                    TieneRol(rs.getString("idusuario"),3)
                );
            } else {
                return null;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
        finally{
            _persistencia.cerrarConexion();
        }
    }
    
    public int Insertar(Usuario usuario){
        
        try {
            String sql = "INSERT INTO usuario (idusuario,nombres,clave,correo,activo) VALUES ('";
            sql += usuario.getIdUsuario() + "','" + usuario.getNombres() + "','" + Cipher.getSecurePassword(usuario.getClave());
            sql += "','" + usuario.getCorreo() + "'," + usuario.isActivo() + ");";
            int result = _persistencia.ejectutarSentencia(sql);
            
            if (usuario.isAdmin()) AsignarRol(usuario.getIdUsuario(), 1); else QuitarRol(usuario.getIdUsuario(), 1);
            if (usuario.isOperator()) AsignarRol(usuario.getIdUsuario(), 2); else QuitarRol(usuario.getIdUsuario(), 2);
            if (usuario.isUser()) AsignarRol(usuario.getIdUsuario(), 3); else QuitarRol(usuario.getIdUsuario(), 3);
            
            return result;
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            
            return -1;
        }
    }
    
    public int Actualizar(Usuario usuario){
        
        try {
            String sql = "UPDATE Usuario SET nombres = '" + usuario.getNombres();
            sql += (usuario.getClave() != null) ?  "', clave = '" + Cipher.getSecurePassword(usuario.getClave()) : "";
            sql += "', correo = '" + usuario.getCorreo();
            sql += "', activo = " + usuario.isActivo();
            sql += " WHERE idusuario = '" + usuario.getIdUsuario() + "';";

            int result = _persistencia.ejectutarSentencia(sql);
            
            if (usuario.isAdmin()) AsignarRol(usuario.getIdUsuario(), 1); else QuitarRol(usuario.getIdUsuario(), 1);
            if (usuario.isOperator()) AsignarRol(usuario.getIdUsuario(), 2); else QuitarRol(usuario.getIdUsuario(), 2);
            if (usuario.isUser()) AsignarRol(usuario.getIdUsuario(), 3); else QuitarRol(usuario.getIdUsuario(), 3);
            
            return result;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            
            return -1;
        }
    }
    
    public int Eliminar(String id){
        try {
            _persistencia.abrirConexion();
            
            ResultSet rsCountRoles = _persistencia.ejecutarConsulta("SELECT COUNT(*) FROM usuario_rol WHERE idusuario = '" + id + "';");
            rsCountRoles.first();
            System.out.println("a");
            ResultSet rsCountPrestamos = _persistencia.ejecutarConsulta("SELECT COUNT(*) FROM prestamo WHERE idusuario = '" + id + "';");
            rsCountPrestamos.first();
            System.out.println("b");
            
            int countRoles = rsCountRoles.getInt(1);
            int countPrestamos = rsCountPrestamos.getInt(1);

            this._persistencia.cerrarConexion();
            
            System.out.println("c");
            if (countRoles > 0 || countPrestamos > 0){    
                return 0;
            } else {
                String sql = "DELETE FROM usuario WHERE idusuario = '" + id + "';";
                int result = _persistencia.ejectutarSentencia(sql);
                
                return result;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public boolean AsignarRol(String usuarioId, int rolId){
        
        try {
            _persistencia.abrirConexion();
            String sql = "SELECT COUNT(*) FROM usuario_rol WHERE idusuario = '" + usuarioId;
            sql += "' AND idrol = " + rolId + ";";

            ResultSet rsCount = _persistencia.ejecutarConsulta(sql);
            boolean existe = rsCount.first() && rsCount.getInt(1) > 0;
            
            _persistencia.cerrarConexion();
            
            if (existe){
                return true;
            } else {
                sql = "INSERT INTO usuario_rol(idusuario, idrol) VALUES ('";
                sql += usuarioId + "'," + rolId + ");";
                
                boolean result = _persistencia.ejectutarSentencia(sql) > 0;
                
                return result;
            }

        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return false;
        }
    }
    
    public boolean QuitarRol(String usuarioId, int rolId){
        
        try {
            String sql = "SELECT COUNT(*) FROM usuario_rol WHERE idusuario = '" + usuarioId;
            sql += "' AND idrol = " + rolId + ";";

            ResultSet rsCount = _persistencia.ejecutarConsulta(sql);
            boolean existe = rsCount.first() && rsCount.getInt(1) > 0;
            
            _persistencia.cerrarConexion();
            
            if (!existe){
                return true;
            } else {
                sql = "DELETE usuario_rol WHERE idusuario = '";
                sql += usuarioId + "' AND idrol = " + rolId + ";";
                boolean result = _persistencia.ejectutarSentencia(sql) > 0;
                
                return result;
            }

        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return false;
        }
    }
    
    public boolean TieneRol(String usuarioId, int rolId){
        boolean result = false;
        try {
//            _persistencia.abrirConexion();
            String sql = "SELECT COUNT(*) FROM usuario_rol WHERE idusuario = '" + usuarioId;
            sql += "' AND idrol = " + rolId + ";";

            ResultSet rsCount = _persistencia.ejecutarConsulta(sql);
            
            result =  rsCount.first() && rsCount.getInt(1) > 0;
        } catch (Exception e) {
            System.out.println("Error verificando rol asignado...");
        }
        finally{
//            _persistencia.cerrarConexion();
        }
        
        return result;
    }
}
