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
public class Complejo {

    
    private int codigo;
    private String localizacion;
    private String jefe;
    private int cod_sede;
    

    public Complejo() {
    }

    public Complejo(String localizacion, String jefe, int cod_sede) {
        this.localizacion = localizacion;
        this.jefe = jefe;
        this.cod_sede = cod_sede;
    }
    
    
    public Complejo(int codigo, String localizacion, String jefe, int cod_sede) {
        this.codigo = codigo;
        this.localizacion = localizacion;
        this.jefe = jefe;
        this.cod_sede = cod_sede;
    }
    
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the localizacion
     */
    public String getLocalizacion() {
        return localizacion;
    }

    /**
     * @param localizacion the localizacion to set
     */
    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    /**
     * @return the jefe
     */
    public String getJefe() {
        return jefe;
    }

    /**
     * @param jefe the jefe to set
     */
    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public int getCod_sede() {
        return cod_sede;
    }

    public void setCod_sede(int cod_sede) {
        this.cod_sede = cod_sede;
    }
    
    
    
    
}
