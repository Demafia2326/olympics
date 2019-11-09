/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Modelo.Comisario;
import Modelo.Conexion;
import Modelo.Sede;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class SedeDAO {
    public static Conexion miConexion= Conexion.getInstance();
    
    public static ResultSet mostrarSede(String comisario) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "Select * from headquarter WHERE name LIKE '%"+ comisario +"%';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
    public static boolean crearSede(String nombre,float bud) throws SQLException {          
        
        boolean insertados = true;
        int i;
        Sede sede;
        //Cadena donde irán las sentencias sql de creación de tablas
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia = null;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO headquarter (id, name, budget) values (NULL, ?, ?)";
        try {
                 
            
            //conectamos el objeto preparedStmt a la base de datos
            PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            sede = new Sede(nombre, bud);

          
                
                preparedStmt.setString(1, sede.getNombre());
                preparedStmt.setFloat(2, sede.getPresupuesto());
                               
                
                // la ejecutamos
                preparedStmt.execute();

              
            // habría que cerrar la conexion
          
        } catch (SQLException se) {
            insertados = false;
            se.printStackTrace();
        }

        return insertados;

    }
    
    public static ResultSet mostrarTodosSede() throws SQLException {     
        int nFilas = 0;
        String lineaSQL = "Select * from headquarter;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
        
    }
    
    
    public static void modificarSede(int id,String name,float budget) throws SQLException{
               
        String lineaSQL="UPDATE headquarter SET name='"+name+"', budget='"+budget+"' WHERE id="+id;
        Conexion.getInstance().execute_All(lineaSQL);      
    }
    
    
    public static void borrarSede(String nombre, int id) throws SQLException {   
        
            String lineaSQL = "DELETE FROM headquarter WHERE name LIKE '"+nombre+"' OR id LIKE '"+id+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);

    }
}
