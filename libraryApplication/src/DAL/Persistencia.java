package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Persistencia {
    
    private Connection con;
    private String connectionString;
    
    public Persistencia(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "root");
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            System.out.println("Error de conexión a la BD: " + e.getMessage());
        }
    }
    
    public ResultSet ejecutarConsulta(String sql){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
    
    public int ejectutarSentencia(String sql){
        try {
            abrirConexion();
            Statement stmt = con.createStatement();
            int resultado = stmt.executeUpdate(sql);
            
            cerrarConexion();
            
            return resultado;
        } catch (Exception e) {
            cerrarConexion();
            
            return -1;
        }
    }
    
    public Statement obtenerSentencia() {
        try {
            return this.con.createStatement();    
        } catch (Exception e){
            System.out.println("Error al obtener objeto Statement: " + e.getMessage());
            return null;
        }
        
    }
    
    public void cerrarConexion(){
        try {
           if (!this.con.isClosed()) {
               this.con.close();
           }
        } catch (Exception e) {
            System.out.println("Error al cerrar la BD: " + e.getMessage());
        }
    }
    
    public void abrirConexion() throws SQLException{
        if (con != null && !con.isClosed())
        {
            return;
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "root");
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            System.out.println("Error de conexión a la BD: " + e.getMessage());
        }
    }

    /**
     * @return the connectionString
     */
    public String getConnectionString() {
        return connectionString;
    }

    /**
     * @param connectionString the connectionString to set
     */
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
}
