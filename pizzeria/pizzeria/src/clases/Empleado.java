package clases;
import java.util.Date;

public class Empleado extends Persona{
    private Date fechaIngreso;
    private Date fechaSalida;

    public Empleado(String nombre, String telefono, String email) {
        super(nombre, telefono, email);
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void fichar(){
        if (getFechaIngreso()!=null) {
            setFechaSalida(new Date());
            System.out.println(getNombre()+ " ha fichado salida a las "+ getFechaSalida());
        }else{
            setFechaIngreso(new Date());
            System.out.println(getNombre()+ " ha fichado entrada a las "+ getFechaIngreso());
        }
    }

    public void realizarPedido(Cliente cliente, Pizza pizza){
        System.out.println("Pedido realizado por: "+ this.getNombre() + "\nCliente: "+ cliente.getNombre()+"\n1 "+pizza.getNombre()+ "\t precio: "+pizza.getPrecio());
    }

    public boolean cobrar(double dinero, double total){

        if(dinero <total){
            System.out.println("dinero insuficiente");
            return false;
        }else{
            double cambio = dinero-total;
            System.out.println("Cambio: "+cambio);
            return true;
        }

    }
    
} 