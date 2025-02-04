package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import clases.Animal;
import clases.Asignacion;
import clases.Instalacion;
import clases.Trabajador;
import clases.Zona;

public class Zoologico {

    private String nombre;
    List <Zona> zonas;
    List <Instalacion> instalaciones;
    List <Animal> animales;
    List <Trabajador> trabajadores;
    List <Asignacion> asignaciones;


    public Zoologico(String nombre) {
        this.nombre = nombre;
        this.zonas=new ArrayList<>();
        this.instalaciones=new ArrayList<>();
        this.animales=new ArrayList<>();
        this.trabajadores=new ArrayList<>();
        this.asignaciones=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public void agregarAsignacion(Asignacion asig){
        asignaciones.add(asig);
    }




    public void verificarZona(Zona zn){
        for (Zona z : zonas) {
            if(!z.getCodigo().equals(z.getCodigo())){
                zonas.add(zn);
            }else{
                System.out.println("El codigo ya existe");
            }
        }
    }
    public void verificarInstalacion(Instalacion ins){
        for (Instalacion i : instalaciones) {
            if(i.getId()!=ins.getId()){
                instalaciones.add(ins);
            }else{
                System.out.println("El id ya existe");
            }
        }
    }
    public void verificarAnimales(Animal ani){
        for (Animal an : animales) {
            if(!an.getCodAnimal().equals(ani.getCodAnimal())){
                animales.add(ani);
            }else{
                System.out.println("El codigo ya existe");
            }
        }
    }

    public void verificarTrabajadores(Trabajador trbj){
        for (Trabajador trb : trabajadores) {
            if(trb.getDni().equals(trbj.getDni())){
                trabajadores.add(trbj);
            }else{
                System.out.println("El dni ya existe");
            }
        }
    }



    public void imprimirZona(){
        for (Zona zn : zonas) {
            System.out.println(zn);
        }
    }

    public void imprimirInstalaciones(){
        for (Instalacion ins : instalaciones) {
            System.out.println(ins);
        }
    }

    public void imprimirAnimales(){
        for (Animal animal : animales) {
            System.out.println(animal);
        }
    }

    public void imprimirTrabajadores(){
        for (Trabajador trb : trabajadores) {
            System.out.println(trb);
        }
    }

    public void imprimirAsignacion(String dni){
        for (Asignacion asig : asignaciones) {
            if(asig.getTrabajadores().getDni().equals(dni)){
                System.out.println(asig);
            }
        }
    }


    public void sacarDatosZonas(File file){
        try {
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String linea=br.readLine();

                while(linea!=null){
                    String [] frase=linea.split("#");

                    Zona zn=new Zona(frase[0], frase[1], Integer.parseInt(frase[2]));
                    zonas.add(zn);
                    linea=br.readLine();
                }
        
            br.close();
        }catch(Exception e){
        
        }
        
    }

    public void sacarDatosInstalaciones(File file){
        try {
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String linea=br.readLine();

                while(linea!=null){
                    String [] frase=linea.split("#");
                    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                    Date date=sdf.parse(frase[1]);
                    Instalacion ins=new Instalacion(frase[0], date, Integer.parseInt(frase[2]));
                    instalaciones.add(ins);

                    linea=br.readLine();
                }
        
            br.close();
        }catch(Exception e){
        
        }
        
    }

    public void sacarDatosAnimales(File file){
        try {
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String linea=br.readLine();

                while(linea!=null){
                    String [] frase=linea.split("#");
                    SimpleDateFormat sdf=new SimpleDateFormat();
                    Date date=sdf.parse(frase[3]);
                    Animal ani=new Animal(frase[0], frase[1], frase[2], date);
                    animales.add(ani);

                    linea=br.readLine();
                }
        
            br.close();
        }catch(Exception e){
        
        }
        
    }
    public void sacarDatosTrabajadores(File file){
        try {
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String linea=br.readLine();

                while(linea!=null){
                    String [] frase=linea.split("#");

                    Trabajador trbj=new Trabajador(frase[0], frase[1], frase[2], frase[3]);
                    trabajadores.add(trbj);

                    linea=br.readLine();
                }
        
            br.close();
        }catch(Exception e){
        
        }

        
    }

    public void meterDatosZona(File file){
        try {
            FileWriter fw= new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);
            
            for (Zona zn : zonas) {
                bw.write(zn.meterFichero());
            }
            bw.close();
        } catch (Exception e) {
          
        }
       
    }
    
    public void meterDatosInstalacion(File file){
        try {
            FileWriter fw= new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);
            
            for (Instalacion ins : instalaciones) {
                bw.write(ins.meterdatos());
            }
            bw.close();
        } catch (Exception e) {
          
        }
       
    }

    public void meterDatosAnimales(File file){
        try {
            FileWriter fw= new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);
            
            for (Animal ani : animales) {
                bw.write(ani.meterdatos());
            }
            bw.close();
        } catch (Exception e) {
          
        }
       
    }

    public void meterDatosTrabajadores(File file){
        try {
            FileWriter fw= new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);
            
            for (Trabajador trbj : trabajadores) {
                bw.write(trbj.meterdatos());
            }
            bw.close();
        } catch (Exception e) {
          
        }
       
    }

    
}











    

