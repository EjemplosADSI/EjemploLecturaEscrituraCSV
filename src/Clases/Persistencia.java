/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DiegoAlonso
 */
public class Persistencia {
    
    private String Carpeta;
    private String Nombre;
    private String Extencion;
    private String NombreArchivoCompleto;
    private String RutaCompleta;
    private File objFile;
    private FileReader objFileReader;
    private BufferedReader objBufferedReader;
    
    public Persistencia() {
        
    }
    
    public void setDatosArchivos(String Carpeta, String Nombre, String Extencion){
        this.Carpeta = Carpeta;
        this.Nombre = Nombre;
        this.Extencion = Extencion;
        this.NombreArchivoCompleto = Nombre+Extencion;
        this.RutaCompleta = Carpeta+"\\"+NombreArchivoCompleto;
    }
    
    public boolean escribirArchivo (ArrayList<String> arrLineas){
        if(arrLineas.size() > 0){
            if(testFile()){
                FileWriter fichero = null;
                PrintWriter pw = null;
                try {
                    fichero = new FileWriter(RutaCompleta);
                    pw = new PrintWriter(fichero);
                    for (String linea : arrLineas) {
                        pw.println(linea);
                    }
                    return true;
                } catch (IOException ex) {
                    System.out.println("Error al escribir en el archivo... "+ex.getMessage());
                    Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (null != fichero)
                            fichero.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }else{
            System.out.println("No hay datos que almacenar...");
        }
        return false;
    }
    
    public ArrayList<String> leerArchivo () {
        if(testFile()){
            ArrayList<String> arrLineas = new ArrayList<String>();
            try {               
                objFileReader = new FileReader (objFile);
                objBufferedReader = new BufferedReader(objFileReader);
                
                String linea;
                while((linea=objBufferedReader.readLine())!=null){
                    arrLineas.add(linea);
                }
                return arrLineas;
            } catch (FileNotFoundException ex) {
                System.out.println("Error Archivo no encontrado... "+ex.getMessage());
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("Error al leer el archivo... "+ex.getMessage());
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try{                    
                    if( objFileReader != null ){
                        objFileReader.close();     
                    }                  
                }catch (Exception ex){
                    System.out.println("Error al cerrar la conexion... "+ex.getMessage());
                    Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    private boolean testFile (){
        if(crearCarpeta()){
            if(crearArchivo()){
                return true;
            }
        }
        return false;
    }
    
    private boolean crearArchivo (){
        try {
            File fichero = new File(RutaCompleta);
            if(!fichero.exists()){
                fichero.createNewFile();
            }else{
                //System.out.println("El archivo ya existe");
            }
            this.objFile = fichero;
            return true;
        }catch(java.io.IOException ioex) {
          ioex.printStackTrace();
          System.out.println("No se pudo crear el archivo: "+ioex.toString());
          return false;
       }
        
    }
     
    /* Llamado Sin instancia */
    public static boolean crearArchivo (String NombreArchivo){
        Persistencia pr = new Persistencia();
        pr.RutaCompleta = NombreArchivo;
        return pr.crearArchivo();
    }
    
    private boolean crearCarpeta (){
        try {
           File folder = new File(Carpeta);
           if (!folder.isDirectory()) {
               folder.mkdir();
           }
           return true;
       }catch(Exception ex) {
          System.out.println("No se pudo crear la carpeta: "+ex.toString());
          ex.printStackTrace();
          return false;
       }
    }

    /* Llamado Sin instancia */
    public static boolean crearCarpeta (String RutaCarpeta){
        Persistencia pr = new Persistencia();
        pr.Carpeta = RutaCarpeta;
        return pr.crearCarpeta();
    }
    
    public String getCarpeta() {
        return Carpeta;
    }

    public void setCarpeta(String Carpeta) {
        this.Carpeta = Carpeta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getExtencion() {
        return Extencion;
    }

    public void setExtencion(String Extencion) {
        this.Extencion = Extencion;
    }

    public String getNombreArchivoCompleto() {
        return NombreArchivoCompleto;
    }

    public void setNombreArchivoCompleto(String NombreArchivoCompleto) {
        this.NombreArchivoCompleto = NombreArchivoCompleto;
    }

    public String getRutaCompleta() {
        return RutaCompleta;
    }

    public void setRutaCompleta(String RutaCompleta) {
        this.RutaCompleta = RutaCompleta;
    }
    
}
