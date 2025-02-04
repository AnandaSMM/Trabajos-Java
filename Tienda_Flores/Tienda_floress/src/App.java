import java.io.File;
import java.util.Scanner;

import control.Floristeria;
import clases.*;

public class App {

    static Scanner sc=new Scanner(System.in);
    static Floristeria tienda=new Floristeria();
    static boolean encendido;

    public static void main(String[] args) throws Exception {
        File fl=new File("C:/Users/anand/OneDrive/Escritorio/Floristeria.txt");
        Flor flr=new Flor("F-502", "rosas", 20, "Flor roja");
        Arbusto arb=new Arbusto("A-102", "Ginseng", 30, "arbusto verde");
        Planta pl=new Planta("P-659", "savila", 15, "planta amarrilla");
        Cliente cl=new Cliente("Maria Hernandez", "54697709y");
        tienda.agregarArbustos(arb);
        tienda.agregarPlantas(pl);
        tienda.agregarFlores(flr);
       
        /*tienda.SacarDataProductos(fl, flr);
        tienda.SacarDataProductos(fl, pl);
        tienda.SacarDataProductos(fl, arb);*/
        menu(cl);

        

    
    //volcar el hashmap en una estructura para ordenar por cliente

        sc.close();
    }

    public static void menu(Cliente cl){
        while(!encendido){

            System.out.println("/////////////////////////////////////////////");
            System.out.println("Bienvenido a la floristeria Magallanes");
            System.out.println("1.Realizar un pedido.");
            System.out.println("2.Eliminar un pedido");
            System.out.println("3.Catalogo de productos");
            System.out.println("4.Cmabiar informacion de un pedido");
            System.out.println("5.Seguimiento del pedido.");
            System.out.println("6.Base de datos\n");
            System.out.print("Elige la opcion que desees: ");
            String opcion=sc.next();

            switch (opcion) {
                case "1"://Realizar un pedido
                    Pedido nuevo=new Pedido();
                    tienda.crearCodigo(nuevo);
                    nuevo.calcFechaPedido();
                    System.out.println("\nCreando pedido...");
                    System.out.println("Codigo del pedido:\t"+nuevo.getCodigo());
                    

                    System.out.println("\nIntroducce el id del producto :");
                    String id=sc.next();
                    Producto acomprar = tienda.buscarProducto(id);
                    if(acomprar.equals(null)){

                        System.out.println("El articulo deseado no existe, por favor compruebe el id.");
                        
                    }else{
                        nuevo=new Pedido(nuevo.getCodigo(), acomprar, cl);
                        tienda.agregarPedidos(nuevo);
                        tienda.agregarProducto(acomprar);
                        System.out.println("Agregando producto al carrito...");
                    }

                break;
                case "2"://Eliminar un pedido

                    System.out.println("\nEscribe el codigo del pedido que deseas eliminar");
                     id=sc.next();
                    Pedido aBorrar=tienda.buscarPedido(id);
                    if(aBorrar.equals(null)){
                        System.out.println("El articulo deseado no existe, por favor compruebe el id.");
                    }else{
                    tienda.eliminarPedido(aBorrar);
                    System.out.println("Pedido eliminado correctamente");
                    }

                break;
                case "3"://Catalogo de productos

                    tienda.iprimirTodo();

                break;
                case "4"://Cmabiar informacion de un pedido

                    System.out.println("\nEscribe el codigo del pedido que deseas modificar");
                    id=sc.next();
                    Pedido aCambiar=tienda.buscarPedido(id);
                    if(aCambiar.equals(null)){
                        System.out.println("El articulo deseado no existe, por favor compruebe el id.");
                    }else{
                        menuCambiarDatos(aCambiar);
                    }

                break;
                case "5"://Seguimiento de un pedido

                    System.out.println("Escribe el codigo del pedido que deseas modificar");
                    id=sc.next();
                    Pedido aSeguir=tienda.buscarPedido(id);
                    System.out.println(aSeguir.getEstado());

                break;
                case "6"://Base de datos

                    menuBaseDatos();

                break;
            
                default:
                System.out.println("Opcion deseada no encontrada, por favor elija otra");
                break;
            }
        }
    }

    public static void menuBaseDatos(){
        String opc=" ";
        while(!opc.toUpperCase().equals("E")){
            System.out.println("-----------------------------------------------");
            System.out.println("A.Cambiar el fichero de flor");
            System.out.println("B.Cambiar el fichero de Arbusto");
            System.out.println("C.Cambiar el fichero de Planta");
            System.out.println("D.Cambiar el fichero de Pedidos");
            System.out.println("E.volver");
             opc=sc.next();
            switch (opc.toUpperCase()) {
                case "A":
                    ingresarFileFlor();
                break;
                case "B":
                    ingresarFileArbusto();
                break;
                case "C":
                    ingresarFilePlanta();
                break;
                case "D":
                    ingresarFilePedido();
                break;
                case "E":
                System.out.println("Volviendo al menu principal...\n");
                break;
            
                default:
                System.out.println("opcion deseada no encontrada.");
                break;
            }
        }
    }

    public static void menuCambiarDatos(Pedido cambiar){
        String op2="";

        while(op2=="0"){
            System.out.println("1.Quitar un producto del carrito\n2.Agregar un producto al carrito");
            System.out.println("0.Volver");
            System.out.print("Elige la opcion deseada :");
             op2=sc.next();

             switch (op2) {

                case "1":

                    System.out.println("Introduzca el id del producto a quitar: ");
                    String id=sc.next();
                    tienda.quitarProducto(id);
                    System.out.println("Producto eliminado.");

                break;
                case "2":

                    System.out.println("Introduzca el id del producto a agregar: ");
                    String id2=sc.next();
                    Producto nuevo= tienda.buscarProducto(id2);
                    tienda.agregarProducto(nuevo);

                break;
                case "0":
                    System.out.println("Volviendo al menu principal...\n");
                break;
                default:
                    System.out.println("opcion deseada no encontrada.");
                break;
             }
        }
    }

    public static void ingresarFileFlor(){
        System.out.println("Introduzca el path: ");
        String path=sc.next(); 
        File fl=new File(path);
        tienda.meterDatosFlor(fl);
    }

    public static void ingresarFilePlanta(){
        System.out.println("Introduzca el path: ");
        String path=sc.next(); 
        File fl=new File(path);
        tienda.meterDatosPlanta(fl);
    }

    public static void ingresarFileArbusto(){
        System.out.println("Introduzca el path: ");
        String path=sc.next(); 
        File fl=new File(path);
        tienda.meterDatosArbusto(fl);
    }

    public static void ingresarFilePedido(){
        System.out.println("Introduzca el path: ");
        String path=sc.next(); 
        File fl=new File(path);
        tienda.meterDatosPedido(fl);
    }
}
