/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import DAOS.ComisarioDAO;
import DAOS.EstructuraDAO;
import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Daniel Pérez Ramírez
 */
public class Menu {
    private static Conexion newcon;
   
    
    
    public static void menuVista() throws InputMismatchException{
        newcon = Conexion.getInstance();
        
        
        
        if(newcon.conectar() != true){
            System.out.println("Fallo al conectar con la base de datos");
        }else{
            System.out.println("Conexion satisfactoria");
            
            //if(EstructuraDAO.generarEstructura()){

                Scanner scan = new Scanner(System.in);
                int opcion = 0;

                do {
                    System.out.println("1.- Opciones de Sede");
                    System.out.println("2.- Opciones de Complejo");
                    System.out.println("3.- Opciones de Polideportivo");
                    System.out.println("4.- Opciones de Unideportivo");
                    System.out.println("5.- Opciones de Evento");
                    System.out.println("6.- Opciones de Comisario");
                    System.out.println("7.- Opciones de Area");
                    System.out.println("8.- Opciones de Material");
                    System.out.println("0.- Salir");
                    opcion=scan.nextInt();

                    switch(opcion){
                        case 1:
                            menuSede();
                            break;
                        case 2:
                            menuComplejo();/*Utilizar transacciones a la hora de crear Poli/Uni y crear junto a ellos */
                            break;
    //                    case 3:
    //                        menuPolideportivo();
    //                        break;
                        case 4:
                            menuUnidep();
                            break;
    //                    case 5:
    //                        menuEvento();
    //                        break;
                        case 6:

                            menuComisario();

                            break;
                        case 7:
                            menuArea();
                            break;
                        case 8:
                            menuMaterial();
                            break;
                    }               

                } while (opcion > 0 && opcion < 10);
            
            
            //}
        }
        
        
        
        
        
    }

    private static void menuSede() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try{
            do {            
                System.out.println("1.- Añadir Sede");
                System.out.println("2.- Modificar Sede");
                System.out.println("3.- Borrar Sede");
                System.out.println("4.- Mostrar las Sedes");
                
                opcion = scSede.nextInt();

                switch(opcion){
                    case 1:
                        Scanner scan=new Scanner(System.in);
                        Scanner scn = new Scanner(System.in);           

                      
                        Controlador.crearSede();
                        break;
                    case 2:
                        if(Controlador.modificarSede()){
                            System.out.println("Comisario modificado CORRECTAMENTE");
                        }else{
                            System.out.println("ERROR");
                        }
                        break;
                    case 3:
                        Controlador.borrarSede();
                        break;
                    case 4:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarSede();
                        System.out.println("LISTADO DE SEDES");
                        System.out.println("ID   Nombre    Presupuesto");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("id") + "   " + resultado.getString("name") + "   " + resultado.getString("budget"));

                        }
                        System.out.println("Se han mostrado " + nFilas + " Notas apuntadas");
                        break;
                }
            } while (opcion < 0 && opcion > 5);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    
    private static void menuComplejo() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try{
            do {           
                
                System.out.println("1.- Ver Complejo");                
                System.out.println("2.- Salir");


                opcion = scSede.nextInt();

                switch(opcion){
                    case 1:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarComplejo();
                        System.out.println("LISTADO DE COMPLEJOS");
                        System.out.println("ID  Localizacion    Presidente       id_Sede");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("id") + "   " + resultado.getString("location") + "       " + resultado.getString("boss")+"       "+ resultado.getString("id_headquarter"));

                        }
                        System.out.println("Se han mostrado " + nFilas + " Notas apuntadas");
                        break;                      
                    default:
                        System.out.println("Introduzca valor valido");
                        break;
                }


            } while (opcion < 0 && opcion > 2);
        }catch(SQLException ex){
            System.out.println(ex);
        }    
    }
    
    private static void menuUnidep() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try{
            do {            
                System.out.println("1.- Añadir Complejo Unideportivo");
                System.out.println("2.- Modificar Complejo Unideportivo");
                System.out.println("3.- Borrar Complejo Unideportivo");
                System.out.println("4.- Mostrar Complejo Unideportivo");
                
                opcion = scSede.nextInt();

                switch(opcion){
                    case 1:
                        Scanner scan=new Scanner(System.in);
                        Scanner scn = new Scanner(System.in);           

                        
                        Controlador.crearUnideportivo();
                        break;
                    case 2:
                        if(Controlador.modificarUnideportivo()){
                            System.out.println("Comisario modificado CORRECTAMENTE");
                        }else{
                            System.out.println("ERROR");
                        }
                        break;
                    case 3:
                        Controlador.borrarSede();
                        break;
                    case 4:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarSede();
                        System.out.println("LISTADO DE COMISARIOS");
                        System.out.println("ID   Nombre    Presupuesto");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("id") + "   " + resultado.getString("name") + "   " + resultado.getString("budget"));

                        }
                        System.out.println("Se han mostrado " + nFilas + " Notas apuntadas");
                        break;
                }
            } while (opcion < 0 && opcion > 5);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private static void menuComisario() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try{
            do {            
                System.out.println("1.- Añadir Comisario");
                System.out.println("2.- Modificar Comisario");
                System.out.println("3.- Borrar Comisario");
                System.out.println("4.- Mostrar Comisarios");


                opcion = scSede.nextInt();

                switch(opcion){
                    case 1:
                        Scanner scan=new Scanner(System.in);
                        Scanner scn = new Scanner(System.in);                             
                        Controlador.crearComisario();
                        break;
                    case 2:
                        if(Controlador.modificarComisario()){
                            System.out.println("Comisario modificado CORRECTAMENTE");
                        }else{
                            System.out.println("ERROR");
                        }
                        break;
                    case 3:
                        Controlador.borrarComisario();
                        break;
                    case 4:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarComisario();
                        System.out.println("LISTADO DE COMISARIOS");
                        System.out.println("ID   Nombre    DNI");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("id") + "   " + resultado.getString("name") + "   " + resultado.getString("dni"));

                        }
                        System.out.println("Se han mostrado " + nFilas + " Notas apuntadas");
                        break;

                }


            } while (opcion < 0 && opcion > 5);
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    
    private static void menuArea() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try{
            do {            
                System.out.println("1.- Añadir Area");
                System.out.println("2.- Modificar Area");
                System.out.println("3.- Borrar Area");
                System.out.println("4.- Mostrar Area");
                
                opcion = scSede.nextInt();

                switch(opcion){
                    case 1:
                        Scanner scan=new Scanner(System.in);
                        Scanner scn = new Scanner(System.in);           

                        Controlador.crearArea();
                        break;
                    case 2:
                        if(Controlador.modificarArea()){
                            System.out.println("Area modificado CORRECTAMENTE");
                        }else{
                            System.out.println("ERROR");
                        }
                        break;
                    case 3:
                        Controlador.borrarSede();
                        break;
                    case 4:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarArea();
                        System.out.println("LISTADO DE ");
                        System.out.println("ID   id_Polideportivo       location        sport    ");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("id") + "   " + resultado.getInt("id_multisportcenter") + "   " + resultado.getString("location")+"     "+ resultado.getString("sport"));

                        }
                        System.out.println("Se han mostrado " + nFilas + " Notas apuntadas");
                        break;
                }
            } while (opcion < 0 && opcion > 5);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private static void menuMaterial() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try{
            do {            
                System.out.println("1.- Añadir Material");
                System.out.println("2.- Modificar Material");
                System.out.println("3.- Borrar Material");
                System.out.println("4.- Mostrar Material");
                
                opcion = scSede.nextInt();

                switch(opcion){
                    case 1:
                        Scanner scan=new Scanner(System.in);
                        Scanner scn = new Scanner(System.in);           

                        Controlador.crearMaterial();
                        break;
                    case 2:
                        if(Controlador.modificarMaterial()){
                            System.out.println("Material modificado CORRECTAMENTE");
                        }else{
                            System.out.println("ERROR");
                        }
                        break;
                    case 3:
                        Controlador.borrarMaterial();
                        break;
                    case 4:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarMaterial();
                        System.out.println("LISTADO DE SEDES");
                        System.out.println("ID   Nombre");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("id") + "   " + resultado.getString("name"));

                        }
                        System.out.println("Se han mostrado " + nFilas + " Notas apuntadas");
                        break;
                }
            } while (opcion < 0 && opcion > 5);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    
    

   
    
    
    
}
