/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Modelo.Area;
import Modelo.Comisario;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class AreaDAO {
    public static Conexion miConexion= Conexion.getInstance();
    
    public static ResultSet mostrar(Area area) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "Select * from area WHERE location LIKE '"+ area.getLocalizacion() +"' OR sport LIKE '"+area.getDeporte()+"';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
    public static boolean crear(String location, String sport, int id_cent) throws SQLException {        

        boolean insertados = true;
        int i;
        Area area;
        //Cadena donde irán las sentencias sql de creación de tablas
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia = null;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO area (id, id_multisportcenter, location,sport) values (NULL, ?, ?, ?)";
        try {
            
            
            
            //conectamos el objeto preparedStmt a la base de datos
            PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            area = new Area(id_cent,location, sport);

          
                preparedStmt.setInt(1, area.getCod_Polideportivo());
                preparedStmt.setString(2, area.getLocalizacion());
                preparedStmt.setString(3, area.getDeporte());
                               
                
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
        String lineaSQL = "Select * from area;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
    }
    
    
    public static void modificar(int id,String local,String deporte,int id_m) throws SQLException{
               
        String lineaSQL="UPDATE area SET id_multisportcenter='"+id_m+"',name='"+local+"', dni='"+deporte+"' WHERE id="+id;
        Conexion.getInstance().execute_All(lineaSQL);      
    }
    
    
    public static void borrar(Area area) throws SQLException {   
        
            String lineaSQL = "DELETE FROM area WHERE location LIKE '"+area.getLocalizacion()+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);

    }
}
