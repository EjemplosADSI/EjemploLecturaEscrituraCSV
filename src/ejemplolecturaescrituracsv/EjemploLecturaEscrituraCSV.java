/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplolecturaescrituracsv;

import Clases.Aprendiz;
import java.util.ArrayList;

/**
 *
 * @author Instructor
 */
public class EjemploLecturaEscrituraCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Aprendiz> listAprendices = new ArrayList<Aprendiz>();     
        listAprendices = new Aprendiz().CargarAprendices();
        
        if(listAprendices.size() > 0){
            for (Aprendiz aprendiz : listAprendices) {
                System.out.println(aprendiz);
            }
        }
        
        int IdAprendiz = new Aprendiz().getLastId(listAprendices);
        Aprendiz aprendiz1 = new Aprendiz(IdAprendiz, "Diego", "Ojeda", "C.C", 1057582244L,3118864151L, "Transversal 27 2G-02", "Sogamoso", "Masculino", "daom89@gmail.com", "03/09/1989", "Tecnico", "ADSI", 1613481);
        
        listAprendices = new Aprendiz().guardarAprendiz(listAprendices, aprendiz1);
    }
    
}
