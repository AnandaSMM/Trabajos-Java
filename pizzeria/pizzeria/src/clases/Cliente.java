package clases;
public class Cliente extends Persona {
    private String direccion;

    public Cliente(String nombre, String telefono, String email, String dir) {
        super(nombre, telefono, email);
        this.direccion = dir;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

    
}
