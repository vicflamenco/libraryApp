package DAL;

import Modelos.Prestamo;
import java.sql.*;
import java.util.*;

public class PrestamosRepositorio {
    
    private final Persistencia _persistencia;
    
    public PrestamosRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Prestamo> Leer(){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM prestamo";
            ResultSet rs = stmt.executeQuery(sql);
            List<Prestamo> lstPrestamos = new ArrayList<>();
            while (rs.next()){
                lstPrestamos.add(
                        new Prestamo(
                                rs.getInt("idprestamo"),
                                rs.getInt("idlibro_interno"), 
                                rs.getInt("idlibro"),
                                rs.getInt("idusuario"), 
                                rs.getDate("fecha_prestamo"),
                                rs.getDate("fecha_expiracion"),
                                rs.getDate("fecha_devolucion"),
                                rs.getDouble("multa_monto"), 
                                rs.getBoolean("multa_pagada")
                        ));
            }
            this._persistencia.cerrarConexion();
            return lstPrestamos;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public Prestamo Leer(String id){
        
        try {
            Statement stmt = this._persistencia.obtenerSentencia();
            String sql = "SELECT * FROM Prestamo WHERE idprestamo = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            this._persistencia.cerrarConexion();
            if (rs.first()){
                return new Prestamo(
                        rs.getInt("idprestamo"),
                        rs.getInt("idlibro_interno"), 
                        rs.getInt("idlibro"),
                        rs.getInt("idusuario"), 
                        rs.getDate("fecha_prestamo"),
                        rs.getDate("fecha_expiracion"),
                        rs.getDate("fecha_devolucion"),
                        rs.getDouble("multa_monto"), 
                        rs.getBoolean("multa_pagada")
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
