package Modelos;

import java.sql.Date;

public class Prestamo {
    
    private int idPrestamo;
    private int idLibro_interno;
    private int idLibro;
    private int idUsuario;
    
    private Date fecha_prestamo;
    private Date fecha_expiracion;
    private Date fecha_devolucion;
    
    private Double multa_monto;
    private boolean multa_pagada;
    
    public Prestamo(int idPrestamo, int idLibro_interno, int idLibro,
            int idUsuario, Date fecha_prestamo, Date fecha_expiracion,
            Date fecha_devolucion, Double multa_monto, boolean multa_pagada){
        
        this.idPrestamo = idPrestamo;
        this.idLibro_interno = idLibro_interno;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_expiracion = fecha_expiracion;
        this.fecha_devolucion = fecha_devolucion;
        this.multa_monto = multa_monto;
        this.multa_pagada = multa_pagada;
        
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdLibro_interno() {
        return idLibro_interno;
    }

    public void setIdLibro_interno(int idLibro_interno) {
        this.idLibro_interno = idLibro_interno;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public Double getMulta_monto() {
        return multa_monto;
    }

    public void setMulta_monto(Double multa_monto) {
        this.multa_monto = multa_monto;
    }

    public boolean isMulta_pagada() {
        return multa_pagada;
    }

    public void setMulta_pagada(boolean multa_pagada) {
        this.multa_pagada = multa_pagada;
    }
}
