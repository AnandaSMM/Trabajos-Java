import java.util.ArrayList;
import java.util.List;

import control.Zoologico;
import clases.*;

public class App {
  public static void main(String[] args) throws Exception {
    Zona zn=new Zona("2508", "felinos", 28500);
    Zona zna=new Zona("3508", "Mamiferos", 28200);

    Instalacion ins=new Instalacion(null, null, 0);
    Animal ani=new Animal(null, null, null, null);
    Trabajador trabj=new Trabajador("paola", "maria", "54697709y", "Carnivoros");
    Instalacion insta=new Instalacion(null, null, 0);
    Asignacion asig=new Asignacion(zn, trabj);
    Asignacion asigna=new Asignacion(zna, trabj);

    Zoologico zoo=new Zoologico("Magallanes");
    zoo.agregarAsignacion(asigna);
    zoo.agregarAsignacion(asig);
    //zoo.imprimirAsignacion("54697709y");

    
      String n = "polaco madrastro efe";
      String[] d = n.split(" ");
      String nueva = "";
      for (String st : d) {
        
        if (st.length() >= 5) {
            char[] s = st.toCharArray();
            for (int i = s.length - 1; i >= 0; i--) {
                nueva = nueva + s[i];
            }
        }else{
          nueva= nueva+ st;
        }

        nueva=nueva+" ";
      }
      System.out.println(nueva);  
    }

}

