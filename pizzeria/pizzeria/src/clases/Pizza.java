package clases;

public class Pizza{
    
    private String nombre;
    private String numero;
    private String ingredientes;
    private double precio;
    private static final String INGREDIENTES_DEFAULT = "Salsa de tomate, mozzarella, oregano";
    
    
    
    public Pizza(String nombre, String ingredientes, double precio, String numero) {
        this.nombre = nombre;
        this.numero = numero;
        this.ingredientes = ingredientes;
        this.precio = precio;

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    

    @Override
    public String toString() {
        return "Pizza\nNombre: " + nombre + "\nNumero: " + numero + "\nIngredientes: " + INGREDIENTES_DEFAULT +" "+ingredientes + " Precio: "
                + precio + "]";
    }


}