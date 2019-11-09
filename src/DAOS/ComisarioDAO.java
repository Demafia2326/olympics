/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Modelo.Comisario;
import Modelo.Conexion;
import Vista.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
/**
 *
 * @author Daniel Pérez Ramírez
 */
public class ComisarioDAO {
    
    public static Conexion miConexion= Conexion.getInstance();
    
    public static ResultSet mostrarComisario(String comisario) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "Select * from commissioner WHERE name LIKE '%"+ comisario +"%';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
    public static boolean crearComisario(String nombre, String dni) throws SQLException {        

        boolean insertados = true;
        int i;
        Comisario comisario;
        //Cadena donde irán las sentencias sql de creación de tablas
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia = null;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO commissioner (id, dni, name) values (NULL, ?, ?)";
        try {
            
            
            
            //conectamos el objeto preparedStmt a la base de datos
            PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            comisario = new Comisario(nombre, dni);

          
                preparedStmt.setString(1, comisario.getDni());
                preparedStmt.setString(2, comisario.getNombre());
                               
                
                // la ejecutamos
                preparedStmt.execute();

              
            // habría que cerrar la conexion
          
        } catch (SQLException se) {
            insertados = false;
            se.printStackTrace();
        }

        return insertados;

    }
    
    public static ResultSet mostrarTodosComisarios() throws SQLException {     
        int nFilas = 0;
        String lineaSQL = "Select * from commissioner;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
    }
    
    
    public static void modificarComisario(int id,String name,String dni) throws SQLException{
               
        String lineaSQL="UPDATE commissioner SET name='"+name+"', dni='"+dni+"' WHERE id="+id;
        Conexion.getInstance().execute_All(lineaSQL);      
    }
    
    
    public static void borrarComisario(String nombre, String dni) throws SQLException {   
        
            String lineaSQL = "DELETE FROM commissioner WHERE name LIKE '"+nombre+"' OR DNI LIKE '"+dni+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);

    }
    
    
}
