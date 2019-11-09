/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Modelo.Conexion;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.jcp.xml.dsig.internal.dom.Utils;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class EstructuraDAO {
    private static Conexion newcon = Conexion.getInstance();
    
   
    public static boolean generarEstructura() {
        boolean generada = true;
        //Cadena donde irán las sentencias sql de creación de tablas
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;
        try {
    
            lineaSQL = "DROP DATABASE `olympics`;";
             // lineaSQL =  "USE `olympics`;";
             //conectamos la sentencia a la base de datos
            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.execute(lineaSQL);
            
            lineaSQL = "CREATE DATABASE IF NOT EXISTS `olympics`; USE `olympics`;";
             // lineaSQL =  "USE `olympics`;";
             //conectamos la sentencia a la base de datos
            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.execute(lineaSQL);
            
            
            lineaSQL = "CREATE TABLE IF NOT EXISTS `area`(" +
                "  `id` int(11) NOT NULL," +
                "  `id_multisportcenter` int(11) NOT NULL," +
                "  `location` varchar(50) NOT NULL," +
                "  `sport` varchar(50) NOT NULL" +
                ");";

            //conectamos la sentencia a la base de datos
            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.execute(lineaSQL);
            
            lineaSQL = "INSERT INTO `area` (`id`, `id_multisportcenter`, `location`, `sport`) VALUES" +
                "(1, 1, 'Pistas', 'Atletismo')," +
                "(2, 1, 'Campo', 'Rugbi')," +
                "(3, 3, 'Pista', 'Atletismo')," +
                "(4, 3, 'Campo', 'Fútbol');";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);          
            

            //HAY QUE REPETIR ESTA OPERACIÓN PARA CADA UNA DE LAS TABLAS
            lineaSQL = "CREATE TABLE `comissioner_event` (" +
                "  `id` int(11) NOT NULL," +
                "  `id_event` int(11) NOT NULL," +
                "  `id_comissioner` int(11) NOT NULL," +
                "  `rol` varchar(50) NOT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "INSERT INTO `comissioner_event` (`id`, `id_event`, `id_comissioner`, `rol`) VALUES" +
                "(1, 7, 1, 'JUEZ')," +
                "(2, 7, 2, 'OBSERVADOR');";
            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            

            lineaSQL = "CREATE TABLE `commissioner` (" +
                "  `id` int(11) NOT NULL," +
                "  `dni` varchar(10) NOT NULL," +
                "  `name` varchar(50) NOT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "INSERT INTO `commissioner` (`id`, `dni`, `name`) VALUES" +
                "(1, '00000000-T', 'Felipe')," +
                "(2, '00000001-R', 'María')," +
                "(4, '00000002-R', 'Julian')," +
                "(5, 'V2', 'Daniel')," +
                "(6, '20228885V', 'Daniel')," +
                "(7, '30829111W', 'Antonio');";
            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            

            lineaSQL = "CREATE TABLE `equipment` (" +
                "  `id` int(11) NOT NULL," +
                "  `name` varchar(50) NOT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "INSERT INTO `equipment` (`id`, `name`) VALUES" +
                "(1, 'CortaCesped')," +
                "(2, 'Balón');";
            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            

            lineaSQL = "CREATE TABLE `equipment_event` (" +
                "  `id` int(11) NOT NULL," +
                "  `id_equipment` int(11) NOT NULL," +
                "  `id_event` int(11) NOT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
             lineaSQL = "INSERT INTO `equipment_event` (`id`, `id_equipment`, `id_event`) VALUES" +
                "(1, 2, 1)," +
                "(2, 2, 7);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            
            
            

            lineaSQL = "CREATE TABLE `event` (" +
                "  `id` int(11) NOT NULL," +
                "  `name` varchar(50) NOT NULL," +
                "  `date` timestamp NOT NULL DEFAULT current_timestamp()," +
                "  `id_sportcomplex` int(11) NOT NULL," +
                "  `id_area` int(11) DEFAULT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
              lineaSQL = "INSERT INTO `event` (`id`, `name`, `date`, `id_sportcomplex`, `id_area`) VALUES" +
                "(1, 'España-Italia', '2019-10-22 22:00:00', 1, 2)," +
                "(2, '100 metros liso', '2019-10-23 22:00:00', 1, 1)," +
                "(4, 'CAJASUR-BADALONA', '2019-10-04 22:00:00', 2, 0)," +
                "(5, 'ITALIA-BELGICA', '2019-10-29 23:00:00', 3, 1)," +
                "(6, '200M VALLAS', '2019-10-30 23:00:00', 3, 2)," +
                "(7, 'BETIS-SEVILLA', '2019-10-18 22:00:00', 4, NULL);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            
            
            
            lineaSQL = "CREATE TABLE `headquarter` (" +
                "  `id` int(11) NOT NULL," +
                "  `name` varchar(50) NOT NULL," +
                "  `budget` float(9,2) NOT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);        
            
            lineaSQL = "INSERT INTO `headquarter` (`id`, `name`, `budget`) VALUES" +
                "(1, 'Córdoba', 1000000.00)," +
                "(2, 'Sevilla', 2000000.00);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL); 
            
            
            
            
            
            
             lineaSQL = "CREATE TABLE `multisportcenter` (" +
                "  `id_sportcomplex` int(11) NOT NULL," +
                "  `information` varchar(50) NOT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
             lineaSQL = "INSERT INTO `multisportcenter` (`id_sportcomplex`, `information`) VALUES" +
                "(1, 'Lejos de la ciudad')," +
                "(3, 'Bien comunicado');";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            
            
            
             lineaSQL = "CREATE TABLE `sportcenter` (" +
                "  `id_sportcomplex` int(11) NOT NULL," +
                "  `sport` varchar(50) NOT NULL," +
                "  `information` varchar(50) NOT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
             lineaSQL = "INSERT INTO `sportcenter` (`id_sportcomplex`, `sport`, `information`) VALUES" +
                "(2, 'Basket', 'Nada reseñable')," +
                "(4, 'Fútbol', 'Musho Betis!');";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            
            
             lineaSQL = "CREATE TABLE `sportcomplex` (" +
                "  `id` int(11) NOT NULL," +
                "  `location` varchar(50) NOT NULL," +
                "  `boss` varchar(50) NOT NULL," +
                "  `id_headquarter` int(11) NOT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);           
            
             lineaSQL = "INSERT INTO `sportcomplex` (`id`, `location`, `boss`, `id_headquarter`) VALUES" +
                "(1, 'Rabanales', 'Carlos', 1)," +
                "(2, 'Vistaalegre', 'Eva', 1)," +
                "(3, 'Estadio Olímpico', 'Pepe', 2)," +
                "(4, 'Estadio del Betis', 'Juan', 2);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            
            
            
            
            
            
            
            
            
            
            lineaSQL = "ALTER TABLE `area`" +
                "  ADD PRIMARY KEY (`id`)," +
                "  ADD KEY `id_sportcomlex` (`id_multisportcenter`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `comissioner_event`" +
                "  ADD PRIMARY KEY (`id`)," +
                "  ADD KEY `evento` (`id_event`)," +
                "  ADD KEY `comisario` (`id_comissioner`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `commissioner`" +
                "  ADD PRIMARY KEY (`id`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `equipment`" +
                "  ADD PRIMARY KEY (`id`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `equipment_event`" +
                "  ADD PRIMARY KEY (`id`)," +
                "  ADD KEY `equipamiento` (`id_equipment`)," +
                "  ADD KEY `enero` (`id_event`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `event`" +
                "  ADD PRIMARY KEY (`id`)," +
                "  ADD KEY `id_sportcomplex` (`id_sportcomplex`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `headquarter`" +
                "  ADD PRIMARY KEY (`id`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `multisportcenter`" +
                "  ADD PRIMARY KEY (`id_sportcomplex`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `sportcenter`" +
                "  ADD PRIMARY KEY (`id_sportcomplex`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `sportcomplex`" +
                "  ADD PRIMARY KEY (`id`)," +
                "  ADD KEY `sede` (`id_headquarter`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `area`" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `comissioner_event`" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `commissioner`" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `equipment`" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `equipment_event`" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `event`" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `headquarter`" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `sportcomplex`" +
                "  ADD PRIMARY KEY (`id`)," +
                "  ADD KEY `sede` (`id_headquarter`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `sportcomplex`" +
                "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `area`" +
                "  ADD CONSTRAINT `id_sportcomlex` FOREIGN KEY (`id_multisportcenter`) REFERENCES `multisportcenter` (`id_sportcomplex`) ON UPDATE CASCADE;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `comissioner_event`" +
                "  ADD CONSTRAINT `comisario` FOREIGN KEY (`id_comissioner`) REFERENCES `commissioner` (`id`) ON DELETE CASCADE ON UPDATE CASCADE," +
                "  ADD CONSTRAINT `evento` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;";

            sentencia = newcon.getConexion().createStatement();            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `equipment_event`" +
                "  ADD CONSTRAINT `enero` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE," +
                "  ADD CONSTRAINT `equipamiento` FOREIGN KEY (`id_equipment`) REFERENCES `equipment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;";

            sentencia = newcon.getConexion().createStatement();            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `event`" +
                "  ADD CONSTRAINT `id_sportcomplex` FOREIGN KEY (`id_sportcomplex`) REFERENCES `sportcomplex` (`id`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `multisportcenter`" +
                "  ADD CONSTRAINT `complex` FOREIGN KEY (`id_sportcomplex`) REFERENCES `sportcomplex` (`id`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            lineaSQL = "ALTER TABLE `sportcenter`" +
                "  ADD CONSTRAINT `sededemono` FOREIGN KEY (`id_sportcomplex`) REFERENCES `sportcomplex` (`id`);";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            lineaSQL = "ALTER TABLE `sportcomplex`" +
                "  ADD CONSTRAINT `sede` FOREIGN KEY (`id_headquarter`) REFERENCES `headquarter` (`id`);" +
                "COMMIT;";

            sentencia = newcon.getConexion().createStatement();
            //ejecutamos la sentencia;
            sentencia.executeUpdate(lineaSQL);
            
            
            
            
            
            
            
            
            

        } catch (SQLException se) {
            generada = false;
            se.printStackTrace();
        }

        return generada;

    }
}
