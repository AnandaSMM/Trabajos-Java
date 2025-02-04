package clases;
public class Asignacion {
    Zona zonas;
    Trabajador trabajadores; 


    public Asignacion(Zona zonas, Trabajador trabajadores) {
        this.zonas = zonas;
        this.trabajadores = trabajadores;
    }


    public Zona getZonas() {
        return zonas;
    }


    public void setZonas(Zona zonas) {
        this.zonas = zonas;
    }


    public Trabajador getTrabajadores() {
        return trabajadores;
    }


    public void setTrabajadores(Trabajador trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public String toString() {

        return "Trabajador: "+trabajadores.getNombre()+"\tDni: "+trabajadores.getDni()+
        "\nZonas: "+zonas.getNombre();
    }



    
}
