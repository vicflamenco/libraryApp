package DAL;

import Modelos.Rol;
import Modelos.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioRolesRepositorio {
    
    private final Persistencia _persistencia;
    
    public UsuarioRolesRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public boolean AsignarRol(Usuario usuario, Rol rol){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM usuario_rol WHERE idusuario = '" + usuario.getIdUsuario();
            sql += "' AND idrol = '" + rol.getIdRol() + "';";

            ResultSet rsCount = stmt.executeQuery(sql);
            rsCount.first();
            
            if (rsCount.getInt(0) > 0){
                return false;
            } else {
                sql = "INSERT INTO usuario_rol(idusuario, idrol) VALUES ('";
                sql += usuario.getIdUsuario() + "','" + rol.getIdRol() + ");";
                return stmt.executeUpdate(sql) > 0;
            }

        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return false;
        }
    }
    
    public boolean QuitarRol(Usuario usuario, Rol rol){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM usuario_rol WHERE idusuario = '" + usuario.getIdUsuario();
            sql += "' AND idrol = '" + rol.getIdRol() + "';";

            ResultSet rsCount = stmt.executeQuery(sql);
            rsCount.first();
            
            if (rsCount.getInt(0) <= 0){
                return false;
            } else {
                sql = "DELETE usuario_rol WHERE idusuario = '";
                sql += usuario.getIdUsuario() + "' AND idrol = '" + rol.getIdRol() + ";";
                return stmt.executeUpdate(sql) > 0;
            }

        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return false;
        }
    }
}
