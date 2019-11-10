/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Modelo.Area;
import Modelo.Comisario;
import Modelo.Complejo;
import Modelo.Conexion;
import Modelo.Evento;
import Modelo.Polideportivo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class EventoDAO {
    public static Conexion miConexion= Conexion.getInstance();
    
    public static boolean crear(Evento a,Comisario c, String rol, int id_a,int id_m) throws SQLException {        

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
        
        String date = a.getFecha();
        
        Timestamp d = convert(date);

        
        String sentenciaComplejo = "INSERT INTO event (name, date, id_sportcomplex, id_area)"
                    + "VALUES (?,?,?,?)";

            String sentenciaUnideportivo = "INSERT INTO comissioner_event (id_event, id_comissioner, rol )"
                    + "VALUES (?,?,?)";
            
             String sentenciaAE = "INSERT INTO equipment_event (id_event, id_equipment)"
                    + "VALUES (?,?)";

            PreparedStatement psUni, psCom, psAE;
            psCom = Conexion.getInstance().getConexion().prepareStatement(sentenciaComplejo, PreparedStatement.RETURN_GENERATED_KEYS);
            psCom.setString(1, a.getNombre());
            psCom.setTimestamp(2, d);
            psCom.setInt(3, a.getCod_complejo());
            psCom.setInt(4, id_a);
            psCom.executeUpdate();
            ResultSet rs = psCom.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);
            }

            psUni = Conexion.getInstance().getConexion().prepareStatement(sentenciaUnideportivo, PreparedStatement.RETURN_GENERATED_KEYS);
            psUni.setInt(1, id);
            psUni.setInt(2, c.getCodigo());
            psUni.setString(3, rol);
            psUni.executeUpdate();
            Conexion.getInstance().getConexion().commit();
            
            
            psAE = Conexion.getInstance().getConexion().prepareStatement(sentenciaAE, PreparedStatement.RETURN_GENERATED_KEYS);
            psAE.setInt(1, id);
            psAE.setInt(2, id_m);
            psAE.executeUpdate();
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
    
    public static Timestamp convert(String str_date) {
    try {
      DateFormat formatter;
      formatter = new SimpleDateFormat("dd/MM/yyyy");
      Date date = (Date) formatter.parse(str_date);
      java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
 
      return timeStampDate;
    } catch (ParseException e) {
      System.out.println("Exception :" + e);
      return null;
    }
  }

     
    
     
    
    
    public static ResultSet mostrarTodas() throws SQLException {     
        int nFilas = 0;
        String lineaSQL = "Select * from multisportcenter;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
    }

    
    
    public static void borrar(Evento m) throws SQLException {   
        
            String lineaSQL = "DELETE FROM event WHERE id_sportcomplex LIKE '"+m.getCodigo()+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);
            String lineaSQL2 = "DELETE FROM comissioner_event WHERE id LIKE '"+m.getCodigo()+"';" ;
            Conexion.getInstance().execute_All(lineaSQL2);
            String lineaSQL3 = "DELETE FROM equipment_event WHERE id LIKE '"+m.getCodigo()+"';" ;
            Conexion.getInstance().execute_All(lineaSQL3);
    }
}
