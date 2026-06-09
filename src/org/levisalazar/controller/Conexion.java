package org.levisalazar.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/HotelParaisoDB"; 
        String usuario = "root";
        String contrasenia = "root";

        System.out.println("Iniciando el proceso de conexión...");
        
        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasenia)) {
            
            System.out.println("¡PASO 2 COMPLETADO: Conexión establecida con éxito!");
            
            String sql = "SELECT 'Conexión de prueba exitosa desde Java' AS Mensaje";
            
            try (Statement sentencia = conexion.createStatement()) {
                               
                sentencia.executeQuery(sql);
                System.out.println("¡PASO 3 COMPLETADO: Sentencia SQL ejecutada correctamente!");
                
            } //cierra Statement

        } catch (SQLException e) {
            System.out.println("Error en el proceso de base de datos: " + e.getMessage());
            System.out.println("Código de error SQL: " + e.getErrorCode());
        }
        System.out.println("PASO 4 FINALIZADO: Canal de conexión cerrado de forma segura.");
    }
}
