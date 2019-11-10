/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class Evento{
    
    private int codigo;
    private String nombre;
    private int cod_complejo;
    private String fecha;
    private List<Comisario> comisarios;
    private List<Material> materiales;

    public Evento(int codigo, String nombre, int cod_complejo, String fecha, List<Comisario> comisarios, List<Material> materiales) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cod_complejo = cod_complejo;
        this.fecha = fecha;
        this.comisarios = comisarios;
        this.materiales = materiales;
    }

    public Evento(String nombre, int cod_complejo, String fecha) {
        this.nombre = nombre;
        this.cod_complejo = cod_complejo;
        this.fecha = fecha;
    }

    public Evento(int codigo) {
        this.codigo = codigo;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cod_complejo
     */
    public int getCod_complejo() {
        return cod_complejo;
    }

    /**
     * @param cod_complejo the cod_complejo to set
     */
    public void setCod_complejo(int cod_complejo) {
        this.cod_complejo = cod_complejo;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the comisarios
     */
    public List<Comisario> getComisarios() {
        return comisarios;
    }

    /**
     * @param comisarios the comisarios to set
     */
    public void setComisarios(List<Comisario> comisarios) {
        this.comisarios = comisarios;
    }

    /**
     * @return the materiales
     */
    public List<Material> getMateriales() {
        return materiales;
    }

    /**
     * @param materiales the materiales to set
     */
    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }
    
    
    
    
}
