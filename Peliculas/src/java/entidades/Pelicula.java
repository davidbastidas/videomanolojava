package entidades;

/**
 *
 * @author YOGA 520
 */
public class Pelicula {
    private int id;
    private String nombre;
    private String descripcion;
    private String director;
    private String genero;
    private float precio;
    private int cantidad;
    private String caratula;

    public Pelicula(int id, String nombre, String descripcion, String director, String genero, float precio, int cantidad, String caratula) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.director = director;
        this.genero = genero;
        this.precio = precio;
        this.cantidad = cantidad;
        this.caratula = caratula;
    }

    public Pelicula(String nombre, String descripcion, String director, String genero, float precio, int cantidad, String caratula) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.director = director;
        this.genero = genero;
        this.precio = precio;
        this.cantidad = cantidad;
        this.caratula = caratula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }
    
}
