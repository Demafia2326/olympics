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
public class Sede {
    private int codigo;
    private String nombre;
    private float presupuesto;
    private List<Complejo> complejos;

    public Sede(int codigo, String nombre, float presupuesto, List<Complejo> complejos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.complejos = complejos;
    }

    public Sede(String nombre, float presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
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
     * @return the presupuesto
     */
    public float getPresupuesto() {
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * @return the complejos
     */
    public List<Complejo> getComplejos() {
        return complejos;
    }

    /**
     * @param complejos the complejos to set
     */
    public void setComplejos(List<Complejo> complejos) {
        this.complejos = complejos;
    }
    
    
    
    
}
