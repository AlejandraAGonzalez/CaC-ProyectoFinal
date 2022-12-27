package com.example.cacproyectofinal;

import java.sql.Connection;
import java.sql.DriverManager;
public class AdministradorDeConexiones {
    AdministradorDeConexiones conexion = DriverManager.getConnection("jdbc:mysql://localhost/Estudiantes","root","");
}
