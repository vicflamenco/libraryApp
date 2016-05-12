package DAL;

import Modelos.Prestamo;
import Modelos.Reserva;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PrestamosRepositorio {
    
    private final Persistencia _persistencia;
    
    public PrestamosRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Prestamo> Leer(){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT p.*, l.titulo titulo, a.nombre autor,"
                + " (CASE"
                + "     WHEN fecha_devolucion is null THEN (SELECT 0)"
                + "     WHEN DATEDIFF(fecha_devolucion, fecha_expiracion) > 0 THEN (SELECT DATEDIFF(fecha_devolucion, fecha_expiracion) * 0.25)"
                + "     ELSE (SELECT 0)"
                + " END) multa_calculada"
                + " FROM prestamo p INNER JOIN libro l on l.idLibro = p.idLibro"
                + " INNER JOIN autor a ON a.idAutor = l.idAutor;";
            ResultSet rs = stmt.executeQuery(sql);
            List<Prestamo> lstPrestamos = new ArrayList<>();
            while (rs.next()){
                lstPrestamos.add(
                        new Prestamo(
                                rs.getInt("idprestamo"),
                                rs.getInt("idlibro_interno"),
                                rs.getString("idlibro"),
                                rs.getString("idusuario"), 
                                rs.getDate("fecha_prestamo"),
                                rs.getDate("fecha_expiracion"),
                                rs.getDate("fecha_devolucion"),
                                rs.getDouble("multa_monto"), 
                                rs.getBoolean("multa_pagada"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getDouble("multa_calculada")
                        ));
            }
            this._persistencia.cerrarConexion();
            return lstPrestamos;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public boolean Devolucion(int idPrestamo, int idLibro_interno){
        try {
            
            Date currentDate = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String currentDateTime = dateFormat.format(currentDate);
            
            Statement stmt = this._persistencia.obtenerSentencia();
            
            String sqlUpdatePrestamo = "UPDATE prestamo SET fecha_devolucion = '" + currentDateTime + "',"
                    + " multa_monto = DATEDIFF('" + currentDateTime + "',fecha_expiracion) * 0.25,"
                    + " multa_pagada = false"
                    + " WHERE idPrestamo = " + idPrestamo + ";";
            
            String sqlUpdateInventario = "UPDATE libro_inventario SET estado = 'disponible' "
                    + " WHERE idlibro_interno = " + idLibro_interno + ";";
            
            int resultUpdatePrestamo = stmt.executeUpdate(sqlUpdatePrestamo);
            int resultUpdateInventario = stmt.executeUpdate(sqlUpdateInventario);
            
            this._persistencia.cerrarConexion();
            
            return resultUpdatePrestamo > 0 && resultUpdateInventario > 0;
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return false;
        }
    }
    
    public boolean Pago(int idPrestamo){
        try {
            
            Statement stmt = this._persistencia.obtenerSentencia();
            
            String sqlUpdatePrestamo = "UPDATE prestamo SET"
                    + " multa_pagada = true"
                    + " WHERE idPrestamo = " + idPrestamo + ";";
            
            int result = stmt.executeUpdate(sqlUpdatePrestamo);
            
            this._persistencia.cerrarConexion();
            
            return result > 0;
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return false;
        }
    }
    
    public Prestamo Leer(String id){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT p.*, l.titulo titulo, a.nombre autor"
                    + " FROM prestamo p INNER JOIN libro l on l.idLibro = p.idLibro"
                    + " INNER JOIN autor a ON a.idAutor = l.idAutor"
                    + " WHERE p.idprestamo = " + id + ";";
            ResultSet rs = stmt.executeQuery(sql);
            this._persistencia.cerrarConexion();
            if (rs.first()){
                return new Prestamo(
                        rs.getInt("idprestamo"),
                        rs.getInt("idlibro_interno"), 
                        rs.getString("idlibro"),
                        rs.getString("idusuario"), 
                        rs.getDate("fecha_prestamo"),
                        rs.getDate("fecha_expiracion"),
                        rs.getDate("fecha_devolucion"),
                        rs.getDouble("multa_monto"), 
                        rs.getBoolean("multa_pagada"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("multa_calcuada")
                );
            } else {
                return null;
            }
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public int Insertar(Prestamo prestamo) {
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "INSERT INTO prestamo (idlibro_interno,idlibro,idusuario,fecha_prestamo,";
            sql += "fecha_expiracion,fecha_devolucion,multa_monto,multa_pagada)  VALUES(";
            sql += prestamo.getIdLibro_interno() + ",";
            sql += prestamo.getIdLibro() + ",";
            sql += prestamo.getIdUsuario()+ ",'";
            sql += prestamo.getFecha_prestamo() + "','";
            sql += prestamo.getFecha_expiracion()+ "','";
            sql += prestamo.getFecha_devolucion()+ "',";
            sql += prestamo.getMulta_monto() + ",";
            sql += prestamo.isMulta_pagada() + ");";
            int result = stmt.executeUpdate(sql);
            this._persistencia.cerrarConexion();
            return result;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
    
    public int Actualizar(Prestamo prestamo){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "UPDATE prestamo SET ";
            sql += "idlibro_interno = " + prestamo.getIdLibro_interno() + ", ";
            sql += "idlibro = " + prestamo.getIdLibro() + ", ";
            sql += "idusuario = " + prestamo.getIdUsuario()+ ", '";
            sql += "fecha_prestamo = '" + prestamo.getFecha_prestamo() + "', ";
            sql += "fecha_expiracion = '" + prestamo.getFecha_expiracion()+ "', ";
            sql += "fecha_devolucion = '" + prestamo.getFecha_devolucion()+ "', ";
            sql += "multa_monto = " + prestamo.getMulta_monto() + ", ";
            sql += "multa_pagada = " + prestamo.isMulta_pagada() + "; ";
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

            String sql = "DELETE prestamo Where idprestamo = " + id + ";";

            int result = stmt.executeUpdate(sql);
            this._persistencia.cerrarConexion();
            return result;
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return -1;
        }
    }
}
