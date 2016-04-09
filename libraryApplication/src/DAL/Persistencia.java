package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Persistencia {
    
    private Connection con;
    
    public Persistencia(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            System.out.println("Error de conexión a la BD: " + e.getMessage());
        }
    }
    
    public Statement obtenerSentencia() throws SQLException{
        return this.con.createStatement();
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
}
