/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAOS.AreaDAO;
import DAOS.ComisarioDAO;
import DAOS.ComplejoDAO;
import DAOS.MaterialDAO;
import DAOS.SedeDAO;
import DAOS.UnideportivoDAO;
import Modelo.Area;
import Modelo.Complejo;
import Modelo.Material;
import Modelo.Unideportivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class Controlador {
    
    public static Scanner scan = new Scanner(System.in);
    
    public static ResultSet mostrarComisario() throws SQLException{
        
        ResultSet resultado= null;
        
        System.out.println("¿Desea mostrar todos o solo buscar por nombre?");
        System.out.println("1.- Por Nombre");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        
        
        switch(op){
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique el nombre del Comisario que desea inspeccionar");
                String nombre = scn.nextLine();
                resultado = ComisarioDAO.mostrarComisario(nombre);  
            case 2:
                resultado = ComisarioDAO.mostrarTodosComisarios();
        }
        return resultado;
       
    }
    
    public static boolean crearComisario() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);       
        
        System.out.println("Introduzca el nombre: ");
        String name = scan.nextLine();
        
        System.out.println("Introduzca su DNI");
        String dni = scan.nextLine();
        
        
        if(("".equals(name))||("".equals(dni))){
            System.out.println("Non comand recibed");
        }else{
            ComisarioDAO.crearComisario(name, dni);
            yep = true;
        }
        return yep;
    }
    
    public static boolean modificarComisario() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);
        
        
        System.out.println("Introduzca el ID del usuario que vaya a cambiar");
        int id=scn.nextInt();
        
        System.out.println("Introduzca el nombre: ");
        String name = scan.nextLine();
        
        System.out.println("Introduzca nuevo DNI");
        String dni = scan.nextLine();
        
        
        if(("".equals(name))||("".equals(id))){
            System.out.println("Non comand recibed");
        }else{
            ComisarioDAO.modificarComisario(id, name, dni);
            yep = true;
        }
       
        return yep;
        
    }
    
    public static boolean borrarComisario() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);       
        
        System.out.println("Introduzca el nombre: ");
        String name = scan.nextLine();
        
        System.out.println("Introduzca nuevo DNI");
        String dni = scan.nextLine();
        
        
        if(("".equals(name))||("".equals(dni))){
            System.out.println("Non comand recibed");
        }else{
            ComisarioDAO.borrarComisario(name, dni);
            yep = true;
        }
       
        return yep;
        
    }
    
    /*
_____________________________________________________________________________________________________________________________________________________________
    */
    
    
    public static ResultSet mostrarSede() throws SQLException{
        
        System.out.println("¿Desea mostrar todos o solo buscar por nombre?");
        System.out.println("1.- Por Nombre");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        ResultSet resultado= null;
        
        switch(op){
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique el nombre de la Sede que desea inspeccionar");
                String nombre = scn.nextLine();
                resultado = SedeDAO.mostrarSede(nombre);  
                break;
            case 2:
                resultado = SedeDAO.mostrarTodosSede();
                break;
        }
        return resultado;
       
    }
    
    public static boolean crearSede() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);       
        
        System.out.println("Introduzca el nombre: ");
        String name = scan.nextLine();
        
        System.out.println("Introduzca su Presupuesto");
        float bud = scan.nextFloat();
        
        
        if("".equals(name)){
            System.out.println("Non comand recibed");
        }else{
            SedeDAO.crearSede(name, bud);
            yep = true;
        }
        return yep;
    }
    
    public static boolean modificarSede() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);
        
        
        System.out.println("Introduzca el ID del la sede que vaya a cambiar");
        int id=scn.nextInt();
        
        System.out.println("Introduzca el nombre: ");
        String name = scan.nextLine();
        
        System.out.println("Introduzca nuevo DNI");
        float budget = scan.nextFloat();
        
        
        if(("".equals(name))||("".equals(id))){
            System.out.println("Non comand recibed");
        }else{
            SedeDAO.modificarSede(id, name, budget);
            yep = true;
        }
       
        return yep;
        
    }
    
    public static boolean borrarSede() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);       
        
        System.out.println("Introduzca el nombre: ");
        String name = scan.nextLine();
        
        System.out.println("Introduzca la id");
        int id = scan.nextInt();
        
        
        if(("".equals(name))||("".equals(id))){
            System.out.println("Non comand recibed");
        }else{
            SedeDAO.borrarSede(name, id);
            yep = true;
        }
       
        return yep;
        
    }
    
    //__________________________________________________________________________________________________________________________________________________________________________________-
    
     public static ResultSet mostrarComplejo() throws SQLException{
        
        System.out.println("¿Desea mostrar todos o solo buscar por nombre?");
        System.out.println("1.- Por Nombre");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        ResultSet resultado= null;
        
        switch(op){
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique el nombre del Complejo que desea inspeccionar");
                String nombre = scn.nextLine();
                resultado = ComplejoDAO.mostrarComplejo(nombre);  
                break;
            case 2:
                resultado = ComplejoDAO.mostrarTodosComplejos();
                break;
        }
        return resultado;
       
    }
     
    //________________________________________________________________________________________________________________________________________________________________________________________________________________
    
    public static ResultSet mostrarArea() throws SQLException{
        
        ResultSet resultado= null;
        
        System.out.println("¿Desea mostrar todos o solo buscar por nombre?");
        System.out.println("1.- Por Nombre");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        
        
        switch(op){
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique La direccion");
                String local = scn.nextLine();
                System.out.println("Especifique el deporte a practicar");
                String deporte = scn.nextLine();
                Area area= new Area(local,deporte);
                resultado = AreaDAO.mostrar(area);  
            case 2:
                resultado = AreaDAO.mostrarTodas();
        }
        return resultado;
       
    }
    
    public static boolean crearArea() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);  
        
        System.out.println("Introduzca la id del polideportivo en el que va a esta situado: ");
        int id_m = scan.nextInt();
        
        System.out.println("Introduzca la localizacion: ");
        String local = scn.nextLine();
        
        System.out.println("Introduzca su DNI");
        String deporte = scn.nextLine();
        
        
        if(("".equals(local))||("".equals(deporte))){
            System.out.println("Non comand recibed");
        }else{
            AreaDAO.crear(local,deporte,id_m);
            yep = true;
        }
        return yep;
    }
    
    public static boolean modificarArea() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);
        
        
        System.out.println("Introduzca el ID del area que vaya a cambiar");
        int id=scn.nextInt();
        
        System.out.println("Introduzca el ID del centro polideportivo");
        int id_m=scn.nextInt();
        
        
        System.out.println("Introduzca Localizacion: ");
        String local = scan.nextLine();
        
        System.out.println("Introduzca el deporte:");
        String deporte = scan.nextLine();
        
        
        
        
        if(("".equals(local))||("".equals(id))){
            System.out.println("Non comand recibed");
        }else{
            AreaDAO.modificar(id, local,deporte,id_m);
            yep = true;
        }
       
        return yep;
        
    }
    
    public static boolean borrarArea() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);       
        
        System.out.println("Especifique La direccion");
        String local = scn.nextLine();
        System.out.println("Especifique el deporte a practicar");
        String deporte = scn.nextLine();
        Area area= new Area(local,deporte);
        
        
        if(("".equals(local))||("".equals(deporte))){
            System.out.println("Non comand recibed");
        }else{
            AreaDAO.borrar(area);
            yep = true;
        }
       
        return yep;
        
    }
    
    
    //_______________________________________________________________________________________________________________________________________________________________
    
    
    
    
    
    public static ResultSet mostrarMaterial() throws SQLException{
        
        ResultSet resultado= null;
        
        System.out.println("¿Desea mostrar todos o solo buscar por nombre?");
        System.out.println("1.- Por Nombre");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        
        
        switch(op){
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique el material");
                String l = scn.nextLine();
                
                Material m= new Material(l);
                resultado = MaterialDAO.mostrar(m);  
            case 2:
                resultado = MaterialDAO.mostrarTodas();
        }
        return resultado;
       
    }
    
    public static boolean crearMaterial() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);  
        
        System.out.println("Introduzca el MATERIAL: ");
        String l = scn.nextLine();

        
        if("".equals(l)){
            System.out.println("Non comand recibed");
        }else{
            MaterialDAO.crear(l);
            yep = true;
        }
        return yep;
    }
    
    public static boolean modificarMaterial() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);
        
        
        System.out.println("Introduzca el ID del area que vaya a cambiar");
        int id=scn.nextInt();

        
        System.out.println("Introduzca Material: ");
        String l = scan.nextLine();
        
 
        
        
        
        
        if(("".equals(l))||("".equals(id))){
            System.out.println("Non comand recibed");
        }else{
            MaterialDAO.modificar(id, l);
            yep = true;
        }
       
        return yep;
        
    }
    
    public static boolean borrarMaterial() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);       
        
        System.out.println("Especifique Material para BORRAR");
        String l = scn.nextLine();
    
        Material m= new Material(l);
        
        
        if("".equals(l)){
            System.out.println("Non comand recibed");
        }else{
            MaterialDAO.borrar(m);
            yep = true;
        }
       
        return yep;
        
    }
    
    //_____________________________________________________________________________________________________________________________________________________________________________________________

    public static ResultSet mostrarUnideportivo() throws SQLException{
        
        ResultSet resultado= null;
        
        System.out.println("¿Desea mostrar todos o solo buscar por nombre?");
        System.out.println("1.- Por Nombre");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        
        
        switch(op){
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique el material");
                String l = scn.nextLine();
                
                Material m= new Material(l);
                resultado = MaterialDAO.mostrar(m);  
            case 2:
                resultado = MaterialDAO.mostrarTodas();
        }
        return resultado;
       
    }
    
    public static boolean crearUnideportivo() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);  
        
        System.out.println("Introduzca el Deporte: ");
        String l = scn.nextLine();
        System.out.println("Introduzca Informacion sobre el deporte: ");
        String a = scn.nextLine();
        
        
        System.out.println("Introduzca la localización del complejo: ");
        String c = scn.nextLine();
        System.out.println("Introduzca Jefe: ");
        String s = scn.nextLine();
        System.out.println("Introduzca id de la sede a la que pertenece ");
        int f = scn.nextInt();
        
        Complejo com = new Complejo(c,s,f);
        
        Unideportivo un = new Unideportivo(l,a,c,s,f);
       

        
        if("".equals(l)){
            System.out.println("Non comand recibed");
        }else{
            UnideportivoDAO.crear(un);
            yep = true;
        }
        return yep;
    }
    
    public static boolean modificarUnideportivo() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);
        
        
        System.out.println("Introduzca el ID del Complejo que vaya a cambiar");
        int id=scn.nextInt();

        
        System.out.println("Introduzca deporte: ");
        String l = scan.nextLine();
        
        System.out.println("Introduzca nueva informacion: ");
        String i = scan.nextLine();
        

        if(("".equals(l))||("".equals(id))){
            System.out.println("Non comand recibed");
        }else{
            UnideportivoDAO.modificar(id, l,i);
            yep = true;
        }
       
        return yep;
        
    }
    
    public static boolean borrarUnideportivo() throws SQLException{
        boolean yep=false;
        Scanner scn=new Scanner(System.in);       
        
        System.out.println("Especifique Material para BORRAR");
        String l = scn.nextLine();
    
        Material m= new Material(l);
        
        
        if("".equals(l)){
            System.out.println("Non comand recibed");
        }else{
            MaterialDAO.borrar(m);
            yep = true;
        }
       
        return yep;
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    



}
