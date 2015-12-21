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
                ltext=l.getEmpresa()+l.getE_s()+l.getFecha()+l.getH_inicial()+l.getDuracion()+l.getH_final();
                 wr.append(ltext);
            }
             
            wr.close();
            bw.close();

        } catch (IOException e) {

        }
    }

}
    
   
           
           
   


