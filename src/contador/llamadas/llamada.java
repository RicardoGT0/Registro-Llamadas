/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador.llamadas;

/**
 *
 * @author Thunder
 */
class llamada {
    
    private String empresa;
    private String e_s;
    private String fecha;
    private String h_inicial;
    private String duracion;
    private String h_final;


    public llamada(String empresa, String e_s, String fecha, String h_inicial, String duracion, String h_final) {
        this.empresa = empresa;
        this.e_s = e_s;
        this.fecha = fecha;
        this.h_inicial = h_inicial;
        this.duracion = duracion;
        this.h_final = h_final;
    }
    
    
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getE_s() {
        return e_s;
    }

    public void setE_s(String e_s) {
        this.e_s = e_s;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getH_inicial() {
        return h_inicial;
    }

    public void setH_inicial(String h_inicial) {
        this.h_inicial = h_inicial;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getH_final() {
        return h_final;
    }

    public void setH_final(String h_final) {
        this.h_final = h_final;
    }
    
    
    
    
    
}
