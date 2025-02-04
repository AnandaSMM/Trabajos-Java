package clases;

import java.util.ArrayList;
import java.util.List;

public class Zona{

    private String codigo;
    private String nombre;
    private int metrosCuadrados;


    public Zona(String codigo, String nombre, int metrosCuadrados) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.metrosCuadrados = metrosCuadrados;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }


    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public String meterFichero(){
        return this.codigo+"#"+this.nombre+"#"+ this.metrosCuadrados;
    }

    @Override
    public String toString() {
        return "Codigo: \t"+this.codigo+"\nNombre: \t"+this.nombre+"\nMetros cuadrados: \t"+this.metrosCuadrados;
    }

    
}