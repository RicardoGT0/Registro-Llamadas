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

public class Respaldo {
    
    private static File f;
    
    public Respaldo(String nombreArchivo) {
        f = new File(nombreArchivo);
    }

    
    
    public void escribir(String linea) {

        try { 

            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);

            wr.append(" - y aqui continua"); //concatenamos en el archivo sin borrar lo existente
                        
            wr.close();
            bw.close();

        } catch (IOException e) {
            
        }
    }

    }
