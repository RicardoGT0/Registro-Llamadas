/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador.llamadas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class Tiempo extends TimerTask{

    private String duracion = "";
    private String fecha = "";
    private Timer timer = new Timer(); 
    private int segundos=0;
    private String hora="";

    @Override
    public void run() {
        segundos++;
        System.out.println("segundo: " + segundos);
    }
    
    //Crea un timer, inicia segundos a 0 y comienza a contar
    public void Contar()
    {
        this.segundos=0;
        timer = new Timer();
        timer.schedule(new Tiempo(), 0, 1000);
    }
    //Detiene el contador
    public void Detener() {
        timer.cancel();
    }
    //Metodo que retorna los segundos transcurridos
    public int getSegundos()
    {
        return this.segundos;
    }
    
    public String getHora() {
        hora=horaActual();
        return hora;
    }
    
    public String getFecha() {
        fecha = fechaActual();
        return fecha;
    }

    private String horaActual() {
        Calendar calendario = Calendar.getInstance();
        calendario = new GregorianCalendar();

        int hora, minutos, segundos;

        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);

        return (String.valueOf(hora) + ":" + String.valueOf(minutos) + ":" + String.valueOf(segundos));

    }

    private String fechaActual() {
        Calendar calendario = Calendar.getInstance();
        calendario = new GregorianCalendar();

        String dia = Integer.toString(calendario.get(Calendar.DATE));
        String mes = Integer.toString(calendario.get(Calendar.MONTH));
        String annio = Integer.toString(calendario.get(Calendar.YEAR));

        return (String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(annio));
    }

    
    
}
