package Modelos;

public class Usuario {
    
    private String idUsuario;
    private String nombres;
    private String clave;
    private String correo;
    private boolean activo;
    
    public Usuario(String id, String nombres, String clave, String correo, boolean activo){
        this.idUsuario = id;
        this.nombres = nombres;
        this.clave = clave;
        this.correo = correo;
        this.activo = activo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
