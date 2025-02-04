package clases;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Instalacion  {
    
    private int id;
    private String descripcion;
    private Date fechaInstalacion;
    Zona zonaJaula;

    public Instalacion(String desc, Date ini, int id) {
        
        this.descripcion=desc;
        this.fechaInstalacion=ini;
        this.id=id;

    }

    

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(Date fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public String meterdatos(){
        return this.descripcion+"#"+this.fechaInstalacion+"#"+this.id;
    }

    @Override
    public String toString() {
        return "Id de la instalacion: \t"+this.id+"\nZona: \t"+zonaJaula.getNombre()+
        "\nDescripcion: "+this.descripcion;
    }

    

    
    
}
