/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Modelo.Area;
import Modelo.Conexion;
import Modelo.Material;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class MaterialDAO {
    public static Conexion miConexion= Conexion.getInstance();
    
    public static ResultSet mostrar(Material m) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "Select * from equipment WHERE  LIKE '"+ m.getName()+"';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
    public static boolean crear(String name) throws SQLException {        

        boolean insertados = true;
        int i;
        Material m;
        //Cadena donde irán las sentencias sql de creación de tablas
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia = null;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO equipment (id, name) values (NULL, ?)";
        try {
            
            
            
            //conectamos el objeto preparedStmt a la base de datos
            PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            m = new Material(name);

          
                preparedStmt.setString(1, m.getName());

                // la ejecutamos
                preparedStmt.execute();

              
            // habría que cerrar la conexion
          
        } catch (SQLException se) {
            insertados = false;
            se.printStackTrace();
        }

        return insertados;

    }
    
    public static ResultSet mostrarTodas() throws SQLException {     
        int nFilas = 0;
        String lineaSQL = "Select * from equipment;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
    }
    
    
    public static void modificar(int id,String m) throws SQLException{
               
        String lineaSQL="UPDATE equipment SET name='"+m+"' WHERE id="+id;
        Conexion.getInstance().execute_All(lineaSQL);      
    }
    
    
    public static void borrar(Material m) throws SQLException {   
        
            String lineaSQL = "DELETE FROM equipments WHERE location LIKE '"+m.getName()+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);

    }
}
