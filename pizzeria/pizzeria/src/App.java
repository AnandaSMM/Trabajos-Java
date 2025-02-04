

import java.util.Scanner;

import clases.Cliente;
import clases.Empleado;
import clases.Pedido;
import clases.Pizza;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        Empleado john = new Empleado("John", "123456789", "a@s.com");
        john.fichar();
        
        Cliente cliente1 = new Cliente("Pepe", "123456789", "a@s.com", "c/123");
        
        Pizza p1 = new Pizza("Margarita", ", extra de mozarella", 10.0, "1");
        Pizza p2 = new Pizza("Pepperoni", ", pepperoni", 12.0, "2");
        Pizza p3 = new Pizza("Hawaiana", ", jamon, pina", 14.0, "3");
        
        System.out.println("---menu------------------------------------------------------------------ ");
        
        Pedido pedidoUno=new Pedido(p1, cliente1, john);
        pedidoUno.addPizzas(p1);
        pedidoUno.addPizzas(p2);
        pedidoUno.addPizzas(p3);
        
        Pizza elegida = menu(cliente1, pedidoUno);
        mensajesOtra(cliente1 ,pedidoUno);
        mensajesCobrar(pedidoUno, john, elegida);
        double total = pedidoUno.importeTotalDePizzas();
        pedidoUno.factura();
        System.out.println("Total:\t\t\t"+total);
        System.out.println("-------------------------------------------");
        sc.close();
    }


    public static Pizza menu(Cliente cl, Pedido ped) {

        ped.mostrarPizzas();
        System.out.println("Elige una pizza: ");
        String eleccion = sc.next();
        Pizza elegida = ped.elegirPizza(eleccion);
        
        if (elegida == null) {
            System.out.println("Pizza no encontrada. Por fvaor elige otra pizza.");
            elegida = menu(cl,ped);
            
        }
        ped.addPizzasPedidas(elegida);
        return elegida;
       
    }

    public static void mensajesCobrar( Pedido ped, Empleado emple, Pizza pizza){
        System.out.println("Desea pagar con (e)fectivo o con (t)arjeta?");
        String tipoDePago=sc.next();
        
        if(tipoDePago.equals("e")){

            double total = ped.importeTotalDePizzas();
            System.out.println("Ingrese: "+ total);
            double dinero=sc.nextDouble();

            if(emple.cobrar(dinero, total)){
                System.out.println("Pedido cobrado");
            }else{
                mensajesCobrar(ped ,emple, pizza);
            }

        }else{
            System.out.println("Pedido cobrado con tarjeta.");
        }
    }

    public static void mensajesOtra(Cliente cl, Pedido ped){
        System.out.println("Quieres otra? (s)i o (n)o ");
        String otra = sc.next();

        if (otra.equals("s")) {
            menu(cl, ped);
            mensajesOtra(cl, ped);     
        }else{
            System.out.println("Preparando su pedido");
        }
        
    }
}

