package Modelos;

import java.util.Date;

public class Reserva {
    
    private int idReserva;
    private Date fecha_reserva;
    private Date fecha_expiracion;
    private int idLibro_interno;
    private String idLibro;
    private String idUsuario;

    private String tituloLibro;
    private String nombreEditorial;
    private String nombreAutor;

    public Reserva(int idReserva, Date fecha_reserva, Date fecha_expiracion, 
            int idLibro_interno, String idLibro, String idUsuario, 
            String tituloLibro, String nombreEditorial, String nombreAutor){

        this.idReserva = idReserva;
        this.fecha_reserva = fecha_reserva;
        this.fecha_expiracion = fecha_expiracion;
        this.idLibro_interno = idLibro_interno;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.tituloLibro = tituloLibro;
        this.nombreEditorial = nombreEditorial;
        this.nombreAutor = nombreAutor;
    }

    public String getTituloLibro() {
            return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
            this.tituloLibro = tituloLibro;
    }

    public String getNombreEditorial() {
            return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
            this.nombreEditorial = nombreEditorial;
    }

    public String getNombreAutor() {
            return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
            this.nombreAutor = nombreAutor;
    }

    public int getIdReserva() {
            return idReserva;
    }

    public void setIdReserva(int idReserva) {
            this.idReserva = idReserva;
    }

    public Date getFecha_reserva() {
            return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
            this.fecha_reserva = fecha_reserva;
    }

    public Date getFecha_expiracion() {
            return fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
            this.fecha_expiracion = fecha_expiracion;
    }

    public int getIdLibro_interno() {
            return idLibro_interno;
    }

    public void setIdLibro_interno(int idLibro_interno) {
            this.idLibro_interno = idLibro_interno;
    }

    public String getIdLibro() {
            return idLibro;
    }

    public void setIdLibro(String idLibro) {
            this.idLibro = idLibro;
    }

    public String getIdUsuario() {
            return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
    }
}
