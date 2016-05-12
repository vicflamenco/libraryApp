package DAL;

import Modelos.Prestamo;
import Modelos.Reserva;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservasRepositorio {
    
    private final Persistencia _persistencia;
    
    public ReservasRepositorio(){
        this._persistencia = new Persistencia();
    }
    
    public List<Reserva> Leer(){
        
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String currentDateTime = dateFormat.format(new java.util.Date());
		
            String sql = "SELECT r.*, l.titulo titulo, a.nombre autor,"
                            + " e.nombre editorial"
                            + " FROM reserva r"
                            + " INNER JOIN libro l on l.idLibro = r.idLibro"
                            + " INNER JOIN editorial e on e.idEditorial = l.idEditorial"
                            + " INNER JOIN autor a on a.idAutor = l.idAutor"
                            + " WHERE idUsuario='vicflamenco' "
                            + " AND fecha_expiracion > '" + currentDateTime + "';";
            
            Statement stmt = this._persistencia.obtenerSentencia();
            ResultSet rs = stmt.executeQuery(sql);
            List<Reserva> lstReservas = new ArrayList<>();
            while (rs.next()){
                lstReservas.add(
                    new Reserva(
                            rs.getInt("idReserva"),
                            rs.getDate("fecha_reserva"),
                            rs.getDate("fecha_expiracion"),
                            rs.getInt("idLibro_interno"),
                            rs.getString("idLibro"),
                            rs.getString("idUsuario"),
                            rs.getString("titulo"),
                            rs.getString("editorial"),
                            rs.getString("autor")
                    ));
            }
            this._persistencia.cerrarConexion();
            return lstReservas;
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }
    
    public boolean Cancelar(int idReserva, int idLibro_interno){
        try {
            Statement stmt = this._persistencia.obtenerSentencia();

            String sqlDelete = "DELETE FROM reserva WHERE idReserva = " + idReserva + ";";
            String sqlUpdate = "UPDATE libro_inventario SET estado = 'disponible'"
                            + " WHERE idLibro_interno = " + idLibro_interno + ";"; 


            int resultDelete = stmt.executeUpdate(sqlDelete);
            int resultUpdate = stmt.executeUpdate(sqlUpdate);
            
            this._persistencia.cerrarConexion();
            return resultDelete > 0 && resultUpdate > 0;
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return false;
        }
    }
    
    public boolean EfectuarPrestamo(Reserva reserva){
        try {
            
            Date currentDate = new Date();
            Calendar c = Calendar.getInstance(); 
            c.setTime(currentDate); 
            c.add(Calendar.DATE, 1);
            Date expirationDate = c.getTime();

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String currentDateTime = dateFormat.format(currentDate);
            String expirationDateTime = dateFormat.format(expirationDate);
            
            Statement stmt = this._persistencia.obtenerSentencia();
            String sqlInsert = "INSERT INTO prestamo(idlibro_interno,idlibro,idusuario,"
                    + "fecha_prestamo,fecha_expiracion,fecha_devolucion,multa_monto,"
                    + "multa_pagada) VALUES ("
                    + reserva.getIdLibro_interno() + ",'" + reserva.getIdLibro() + "','"
                    + reserva.getIdUsuario() + "','" + currentDateTime + "','"
                    + expirationDateTime + "',null,0,false);";
            
            String sqlUpdate = "UPDATE libro_inventario SET estado = 'prestado' "
                    + " WHERE idlibro_interno = " + reserva.getIdLibro_interno() + ";";
            
            String sqlDelete = "DELETE FROM reserva WHERE idReserva = " + reserva.getIdReserva() + ";";
            
            int resultInsert = stmt.executeUpdate(sqlInsert);
            int resultUpdate = stmt.executeUpdate(sqlUpdate);
            int resultDelete = stmt.executeUpdate(sqlDelete);
            
            this._persistencia.cerrarConexion();
            
            return resultInsert > 0 && resultUpdate > 0 && resultDelete > 0;
            
        } catch (Exception e){
            System.out.println("Error en consulta: " + e.getMessage());
            return false;
        }
    }
}
