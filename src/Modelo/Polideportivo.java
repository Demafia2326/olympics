/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class Polideportivo extends Complejo{
    private int cod_Complejo;
    private String info;

    public Polideportivo(int cod_Complejo, String info) {
        this.cod_Complejo = cod_Complejo;
        this.info = info;
    }

    public Polideportivo(int cod_Complejo) {
        this.cod_Complejo = cod_Complejo;
    }

    public Polideportivo(String info, String localizacion, String jefe, int cod_sede) {
        super(localizacion, jefe, cod_sede);
        this.info = info;
    }
    
    

    
    
    
    
    

    /**
     * @return the cod_Complejo
     */
    public int getCod_Complejo() {
        return cod_Complejo;
    }

    /**
     * @param cod_Complejo the cod_Complejo to set
     */
    public void setCod_Complejo(int cod_Complejo) {
        this.cod_Complejo = cod_Complejo;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
