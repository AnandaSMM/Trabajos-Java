package clases;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Pizza pizza;
    private Cliente cliente;
    private Empleado empleado;
    private int numeroDePizzas;
    private List <Pizza> menuPizzas;
    private List <Pizza> pizzasPedidas;

    public Pedido(Pizza pizzas, Cliente cliente, Empleado empleado) {
        this.pizza = pizzas;
        this.cliente = cliente;
        this.empleado = empleado;
        this.numeroDePizzas = 0;
        this.menuPizzas=new ArrayList<>();
        this.pizzasPedidas=new ArrayList<>();

    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public int getNumeroDePizzas() {
        return numeroDePizzas;
    }

    public void setNumeroDePizzas(int numeroDePedidos) {
        this.numeroDePizzas = numeroDePedidos;
    }

    public void addPizzasPedidas(Pizza pizza){
        pizzasPedidas.add(pizza);
    }

    public Pizza elegirPizza(String eleccion){
        Pizza elegida = null;
        for (Pizza pizza2 : menuPizzas) {
            if(pizza2.getNumero().equals(eleccion)){
                elegida=pizza2;
                break;
            }
        }
        return elegida;
    }

    public void addPizzas(Pizza p){
        menuPizzas.add(p);
    }

    public void mostrarPizzas(){
        for (Pizza p : menuPizzas) {
            System.out.println(p.toString());
        }
    }

    public double importeTotalDePizzas (){
        double total=0;
        for (Pizza p : pizzasPedidas) {
            total=total+p.getPrecio();
        }
        return total;
    }
   
    public void factura(){
        System.out.println("------Factura-----------------------------");
        String nombre="";
        for (Pizza p : pizzasPedidas) {
            nombre= p.getNombre()+"\t\t"+p.getPrecio();
            System.out.println(nombre);
            numeroDePizzas++;
        }
        System.out.println("Cantidad de pizzas :\t  "+ numeroDePizzas);
    }

}
