package clases;

public class Producto {
    
    String id;
    String nombre;
    double precio;
    String descripcion;

    public Producto(String id, String nombre, double precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Producto() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String pasarFichero(){
        return this.id+"#"+this.nombre+"#"+this.precio+"#"+this.descripcion;
    }


    public String catalogo(){
        return "Nombre : "+this.nombre+"\nPrecio : "+this.precio+"\nDescripcion : "+this.descripcion;
    }

    @Override
    public String toString() {
        return "ID : "+this.id+"\nNombre : "+this.nombre+"\nPrecio : "+this.precio+"\nDescripcion : "+this.descripcion;
    }
    
    
}
