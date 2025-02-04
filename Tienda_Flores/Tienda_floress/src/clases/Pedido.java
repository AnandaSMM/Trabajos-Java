package clases;


import java.util.Date;


public class Pedido implements Comparable <Pedido>{
    private String codigo;
    private Producto pro;
    private Cliente cl;
    private String estado;
    private Date fechaPedido;


    public Pedido(String codigo, Producto pro, Cliente cl) {
        this.codigo = codigo;
        this.pro = pro;
        this.cl = cl;
        setEstado("Preparando");
        
    }

    public Pedido(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public Cliente getCl() {
        return cl;
    }

    public void setCl(Cliente cl) {
        this.cl = cl;
    } 

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void calcFechaPedido(){
        setFechaPedido(new Date());
    }

    
    public String pasarFichero(){
        return this.codigo+"#"+this.pro+"#"+this.cl+"#"
        +this.estado;
    }

   
@Override
public String toString() {
   String linea="-----------------------------------";
    return linea+"- Codigo de pedido:\t"+this.codigo+"-\n- Pdocuto: "+this.pro+"-\n- Cliente: "+this.cl+
    "-\n- estado: "+this.estado+linea;
}

@Override
public int compareTo(Pedido o) {
   Pedido casteado=(Pedido)o;
   return this.cl.getNombre().compareTo(casteado.cl.getNombre());
}
    
    
    
}
