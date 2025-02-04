package clases;
import java.util.ArrayList;
import java.util.List;

public class Trabajador {
    
    String nombre;
    String appelllidos;
    String dni;
    String especialidad;

    public Trabajador(String nombre, String appelllidos, String dni, String especialidad) {
        this.nombre = nombre;
        this.appelllidos = appelllidos;
        this.dni = dni;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppelllidos() {
        return appelllidos;
    }

    public void setAppelllidos(String appelllidos) {
        this.appelllidos = appelllidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String meterdatos(){
        return this.nombre+"#"+this.appelllidos+"#"+this.dni+"#"+this.especialidad;
    }

    @Override
    public String toString() {
        return "Nombre: \t"+this.nombre+" "+this.appelllidos+"\nEspecialidad: \t"
        +this.especialidad+"\nDni: \t"+this.dni;
    }
    

    
    
    


}
