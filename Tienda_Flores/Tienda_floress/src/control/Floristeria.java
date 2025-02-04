package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import clases.*;

public class Floristeria {

    List <Flor> flores;
    List <Planta> plantas;
    List <Arbusto> arbustos;
    Map <String, Pedido> pedidos;
    List <String> deCodigos=new ArrayList<>();
    List <Producto> listaProductos=new ArrayList<>();


    public Floristeria() {
        flores=new ArrayList<>();
        plantas=new ArrayList<>();
        arbustos=new ArrayList<>();
        pedidos=new HashMap<>();
        
    }

    
    
    public List<Flor> getFlores() {
        return flores;
    }



    public void setFlores(List<Flor> flores) {
        this.flores = flores;
    }



    public List<Planta> getPlantas() {
        return plantas;
    }



    public void setPlantas(List<Planta> plantas) {
        this.plantas = plantas;
    }



    public List<Arbusto> getArbustos() {
        return arbustos;
    }



    public void setArbustos(List<Arbusto> arbustos) {
        this.arbustos = arbustos;
    }



    public Map<String, Pedido> getPedidos() {
        return pedidos;
    }


    public void setPedidos(Map<String, Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void SacarDataProductos(File file, Object obj){
        try{
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String lines=br.readLine();

            while(lines!=null){
                String [] datos=lines.split("#");

                if(obj.getClass().equals(Flor.class)){
                    Flor fl=new Flor(datos[0], datos[1], Double.parseDouble(datos[2]), datos[3]);
                    agregarFlores(fl);

                }else if(obj.getClass().equals(Planta.class)){
                    Planta pl=new Planta(datos[0], datos[1],Double.parseDouble(datos[2]), datos[3]);
                    agregarPlantas(pl);

                }else if(obj.getClass().equals(Arbusto.class)){
                    Arbusto arb=new Arbusto(datos[0], datos[1],Double.parseDouble(datos[2]), datos[3]);
                    agregarArbustos(arb);

                }else if(obj.getClass().equals(Pedido.class)){
                    Producto pdr=new Producto(datos[1], datos[2], Double.parseDouble(datos[3]), datos[4]);
                    Cliente cl=new Cliente(datos[5], datos[6]);
                    Pedido ped=new Pedido(datos[0], pdr, cl );
                    agregarPedidos(ped);
                }


                lines=br.readLine();
            }
            br.close();

        }catch(Exception e){}
    }


    public void actualizarTodo(File file){
        meterDatosArbusto(file);
        meterDatosFlor(file);
        meterDatosPlanta(file);
        meterDatosPedido(file);
    }


    public void meterDatosFlor(File file){
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Flor fl : flores) {
                bw.write(fl.pasarFichero());
            }
        
            bw.close();
            fw.close();
            
        } catch (Exception e){}
    }


    public void meterDatosPlanta(File file){
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Planta pl : plantas) {
                bw.write(pl.pasarFichero());
            }
           
            bw.close();
            fw.close();
            
        } catch (Exception e){}
    }


    public void meterDatosArbusto(File file){
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

           
            for (Arbusto ar : arbustos) {
                bw.write(ar.pasarFichero());
            }
            
            bw.close();
            fw.close();
            
        } catch (Exception e){}
    }


    public void meterDatosPedido(File file){
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Pedido pd : pedidos.values()) {
                bw.write(pd.pasarFichero());
            }
            bw.close();
            fw.close();
            
        } catch (Exception e){}
    }

    //iterator
    //comparator y comparable por nombre o precio
    //el estado 
    //volcar el hashmap en una estructura para ordenar por cliente

   

    public void agregarFlores(Flor fl){
        flores.add(fl);
    }

    public void agregarPlantas(Planta pl){
        plantas.add(pl);
    }

    public void agregarArbustos(Arbusto ar){
        arbustos.add(ar);
    }

    public void agregarPedidos(Pedido ped){
        verificarCodPedido(ped);
        pedidos.put(ped.getCodigo(), ped);
    }


    public boolean verificarCodPedido(Pedido p){
        for (Pedido ped : pedidos.values()) {
            if(p.getCodigo().equals(ped.getCodigo())){
               return false;
            }
        }
        return true;
    }

    public void iprimirTodo(){
        imprimirArbustos();
        imprimirFlores();
        imprimirPlantas();
    }


    public void imprimirFlores(){
        System.out.println(flores.toString());
    }

    public void imprimirPlantas(){
        System.out.println(plantas.toString());
    }

    public void imprimirArbustos(){
        System.out.println(arbustos.toString());
    }

    public void listadoPedidos(){
        for (Pedido ped : pedidos.values()) {
            System.out.println(ped.toString());
        }
    }

    public Producto buscarProducto(String id){
        for (Flor flr : flores) {
            if(flr.getId().equals(id)){
                return flr;
            }
        }
        for (Arbusto arb : arbustos) {
            if(arb.getId().equals(id)){
                return arb;
            }
        }
        for (Planta plt : plantas) {
            if(plt.getId().equals(id)){
                return plt;
            }
        }
        return null;
    }

    public void crearCodigo(Pedido ped){
        Random sr=new Random();
        String num="";
        for (int i = 0; i <2; i++) {
            num=num+sr.nextInt(9)+1;
        }
        if(deCodigos.contains(num)){
            Iterator<String>iterador=deCodigos.iterator();
            while(iterador.hasNext()){
                String siguiente=iterador.next();
                if(siguiente.equals(num)){
                    iterador.remove();
                }
            }
            crearCodigo(ped);

        }else{

            deCodigos.add(num);
            ped.setCodigo(num);
        }
    }
    public void agregarProducto( Producto nuev){
        listaProductos.add(nuev);
    }
    
    public void eliminarPedido(Pedido ped){
        for (Pedido p : pedidos.values()) {
            if(p.equals(ped)){
                pedidos.remove(p.getCodigo(),p);
            }
        }
    }

    public void eliminarFlor(Flor pro){
        Iterator <Flor> iterador = flores.iterator();
        while(iterador.hasNext()){
            Flor siguiente=iterador.next();
            if(siguiente.equals(pro)){
                iterador.remove();
            }
        }

    }

    public void actualizarSeguimiento(Pedido n){
        Calendar today = Calendar.getInstance();// creamos un calendario
        today.add(Calendar.DAY_OF_MONTH, 20);//agregamos 20 dias al calendario
        if(n.getFechaPedido().equals(today.getTime())){
            n.setEstado("En camino.");
        }

    }
    public Pedido buscarPedido(String cod){
       return pedidos.get(cod);
    }

    public void quitarProducto(String id){
        Producto pro = buscarProducto(id);
        for (Producto produ : listaProductos) {
            if(produ.getId().equals(pro.getId())){
                listaProductos.remove(produ);
            }
        }
    }
    public String infoPedido(Pedido ped){
        if(listaProductos.isEmpty()){
            return "No hay productos en el pedido";
        }else{
            return "\nCodigo del pedido: "+ ped.getCodigo()+"\n Articulos seleccionados: "+listaProductos.toString()+"\n";
        }
    }

}
