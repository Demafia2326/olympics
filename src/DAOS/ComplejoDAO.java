/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

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
public class ComplejoDAO {
    public static Conexion miConexion= Conexion.getInstance();
    
    public static ResultSet mostrarComplejo(String in) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "Select * from sportcomplex WHERE name LIKE '%"+ in +"%';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
   
        
        public static ResultSet mostrarTodosComplejos() throws SQLException {     
        int nFilas = 0;
        String lineaSQL = "Select * from sportcomplex;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
       
        
    }
    
    
    
    
    
    
}
