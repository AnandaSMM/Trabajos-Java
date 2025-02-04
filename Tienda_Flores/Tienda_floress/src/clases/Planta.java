package clases;

public class Planta extends Producto implements Comparable <Planta>{

    public Planta(String id, String nombre, double precio, String descripcion) {
        super(id, nombre, precio, descripcion);
        
    }


   @Override
   public String pasarFichero() {
       return super.pasarFichero();
   }
    
    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public int compareTo(Planta o) {
       Planta nueva=(Planta) o;
       if(this.precio < nueva.precio){
            return -1;
        }else if (this.precio >nueva.precio){
            return 1;
        }else{
            return this.nombre.compareTo(nueva.nombre);
        }
    }

}