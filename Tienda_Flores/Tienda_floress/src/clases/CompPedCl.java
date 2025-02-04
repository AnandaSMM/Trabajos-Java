package clases;

import java.util.Comparator;

public class CompPedCl implements Comparator <Pedido>{
    @Override
    public int compare(Pedido o1, Pedido o2) {
       String nombreUno=o1.getCl().getNombre();
       String nombreDos=o2.getCl().getNombre();
       return nombreUno.compareTo(nombreDos);
    }
    
}
