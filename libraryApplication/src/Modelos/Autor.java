package Modelos;

public class Autor {
    
    private int idAutor;
    private String nombre;
    private String acerca_de;
    
    public Autor(int id, String nombre, String acerca_de){
        this.idAutor = id;
        this.nombre = nombre;
        this.acerca_de = acerca_de;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
    }
}
