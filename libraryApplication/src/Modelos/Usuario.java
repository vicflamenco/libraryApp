package Modelos;

public class Usuario {
    
    private String idUsuario;
    private String nombres;
    private String clave;
    private String correo;
    private boolean activo;
    private boolean admin;
    private boolean operator;
    private boolean user;
    
    public Usuario(String id, String nombres, String clave, String correo, boolean activo, boolean admin, boolean operator, boolean prestatario){
        this.idUsuario = id;
        this.nombres = nombres;
        this.clave = clave;
        this.correo = correo;
        this.activo = activo;
        this.admin = admin;
        this.operator = operator;
        this.user = prestatario;
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

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * @return the operator
     */
    public boolean isOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(boolean operator) {
        this.operator = operator;
    }

    /**
     * @return the user
     */
    public boolean isUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(boolean user) {
        this.user = user;
    }
    
   
}
