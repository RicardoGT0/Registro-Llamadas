/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador.llamadas;

/**
 *
 * @author rgonzalez
 */
import java.io.*;
import java.util.List;

public class Respaldo {

    private static File f;

    public Respaldo(String nombreArchivo) {
        f = new File(nombreArchivo);
    }

    public void escribir(List<llamada> memoria) {

        try {

            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);

            for(llamada l:memoria){
                String ltext="";
                //ltext=l.getEmpresa()+"|"+l.getE_s()+"|"+l.getFecha()+"|"+l.getH_inicial()+"|"+l.getH_final()+"|"+l.getDuracion();
                ltext=l.getTickat()+"\t"+l.getEmpresa()+"\t"+l.getE_s()+"\t"+l.getFecha()+"\t"+l.getH_inicial()+"\t"+l.getH_final()+"\t"+l.getDuracion();
                 wr.println(ltext+"\n");
            }
             
            wr.close();
            bw.close();

        } catch (IOException e) {

        }
    }

}
    
   
           
           
   


