/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Modelo.Complejo;
import Modelo.Conexion;
import Modelo.Polideportivo;
import Modelo.Unideportivo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class PolideportivoDAO {
     public static Conexion miConexion= Conexion.getInstance();
    
     public static boolean crear(Polideportivo a) throws SQLException {        

        boolean correcto = true;
        int i;
        int id = 0;
        try{
        Polideportivo uni;
        Complejo complex;
        //Cadena donde irán las sentencias sql de creación de tablas
        
        //Objeto de tipo Statement
        Statement sentencia = null;
        
        
        miConexion.getConexion().setAutoCommit(false);
        
        

        
        String sentenciaComplejo = "INSERT INTO sportcomplex (location ,boss, id_headquarter )"
                    + "VALUES (?,?,?)";

            String sentenciaUnideportivo = "INSERT INTO multisportcenter (id_sportcomplex, sport , information )"
                    + "VALUES (?,?,?)";

            PreparedStatement psUni, psCom;
            psCom = Conexion.getInstance().getConexion().prepareStatement(sentenciaComplejo, PreparedStatement.RETURN_GENERATED_KEYS);
            psCom.setString(1, a.getLocalizacion());
            psCom.setString(2, a.getJefe());
            psCom.setInt(3, a.getCod_sede());
            psCom.executeUpdate();
            ResultSet rs = psCom.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);
            }

            psUni = Conexion.getInstance().getConexion().prepareStatement(sentenciaUnideportivo, PreparedStatement.RETURN_GENERATED_KEYS);
            psUni.setInt(1, id);
            psUni.setString(2, a.getInfo());
            psUni.executeUpdate();
            Conexion.getInstance().getConexion().commit();
            
            
            
        //conectamos el objeto preparedStmt a la base de datos
       


    



        } catch (SQLException ex) {
            try {

                Conexion.getInstance().getConexion().rollback();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                System.out.println("Error sql" + e);
            }
        } finally {

            try {
                Conexion.getInstance().getConexion().setAutoCommit(true);
                Conexion.getInstance().getConexion().close();
            } catch (SQLException ex) {
                System.out.println("Error sql"+ ex);
            }
        }
        return correcto;
    }
     
    
     
    public static ResultSet mostrar(Polideportivo m) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "Select * from multisportcenter WHERE id_sportcomplex LIKE '"+ m.getCod_Complejo()+"';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
    public static ResultSet mostrarTodas() throws SQLException {     
        int nFilas = 0;
        String lineaSQL = "Select * from multisportcenter;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
    }
    public static void modificar(int id,String i) throws SQLException{
               
        String lineaSQL="UPDATE multisportcenter SET information='"+i+"'  WHERE id_sportcomplex="+id+";";
        Conexion.getInstance().execute_All(lineaSQL);      
    }
    
    
    public static void borrar(Polideportivo m) throws SQLException {   
        
            String lineaSQL = "DELETE FROM multisportcenter WHERE id_sportcomplex LIKE '"+m.getCod_Complejo()+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);
            String lineaSQL2 = "DELETE FROM sportcomplex WHERE id LIKE '"+m.getCod_Complejo()+"';" ;
            Conexion.getInstance().execute_All(lineaSQL2);
    }
}
