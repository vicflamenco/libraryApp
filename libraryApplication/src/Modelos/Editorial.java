package Modelos;

public class Editorial {
    
    private int idEditorial;
    private String nombre;
    
    public Editorial(int id, String nombre){
        this.idEditorial = id;
        this.nombre = nombre;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
