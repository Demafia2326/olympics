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
public class Area {
    private int codigo;
    private int cod_Polideportivo;
    private String localizacion;
    private String deporte;

    public Area(String localizacion, String deporte) {
        this.localizacion = localizacion;
        this.deporte = deporte;
    }

    
    
    public Area(int cod_Polideportivo, String localizacion, String deporte) {
        this.cod_Polideportivo = cod_Polideportivo;
        this.localizacion = localizacion;
        this.deporte = deporte;
    }
    
    

    public Area(int codigo, int cod_Polideportivo, String localizacion, String deporte) {
        this.codigo = codigo;
        this.cod_Polideportivo = cod_Polideportivo;
        this.localizacion = localizacion;
        this.deporte = deporte;
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
     * @return the cod_Polideportivo
     */
    public int getCod_Polideportivo() {
        return cod_Polideportivo;
    }

    /**
     * @param cod_Polideportivo the cod_Polideportivo to set
     */
    public void setCod_Polideportivo(int cod_Polideportivo) {
        this.cod_Polideportivo = cod_Polideportivo;
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
     * @return the deporte
     */
    public String getDeporte() {
        return deporte;
    }

    /**
     * @param deporte the deporte to set
     */
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    
    
    
    
}
