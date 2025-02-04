package clases;
import java.util.Date;

public class Animal {
    
    private String codAnimal;
    private String nombre;
    private String espacie;
    private Date fechaNaci;
    Instalacion jaula;

    
    public Animal(String codAnimal, String nombre, String espacie, Date fechaNaci) {
        this.codAnimal = codAnimal;
        this.nombre = nombre;
        this.espacie = espacie;
        this.fechaNaci = fechaNaci;
    }


    public String getCodAnimal() {
        return codAnimal;
    }


    public void setCodAnimal(String codAnimal) {
        this.codAnimal = codAnimal;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEspacie() {
        return espacie;
    }


    public void setEspacie(String espacie) {
        this.espacie = espacie;
    }


    public Date getFechaNaci() {
        return fechaNaci;
    }


    public void setFechaNaci(Date fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public String meterdatos(){
        return this.codAnimal+"#"+this.nombre+"#"+this.espacie+"#"+this.fechaNaci;
    }

    @Override
    public String toString() {
        
        return this.nombre+"es un "+this.espacie+" nacido en "+this.fechaNaci+
        "(Codigo identificativo "+this.codAnimal+" ) y vive en la instalacion nº "+
        this.jaula.getId();
    }

    
}
