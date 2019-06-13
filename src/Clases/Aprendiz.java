package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import Clases.Persistencia;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAMSUNG
 */
public class Aprendiz extends Persistencia{
        
    private int IdEstudiante;
    private String Nombres;
    private String Apellidos;
    private String Tipodocumento;
    private long Documento;
    private long Telefono;
    private String Direccion;
    private String Municipio;
    private String Genero;
    private String Correo;
    private String FechaNacimiento;
    private String Tipo_Bachiller;
    private String Programa;
    private int Ficha;
    
    private String Carpeta = "C:\\EducLab\\";
    private String NombreArchivo = "Aprendices";
    private String Extencion = ".csv";
    private String Seprador = ";";
    
    //Constructor por defecto
    public Aprendiz() {
        super();
        super.setDatosArchivos(Carpeta, NombreArchivo, Extencion);
    }
    
    /* Constructor con datos */
    public Aprendiz(int IdEstudiante,
            String Nombres, 
            String Apellidos, 
            String Tipodocumento, 
            long Documento, 
            long Telefono, 
            String Direccion, 
            String Municipio, 
            String Genero, 
            String Correo, 
            String FechaNacimiento, 
            String Tipo_Bachiller, 
            String Programa, 
            int Ficha
    ) {
        super();
        super.setDatosArchivos(Carpeta, NombreArchivo, Extencion);
        
        this.IdEstudiante = IdEstudiante;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Tipodocumento = Tipodocumento;
        this.Documento = Documento;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Municipio = Municipio;
        this.Genero = Genero;
        this.Correo = Correo;
        this.FechaNacimiento = FechaNacimiento;
        this.Tipo_Bachiller = Tipo_Bachiller;
        this.Programa = Programa;
        this.Ficha = Ficha;
    }

    public int getIdEstudiante() {
        return IdEstudiante;
    }

    public void setIdEstudiante(int IdEstudiante) {
        this.IdEstudiante = IdEstudiante;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTipodocumento() {
        return Tipodocumento;
    }

    public void setTipodocumento(String Tipodocumento) {
        this.Tipodocumento = Tipodocumento;
    }

    public long getDocumento() {
        return Documento;
    }

    public void setDocumento(long Documento) {
        this.Documento = Documento;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getTipo_Bachiller() {
        return Tipo_Bachiller;
    }

    public void setTipo_Bachiller(String Tipo_Bachiller) {
        this.Tipo_Bachiller = Tipo_Bachiller;
    }

    public String getPrograma() {
        return Programa;
    }

    public void setPrograma(String Programa) {
        this.Programa = Programa;
    }

    public int getFicha() {
        return Ficha;
    }

    public void setFicha(int Ficha) {
        this.Ficha = Ficha;
    }
    
    public int getLastId(ArrayList<Aprendiz> arrAprendiz){
        if(arrAprendiz.size() > 0){
            int ultimoItem = arrAprendiz.size() - 1;
            Aprendiz objAprendiz = arrAprendiz.get(ultimoItem);
            int nuevoId = objAprendiz.IdEstudiante + 1;
            return nuevoId;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Aprendiz {" + "IdEstudiante=" + IdEstudiante + ", Nombres=" + Nombres + ", Apellidos=" + Apellidos + ", Tipodocumento=" + Tipodocumento + ", Documento=" + Documento + ", Telefono=" + Telefono + ", Direccion=" + Direccion + ", Municipio=" + Municipio + ", Genero=" + Genero + ", Correo=" + Correo + ", FechaNacimiento=" + FechaNacimiento + ", Tipo_Bachiller=" + Tipo_Bachiller + ", Programa=" + Programa + ", Ficha=" + Ficha + '}';
    }

    public ArrayList<Aprendiz> guardarAprendiz(ArrayList<Aprendiz> arrAprendices, Aprendiz objAprendiz){
        ArrayList<String> arrStrAprendices = new ArrayList<String>();
        if(objAprendiz != null){
            arrAprendices.add(objAprendiz);
            for (Aprendiz aprendiz : arrAprendices) {
                String strAprendiz = ObjectToString(aprendiz,Seprador);
                if (strAprendiz != null && !strAprendiz.isEmpty()){
                    arrStrAprendices.add(strAprendiz);
                }
            }
            escribirArchivo(arrStrAprendices);
        }else{
            System.out.println("Error el objeto no tiene datos");
        }
        return null;
    }
    
    public ArrayList<Aprendiz> CargarAprendices() {
        ArrayList<Aprendiz> arrAprendices = new ArrayList<Aprendiz>();
        ArrayList<String> archivoAprendices = leerArchivo();
        if(archivoAprendices != null){
            if(archivoAprendices.size() > 0){
                for (String strAprendiz : archivoAprendices) {
                    Aprendiz objAprendiz = StringToObject(strAprendiz,Seprador);
                    if(objAprendiz != null){
                        arrAprendices.add(objAprendiz);
                    }
                }
            }
        }
        return arrAprendices;
    }
    
    public String ObjectToString(Aprendiz ObjetoAprendiz, String Caracter){
        String CadenaCVS = "";
        if (ObjetoAprendiz != null){
            CadenaCVS = (ObjetoAprendiz.getIdEstudiante() + Caracter)
                    + (ObjetoAprendiz.getNombres() + Caracter)
                    + (ObjetoAprendiz.getApellidos() + Caracter)
                    + (ObjetoAprendiz.getTipodocumento() + Caracter)
                    + (ObjetoAprendiz.getDocumento() + Caracter)
                    + (ObjetoAprendiz.getTelefono() + Caracter)
                    + (ObjetoAprendiz.getDireccion() + Caracter) 
                    + (ObjetoAprendiz.getMunicipio() + Caracter) 
                    + (ObjetoAprendiz.getGenero() + Caracter)
                    + (ObjetoAprendiz.getCorreo() + Caracter)
                    + (ObjetoAprendiz.getFechaNacimiento() + Caracter)
                    + (ObjetoAprendiz.getTipo_Bachiller() + Caracter)
                    + (ObjetoAprendiz.getPrograma() + Caracter)
                    + (ObjetoAprendiz.getFicha());   
        }
        return CadenaCVS;
    }
    
    public Aprendiz StringToObject(String CadenaAprendiz, String Caracter){
        Aprendiz tmpAprendiz = new Aprendiz();
        if(CadenaAprendiz != null && !CadenaAprendiz.isEmpty()){
            String [] arrDatosAprendiz = CadenaAprendiz.split(Caracter);
            if(arrDatosAprendiz.length > 0){
                tmpAprendiz.IdEstudiante = Integer.parseInt(arrDatosAprendiz[0].trim());
                tmpAprendiz.Nombres = arrDatosAprendiz[1];
                tmpAprendiz.Apellidos = arrDatosAprendiz[2];
                tmpAprendiz.Tipodocumento = arrDatosAprendiz[3];
                tmpAprendiz.Documento = Long.parseLong(arrDatosAprendiz[4]);
                tmpAprendiz.Telefono = Long.parseLong(arrDatosAprendiz[5]);
                tmpAprendiz.Direccion = arrDatosAprendiz[6];
                tmpAprendiz.Municipio = arrDatosAprendiz[7];
                tmpAprendiz.Genero = arrDatosAprendiz[8];
                tmpAprendiz.Correo = arrDatosAprendiz[9];
                tmpAprendiz.FechaNacimiento = arrDatosAprendiz[10];
                tmpAprendiz.Tipo_Bachiller = arrDatosAprendiz[11];
                tmpAprendiz.Programa = arrDatosAprendiz[12];
                tmpAprendiz.Ficha = Integer.parseInt(arrDatosAprendiz[13]);
            }
        }else{
            System.out.println("Cadena Vacia...");
            return null;
        }
        return tmpAprendiz;
    }
    
}
